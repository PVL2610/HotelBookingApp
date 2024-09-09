package com.example.hotelbooking_app.Booking.AsyncTask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.hotelbooking_app.Booking.Api.PaymentApiService;
import com.example.hotelbooking_app.Booking.Api.PaymentRetrofitClient;

import retrofit2.Call;
import retrofit2.Response;

public class DeletePaymentApi extends AsyncTask<Void, Void, Boolean> {
    private Context context;
    private String authToken;
    private int paymentId;

    public DeletePaymentApi(Context context, String authToken, int paymentId) {
        this.context = context;
        this.authToken = authToken;
        this.paymentId = paymentId;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        PaymentApiService paymentApiService = PaymentRetrofitClient.getRetrofitInstance().create(PaymentApiService.class);
        Call<Void> call = paymentApiService.deletePayment("Bearer " + authToken, String.valueOf(paymentId));

        try {
            Response<Void> response = call.execute();

            if (response.isSuccessful()) {
                Log.e("API RESPONSE SUCCESS - DELETE", "Successfully");
                return true;
            } else {
                Log.e("API RESPONSE ERROR - DELETE", "Unsuccessful: " + response.code());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("API CALL FAILURE - DELETE", "Network failure");
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean success) {
        if (success) {
            // Handle success, e.g., refresh the UI or show a success message
        } else {
            // Handle failure or show an error message
        }
    }
}
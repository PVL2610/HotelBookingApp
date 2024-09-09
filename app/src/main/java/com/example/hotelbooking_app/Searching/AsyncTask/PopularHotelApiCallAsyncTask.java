package com.example.hotelbooking_app.Searching.AsyncTask;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.example.hotelbooking_app.Searching.API.HotelApiRespone;
import com.example.hotelbooking_app.Searching.API.HotelApiService;
import com.example.hotelbooking_app.Searching.API.HotelRetrofitClient;
import com.example.hotelbooking_app.Searching.Domain.Hotel;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class PopularHotelApiCallAsyncTask extends AsyncTask<Void, Void, List<Hotel>> {
    private Context context;
    private ApiCallListener listener;

    public interface ApiCallListener {
        void onApiCallSuccess(List<Hotel> popularHotels);
        void onApiCallFailure(String errorMessage);
    }

    public PopularHotelApiCallAsyncTask(Context context, ApiCallListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected List<Hotel> doInBackground(Void... voids) {
        SharedPreferences preferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String authToken = preferences.getString("jwtKey", null);
        if (authToken != null) {
            try {
                HotelApiService apiService = HotelRetrofitClient.getRetrofitInstance().create(HotelApiService.class);
                Call<HotelApiRespone> call = apiService.getAllPopularHotels("Bearer " + authToken);

                Response<HotelApiRespone> response = call.execute();
                if (response.isSuccessful() && response.body() != null) {
                    return response.body().getData();
                } else {
                    return null;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Hotel> popularHotels) {
        super.onPostExecute(popularHotels);

        if (popularHotels != null) {
            listener.onApiCallSuccess(popularHotels);
        } else {
            listener.onApiCallFailure("API call failed");
        }
    }
}

package com.example.hotelbooking_app.Login.AsynTask;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.example.hotelbooking_app.Login.AuthService.AccessTokenJson;
import com.example.hotelbooking_app.Login.AuthService.AuthEnpoint;
import com.example.hotelbooking_app.Login.AuthService.AuthenticationCallback;
import com.example.hotelbooking_app.Login.AuthService.AuthenticationRequest;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Header;

public class RefreshPasswordAsyntask extends AsyncTask<String, Void, Boolean> {
    private Context context;
    private AuthEnpoint authEnpoint;
    private AuthenticationCallback callback;

    public RefreshPasswordAsyntask(Context context, AuthEnpoint authEnpoint, AuthenticationCallback callback) {
        this.context = context;
        this.authEnpoint = authEnpoint;
        this.callback = callback;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        String jwt = strings[0];
        Call<AccessTokenJson> call = authEnpoint.refreshToken(jwt);

        try {
            Response<AccessTokenJson> response = call.execute();
            if (response.isSuccessful()) {
                AccessTokenJson authenticationResponse = response.body();
                String jwtToken = authenticationResponse.getAccessToken();
                SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("jwtKey", jwtToken);
                editor.putLong("lastPuttedJwtTime", System.currentTimeMillis());
                editor.apply();
                return true;
            } else {
                Log.e("JWT", "Thong tin dang nhap bi sai roi");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    protected void onPostExecute(Boolean success) {
        if (success)
            callback.onSuccess();
        callback.onFailure();
    }
}

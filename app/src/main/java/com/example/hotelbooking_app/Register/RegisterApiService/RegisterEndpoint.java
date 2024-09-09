package com.example.hotelbooking_app.Register.RegisterApiService;

import com.example.hotelbooking_app.Login.AuthService.AccessTokenJson;
import com.example.hotelbooking_app.Register.dto.RegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterEndpoint {

    @POST("/api/v1/auth/register")
    Call<AccessTokenJson> signup(@Body RegisterRequest registerRequest);
}

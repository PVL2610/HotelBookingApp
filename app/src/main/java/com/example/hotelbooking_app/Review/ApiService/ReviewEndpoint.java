package com.example.hotelbooking_app.Review.ApiService;

import com.example.hotelbooking_app.AdditionalProfile.Dto.ResponseData;
import com.example.hotelbooking_app.Review.dto.ReviewRequest;
import com.example.hotelbooking_app.Review.dto.ReviewResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ReviewEndpoint {
    @GET("/api/v1/review/{hotelId}")
    Call<ResponseData> getReview(@Header("authorization") String jwtToken, @Path("hotelId") Long hotelId);
    @POST("/api/v1/review/{hotelId}")
    Call<ResponseData> createReview(@Header("authorization") String jwtToken, @Path("hotelId") Long hotelId, @Body ReviewRequest reviewRequest);
}

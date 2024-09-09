package com.example.hotelbooking_app.Review.ApiService;

import com.example.hotelbooking_app.Review.dto.ReviewResponse;

import java.util.List;

public interface ICallBack {
    void onSuccess(List<ReviewResponse> reviewResponses);
    void onFailure();
}

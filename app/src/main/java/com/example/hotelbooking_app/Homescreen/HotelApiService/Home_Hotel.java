package com.example.hotelbooking_app.Homescreen.HotelApiService;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Home_Hotel {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;
    @SerializedName("address")
    private String address;
    @SerializedName("price")
    private double price;

    @SerializedName("imageDetails")
    private List<Home_ImageDetail> imageDetails;
    @SerializedName("reviewQuantity")
    private int reviewQuantity;
    @SerializedName("rate")
    private double rate;
    @SerializedName("isFavourited")
    private boolean isFavourited;

    public boolean isFavourited() {
        return isFavourited;
    }

    public void setFavourited(boolean favourited) {
        isFavourited = favourited;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getReviewQuantity() {
        return reviewQuantity;
    }

    public void setReviewQuantity(int reviewQuantity) {
        this.reviewQuantity = reviewQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Home_ImageDetail> getImageDetails() {
        return imageDetails;
    }

    public void setImageDetails(List<Home_ImageDetail> imageDetails) {
        this.imageDetails = imageDetails;
    }

}


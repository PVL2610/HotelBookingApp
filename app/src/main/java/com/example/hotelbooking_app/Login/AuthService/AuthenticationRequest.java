package com.example.hotelbooking_app.Login.AuthService;


import com.google.gson.annotations.SerializedName;

public class AuthenticationRequest {
    @SerializedName("password")
    private String password;
    @SerializedName("email")
    private String email;

    public AuthenticationRequest(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

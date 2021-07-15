package com.forever.network;


import com.forever.Model.ExistsPhoneEmailModel;
import com.forever.Model.LoginModel;
import com.forever.Model.OnBoardingModel;
import com.forever.Model.PhoneSignupResponseModel;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface BaseApiMethods {
    @GET("app/settings")
    Call<OnBoardingModel> onBoarding();

    @POST("user/phone-exists")
    Call<ExistsPhoneEmailModel>existPhone(@Body JsonObject jsonObject);

//    @GET("user/email-exists")
//    Call<ExistsPhoneEmailModel> emailExist(@Query("email") String email);

    @POST("user/signup")
    Call<PhoneSignupResponseModel> phoneSignup(@Body JsonObject object);

    @POST("user/signin")
    Call<LoginModel> loginwithPhone(@Body JsonObject object);



}


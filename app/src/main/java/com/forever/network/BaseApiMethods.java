package com.forever.network;


import com.forever.Model.ExistsPhoneEmailModel;
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
    @GET("api/app/settings")
    Call<OnBoardingModel> onBoarding();

    @GET("user/email-exists{input}")
    Call<ExistsPhoneEmailModel> emailExist(@Path(value = "input") String email);

    @POST("api/user/signup")
    Call<PhoneSignupResponseModel> phoneSignup(@Body JsonObject object);

//    @POST("api/user/signin")
//    Call<PhoneSignupResponseModel> phoneSignup(@Body JsonObject object);



}


package com.forever.network;


import com.forever.Model.OnBoardingModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface BaseApiMethods {
    @GET("api/app/settings")
    Call<OnBoardingModel> onBoarding();
//
//    @POST("save-Employer")
//    Call<ClsEmployerResponseModel> employerData(@Body JsonObject object);



}

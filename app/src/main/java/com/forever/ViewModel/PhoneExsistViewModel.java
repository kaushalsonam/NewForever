package com.forever.ViewModel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.forever.Model.ExistsPhoneEmailModel;
import com.forever.network.ApiClient;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneExsistViewModel extends ViewModel {

    public MutableLiveData<ExistsPhoneEmailModel> phoneExists = new MutableLiveData<>();



    public void exsistPhone(Context context, JsonObject jsonObject){

        ApiClient.getBaseApiMethods().existPhone(jsonObject).enqueue(new Callback<ExistsPhoneEmailModel>() {
            @Override
            public void onResponse(Call<ExistsPhoneEmailModel> call, Response<ExistsPhoneEmailModel> response) {

                if(response.isSuccessful()){

                    ExistsPhoneEmailModel model= response.body();
                    if(response.body()!=null){

                        phoneExists.postValue(model);

                    }

                }

            }

            @Override
            public void onFailure(Call<ExistsPhoneEmailModel> call, Throwable t) {

            }
        });
    }

}

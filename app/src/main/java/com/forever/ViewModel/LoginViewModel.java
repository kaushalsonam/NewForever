package com.forever.ViewModel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.forever.Model.LoginModel;
import com.forever.network.ApiClient;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {


    public MutableLiveData<LoginModel> login = new MutableLiveData<>();


    public void userLogin(Context context, JsonObject jsonObject) {

        ApiClient.getBaseApiMethods().loginwithPhone(jsonObject).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                if (response.isSuccessful()) {

                    LoginModel model = response.body();

                    if (response.body() != null) {

                        login.postValue(model);

                    }


                } else {

                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }


}

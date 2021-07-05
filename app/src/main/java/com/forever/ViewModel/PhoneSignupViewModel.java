package com.forever.ViewModel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.forever.Model.PhoneSignupResponseModel;
import com.forever.network.ApiClient;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneSignupViewModel extends ViewModel {

   public MutableLiveData<PhoneSignupResponseModel> signupwithphone = new MutableLiveData<>();


    public void phoneSignup(JsonObject jsonObject, Context context) {

        ApiClient.getBaseApiMethods().phoneSignup(jsonObject).enqueue(new Callback<PhoneSignupResponseModel>() {
            @Override
            public void onResponse(Call<PhoneSignupResponseModel> call, Response<PhoneSignupResponseModel> response) {

                if (response.isSuccessful()) {

                    PhoneSignupResponseModel model = response.body();
                    if (response.body() != null) {

                        signupwithphone.postValue(model);

                    }

                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<PhoneSignupResponseModel> call, Throwable t) {

                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}

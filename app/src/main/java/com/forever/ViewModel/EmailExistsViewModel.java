package com.forever.ViewModel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.forever.Model.ExistsPhoneEmailModel;
import com.forever.Model.OnBoardingModel;
import com.forever.network.ApiClient;
import com.forever.utilities.Utility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmailExistsViewModel extends ViewModel {

    public MutableLiveData<ExistsPhoneEmailModel> emailExists = new MutableLiveData<>();


//    public void EmailExists(Context context, String email) {
//
//        ApiClient.getBaseApiMethods().emailExist(email).enqueue(new Callback<ExistsPhoneEmailModel>() {
//            @Override
//            public void onResponse(Call<ExistsPhoneEmailModel> call, Response<ExistsPhoneEmailModel> response) {
//
////                Utility.showLoader();
//                if (response.isSuccessful()) {
//
////                    Utility.hideLoader();
//                    ExistsPhoneEmailModel model = response.body();
//                    if (response.body() != null) {
//
//                        emailExists.postValue(model);
//                    }
//
//                } else {
//
//                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ExistsPhoneEmailModel> call, Throwable t) {
//
////                Utility.hideLoader();
//                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//    }

}

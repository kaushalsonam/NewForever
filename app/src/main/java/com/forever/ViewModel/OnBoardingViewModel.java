package com.forever.ViewModel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.forever.Model.OnBoardingModel;
import com.forever.network.ApiClient;
import com.forever.utilities.Utility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnBoardingViewModel extends ViewModel {

    public MutableLiveData<OnBoardingModel> onBoarding = new MutableLiveData<>();


    public void onBoardingScreen(Context context) {

//        Utility.showLoader();


        ApiClient.getBaseApiMethods().onBoarding().enqueue(new Callback<OnBoardingModel>() {
            @Override
            public void onResponse(Call<OnBoardingModel> call, Response<OnBoardingModel> response) {

//                Utility.hideLoader();

                if (response.isSuccessful()) {

                    OnBoardingModel model = response.body();

                    if (response.body() != null) {

                        onBoarding.postValue(model);
                        Toast.makeText(context, "success", Toast.LENGTH_SHORT).show();
                    }

                }


            }

            @Override
            public void onFailure(Call<OnBoardingModel> call, Throwable t) {

                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }

}

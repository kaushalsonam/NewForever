package com.forever.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OnBoardingModel {


    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Data {

        @SerializedName("appVersion")
        @Expose
        private String appVersion;
        @SerializedName("onboarding_text_1")
        @Expose
        private String onboardingText1;
        @SerializedName("onboarding_text_2")
        @Expose
        private String onboardingText2;
        @SerializedName("onboarding_text_3")
        @Expose
        private String onboardingText3;


        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public String getOnboardingText1() {
            return onboardingText1;
        }

        public void setOnboardingText1(String onboardingText1) {
            this.onboardingText1 = onboardingText1;
        }

        public String getOnboardingText2() {
            return onboardingText2;
        }

        public void setOnboardingText2(String onboardingText2) {
            this.onboardingText2 = onboardingText2;
        }

        public String getOnboardingText3() {
            return onboardingText3;
        }

        public void setOnboardingText3(String onboardingText3) {
            this.onboardingText3 = onboardingText3;
        }
    }
}
package com.forever.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginModel {

    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("object")
    @Expose
    private String object;
    @SerializedName("data")
    @Expose
    private Data data;


    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("full_name")
        @Expose
        private String fullName;
        @SerializedName("phone_code")
        @Expose
        private Integer phoneCode;
        @SerializedName("phone_number")
        @Expose
        private String phoneNumber;
        @SerializedName("age")
        @Expose
        private Object age;
        @SerializedName("gender")
        @Expose
        private Object gender;
        @SerializedName("email")
        @Expose
        private Object email;
        @SerializedName("lat")
        @Expose
        private Object lat;
        @SerializedName("lng")
        @Expose
        private Object lng;
        @SerializedName("location")
        @Expose
        private Object location;
        @SerializedName("total_points")
        @Expose
        private Object totalPoints;
        @SerializedName("redeemed")
        @Expose
        private Object redeemed;
        @SerializedName("facebook_id")
        @Expose
        private Object facebookId;
        @SerializedName("google_id")
        @Expose
        private Object googleId;
        @SerializedName("apple_id")
        @Expose
        private Object appleId;
        @SerializedName("email_verified")
        @Expose
        private Boolean emailVerified;
        @SerializedName("phone_verified")
        @Expose
        private Boolean phoneVerified;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("profile_score")
        @Expose
        private Integer profileScore;
        @SerializedName("user_devices")
        @Expose
        private List<UserDevice> userDevices = null;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("notification_count")
        @Expose
        private Integer notificationCount;
        @SerializedName("token")
        @Expose
        private String token;


        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Integer getPhoneCode() {
            return phoneCode;
        }

        public void setPhoneCode(Integer phoneCode) {
            this.phoneCode = phoneCode;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getLat() {
            return lat;
        }

        public void setLat(Object lat) {
            this.lat = lat;
        }

        public Object getLng() {
            return lng;
        }

        public void setLng(Object lng) {
            this.lng = lng;
        }

        public Object getLocation() {
            return location;
        }

        public void setLocation(Object location) {
            this.location = location;
        }

        public Object getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints(Object totalPoints) {
            this.totalPoints = totalPoints;
        }

        public Object getRedeemed() {
            return redeemed;
        }

        public void setRedeemed(Object redeemed) {
            this.redeemed = redeemed;
        }

        public Object getFacebookId() {
            return facebookId;
        }

        public void setFacebookId(Object facebookId) {
            this.facebookId = facebookId;
        }

        public Object getGoogleId() {
            return googleId;
        }

        public void setGoogleId(Object googleId) {
            this.googleId = googleId;
        }

        public Object getAppleId() {
            return appleId;
        }

        public void setAppleId(Object appleId) {
            this.appleId = appleId;
        }

        public Boolean getEmailVerified() {
            return emailVerified;
        }

        public void setEmailVerified(Boolean emailVerified) {
            this.emailVerified = emailVerified;
        }

        public Boolean getPhoneVerified() {
            return phoneVerified;
        }

        public void setPhoneVerified(Boolean phoneVerified) {
            this.phoneVerified = phoneVerified;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Integer getProfileScore() {
            return profileScore;
        }

        public void setProfileScore(Integer profileScore) {
            this.profileScore = profileScore;
        }

        public List<UserDevice> getUserDevices() {
            return userDevices;
        }

        public void setUserDevices(List<UserDevice> userDevices) {
            this.userDevices = userDevices;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Integer getNotificationCount() {
            return notificationCount;
        }

        public void setNotificationCount(Integer notificationCount) {
            this.notificationCount = notificationCount;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }




    public class UserDevice {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("device_type")
        @Expose
        private String deviceType;
        @SerializedName("device_token")
        @Expose
        private String deviceToken;
        @SerializedName("created_at")
        @Expose
        private String createdAt;


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getDeviceToken() {
            return deviceToken;
        }

        public void setDeviceToken(String deviceToken) {
            this.deviceToken = deviceToken;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }
    }


}

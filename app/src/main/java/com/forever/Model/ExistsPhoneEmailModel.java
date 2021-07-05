package com.forever.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExistsPhoneEmailModel {

    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("exists")
    @Expose
    private Boolean exists;

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }
}

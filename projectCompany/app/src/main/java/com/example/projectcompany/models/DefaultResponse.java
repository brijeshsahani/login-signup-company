package com.example.projectcompany.models;

public class DefaultResponse {
    private boolean result;
    private String responsemsg,responsecode;
    private User data;

    public DefaultResponse(boolean result, String responsemsg, String responsecode, User data) {
        this.result = result;
        this.responsemsg = responsemsg;
        this.responsecode = responsecode;
        this.data = data;
    }

    public boolean isResult() {
        return result;
    }

    public String getResponsemsg() {
        return responsemsg;
    }

    public String getResponsecode() {
        return responsecode;
    }

    public User getData() {
        return data;
    }

}

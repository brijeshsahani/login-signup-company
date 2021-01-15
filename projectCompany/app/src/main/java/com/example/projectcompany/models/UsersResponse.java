package com.example.projectcompany.models;

import java.util.List;

public class UsersResponse {

    private Boolean result;
    private String responsecode;
    private List<User> responsemsg;

    public UsersResponse(Boolean result, String responsecode, List<User> responsemsg) {
        this.result = result;
        this.responsecode = responsecode;
        this.responsemsg = responsemsg;
    }

    public Boolean getResult() {
        return result;
    }

    public String getResponsecode() {
        return responsecode;
    }

    public List<User> getResponsemsg() {
        return responsemsg;
    }


}

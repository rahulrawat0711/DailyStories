package com.example.appinventiv.dailystories.pojo;

/**
 * Created by appinventiv on 21/4/18.
 */

public class FailureResponse {
    private int errorCode;
    private String msg;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

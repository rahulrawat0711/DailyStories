package com.example.appinventiv.dailystories.base;

import com.example.appinventiv.dailystories.pojo.FailureResponse;

/**
 * Created by appinventiv on 21/4/18.
 */

public interface BaseView {

    void showNoNetworkError();
    void showToastLong(String messaage);
    void showSpecificError(FailureResponse failureResponse);
}

package com.example.appinventiv.dailystories.base;

import com.example.appinventiv.dailystories.pojo.FailureResponse;

/**
 * Created by appinventiv on 21/4/18.
 */

public interface BaseModelListener {

     void noNetworkError();
     void onErrorOccured(FailureResponse failureResponse);
}

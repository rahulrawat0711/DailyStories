package com.example.appinventiv.dailystories.network;

import com.example.appinventiv.dailystories.pojo.FailureResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class NetworkResponse<T> implements Callback<T> {
    private CommonResponseHandler handler;
    public NetworkResponse(CommonResponseHandler handler)
    {
        this.handler=handler;
    }

    public abstract void onSuccess(T body);
    public abstract void onFailure(int code, FailureResponse failureResponse);
    public abstract void onError(Throwable t);
    protected void failure(int code,FailureResponse failureResponse)
    {
        onFailure(code,failureResponse);
    }
    protected void error(Throwable t)
    {
        onError(t);
    }
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
    if(response.isSuccessful()) {
        onSuccess(response.body());
    }
    else {
        failure(response.code(),getFailureResponse(call.request().url().url().getFile(),response));
    }
    }
    @Override
    public void onFailure(Call<T> call, Throwable t) {
        error(t);
    }
    protected final FailureResponse getFailureResponse(String url,Response<T> errorBody)
    {
        FailureResponse failureResponse=new FailureResponse();
        failureResponse.setMsg(errorBody.message());
        failureResponse.setErrorCode(errorBody.code());
        return failureResponse;
    }
}

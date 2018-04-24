package com.example.appinventiv.dailystories.base;

import com.example.appinventiv.dailystories.data.DataManager;
import com.example.appinventiv.dailystories.network.CommonResponseHandler;

import java.lang.ref.SoftReference;

/**
 * Created by appinventiv on 21/4/18.
 */

public class BaseModel<T extends BaseModelListener> implements CommonResponseHandler {

    SoftReference<T> listener;
    public BaseModel(T listener)
    {
        attachListener(listener);
    }

    private void attachListener(T listener) {
        this.listener=new SoftReference<T>(listener);
    }

    public T getListener()
    {
     return (listener!=null)?listener.get():null;
    }
    public void detachListener()
    {
        listener=null;

    }

    @Override
    public void onNetworkError() {
        noNetworkErrorOccur();
    }

    private void noNetworkErrorOccur()
    {
        getListener().noNetworkError();
    }

    public DataManager getDataManager()
    {
            return DataManager.getInstance();
    }
}

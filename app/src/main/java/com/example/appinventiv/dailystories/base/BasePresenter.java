package com.example.appinventiv.dailystories.base;

import com.example.appinventiv.dailystories.pojo.FailureResponse;

import java.lang.ref.SoftReference;


public abstract class BasePresenter<T extends BaseView> implements BaseModelListener  {

    private SoftReference<T> view;
    public BasePresenter(T view)
    {
        attachView(view);
        addModel();
    }
    public abstract void addModel();
    public abstract void destory();
    private void attachView(T view) {

        this.view=new SoftReference<T>(view);
    }

    public T getView() {
        return (view != null) ? view.get() : null;
    }
    @Override
    public void noNetworkError() {
            getView().showNoNetworkError();
    }
    @Override
    public void onErrorOccured(FailureResponse failureResponse) {
        getView().showSpecificError(failureResponse);
    }
    public void detachView()
    {
        view=null;
        destory();
    }

}

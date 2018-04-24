package com.example.appinventiv.dailystories.samplesplash;

import com.example.appinventiv.dailystories.base.BasePresenter;
import com.example.appinventiv.dailystories.base.BaseView;

/**
 * Created by appinventiv on 21/4/18.
 */

public class SplashPresenter extends BasePresenter<SplashView> {
    public SplashPresenter(SplashView view) {
        super(view);
        showStoriesActivity();
    }

    private void showStoriesActivity() {
        getView().showStoriesActivity();
    }

    @Override
    public void addModel() {
    }
    @Override
    public void destory() {

    }

}

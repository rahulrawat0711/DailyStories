package com.example.appinventiv.dailystories.samplesplash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.example.appinventiv.dailystories.R;
import com.example.appinventiv.dailystories.base.BaseActivity;
import com.example.appinventiv.dailystories.samplestories.StoriesActivity;

public class SplashActivity extends BaseActivity implements SplashView {
    SplashPresenter splashPresenter;
    @Override
    public int getResouceId() {
        return R.layout.layout_splash;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashPresenter=new SplashPresenter(this);
    }

    @Override
    public void showStoriesActivity() {

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,StoriesActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashPresenter.detachView();
    }
}

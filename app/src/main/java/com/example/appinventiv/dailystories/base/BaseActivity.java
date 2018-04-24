package com.example.appinventiv.dailystories.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.appinventiv.dailystories.R;
import com.example.appinventiv.dailystories.pojo.FailureResponse;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private RelativeLayout baseContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        baseContainer=findViewById(R.id.rl_base_container);
        attachLayout();
    }

    private void attachLayout() {
        if(getResouceId()!=-1)
        {
            removeLayout();
            RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
            LayoutInflater inflater=(LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
            if(inflater!=null)
            {
                View view=inflater.inflate(getResouceId(),null);
                baseContainer.addView(view,layoutParams);
            }
        }
    }

    private void removeLayout() {
       if(baseContainer.getChildCount()>0)
       {
           baseContainer.removeAllViews();
       }
    }

    public abstract int  getResouceId();


    @Override
    public void showNoNetworkError() {
        showToastLong("No network error");
    }

    @Override
    public void showToastLong(String messaage) {

        Toast.makeText(this,messaage,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSpecificError(FailureResponse failureResponse) {
            String message=(failureResponse!=null)?failureResponse.getErrorCode()+"-"+failureResponse.getMsg():getString(R.string.something_went_wrong);
            showToastLong(message);
    }
}

package com.example.appinventiv.dailystories.samplereplies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.appinventiv.dailystories.R;
import com.example.appinventiv.dailystories.base.BaseActivity;
import com.example.appinventiv.dailystories.pojo.Comments;

import java.util.ArrayList;

/**
 * Created by appinventiv on 23/4/18.
 */

public class CommentsActivity extends BaseActivity implements CommentsView  {
    private CommentsPresenter mCommentsPresenter;
    private String mTitle;
    private RecyclerView mRecyclerView;
    @Override
    public int getResouceId() {
        return R.layout.layout_comments_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCommentsPresenter=new CommentsPresenter(this);
        mRecyclerView=findViewById(R.id.rv_comments);
        Intent intent=getIntent();
        if(intent!=null)
        {

            mTitle=intent.getStringExtra("title");
            mCommentsPresenter.kidsCommented(intent.getIntegerArrayListExtra("kids"));

        }
    }

    @Override
    public void showRandomComments(Comments comments) {

       CommentsAdapter commentsAdapter=new CommentsAdapter(mTitle,comments.getComment(),comments.getReply());
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(commentsAdapter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
     mCommentsPresenter.detachView();
    }
}

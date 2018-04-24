package com.example.appinventiv.dailystories.samplestories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.appinventiv.dailystories.R;
import com.example.appinventiv.dailystories.adapter.StroiesAdapter;
import com.example.appinventiv.dailystories.base.BaseActivity;
import com.example.appinventiv.dailystories.interfaces.StorySelectedListener;
import com.example.appinventiv.dailystories.pojo.Stories;
import com.example.appinventiv.dailystories.samplereplies.CommentsActivity;

import java.util.ArrayList;

import butterknife.BindView;


//This class is used to show all recent stories in a recycler view
public class StoriesActivity extends BaseActivity implements StoriesView,StorySelectedListener,SwipeRefreshLayout.OnRefreshListener {
    //@BindView(R.id.rv_stories)
    RecyclerView rvStories;
   // @BindView(R.id.sl_swipe)
    SwipeRefreshLayout slSwipe;
    private StoriesPresenter mStoriesPresenter;
    private ArrayList<Stories> mStoriesArrayList;
    private StroiesAdapter stroiesAdapter;
    @Override
    public int getResouceId() { return R.layout.layout_stories; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAllViews();
    }

    private void initAllViews() {
        mStoriesArrayList=new ArrayList<>();
        rvStories=findViewById(R.id.rv_stories);
        slSwipe=findViewById(R.id.sl_swipe);
        stroiesAdapter=new StroiesAdapter(mStoriesArrayList,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        rvStories.setLayoutManager(layoutManager);
        rvStories.setAdapter(stroiesAdapter);
        mStoriesPresenter = new StoriesPresenter(this);
        slSwipe.setColorSchemeResources(R.color.colorAccent);
        slSwipe.setOnRefreshListener(this);
    }

    //This method will call and remove view and listener of StoiresActivity and Base Activity respectively
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStoriesPresenter.detachView();
    }
    @Override
    public void ShowAllStories(ArrayList<Stories> storiesArrayList) {
        mStoriesArrayList.clear();
        mStoriesArrayList.addAll(storiesArrayList);
        stroiesAdapter.notifyDataSetChanged();
        slSwipe.setRefreshing(false);
    }
    @Override
    public void onStoryClickedListener(int position) {
        Intent intent=new Intent(this, CommentsActivity.class);
        intent.putIntegerArrayListExtra("kids",mStoriesArrayList.get(position).getKids());
        intent.putExtra("title",mStoriesArrayList.get(position).getTitle());
        //intent.putParcelableArrayListExtra("id",mStroies.get(position));
        startActivity(intent);
    }
    @Override
    public void onRefresh() {
        mStoriesPresenter=new StoriesPresenter(this);
        slSwipe.setRefreshing(true);
    }
}

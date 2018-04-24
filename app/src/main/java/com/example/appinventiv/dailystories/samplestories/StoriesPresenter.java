package com.example.appinventiv.dailystories.samplestories;


import com.example.appinventiv.dailystories.base.BasePresenter;
import com.example.appinventiv.dailystories.pojo.Stories;

import java.util.ArrayList;

/**
 * Created by appinventiv on 21/4/18.
 */

public class StoriesPresenter extends BasePresenter<StoriesView> implements StoriesModelListener {
    private StoriesModel mStoriesModel;
    public StoriesPresenter(StoriesView view) {
        super(view);

    }

    @Override
    public void addModel() {
        mStoriesModel=new StoriesModel(this);
        mStoriesModel.getAllStories();
    }

    @Override
    public void destory() {
        mStoriesModel.detachListener();
        mStoriesModel=null;
    }

    @Override
    public void fetchRandomStoriesFromApi(ArrayList<Stories> storiesArrayList) {
                getView().ShowAllStories(storiesArrayList);
    }


}

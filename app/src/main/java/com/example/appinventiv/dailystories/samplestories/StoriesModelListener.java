package com.example.appinventiv.dailystories.samplestories;

import com.example.appinventiv.dailystories.base.BaseModelListener;
import com.example.appinventiv.dailystories.pojo.Stories;

import java.util.ArrayList;

public interface StoriesModelListener extends BaseModelListener {
    void fetchRandomStoriesFromApi(ArrayList<Stories>  storiesArrayList);
}

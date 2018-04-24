package com.example.appinventiv.dailystories.samplestories;


import com.example.appinventiv.dailystories.base.BaseView;
import com.example.appinventiv.dailystories.pojo.Stories;

import java.util.ArrayList;

public interface StoriesView extends BaseView {
    void ShowAllStories(ArrayList<Stories> storiesArrayList);
}

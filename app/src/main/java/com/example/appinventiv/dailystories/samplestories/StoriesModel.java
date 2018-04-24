package com.example.appinventiv.dailystories.samplestories;

import com.example.appinventiv.dailystories.base.BaseModel;
import com.example.appinventiv.dailystories.network.NetworkResponse;
import com.example.appinventiv.dailystories.pojo.FailureResponse;
import com.example.appinventiv.dailystories.pojo.Stories;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;

public class StoriesModel extends BaseModel<StoriesModelListener> {
    private ArrayList<Stories> mStoriesArrayList;
    public StoriesModel(StoriesModelListener listener) {
        super(listener);
        mStoriesArrayList=new ArrayList<>();
    }

    public void getAllStories()
    {
        getDataManager().getAllStoiresId().enqueue(new NetworkResponse<ResponseBody>(this) {
            @Override
            public void onSuccess(ResponseBody body) {
                    getStoriesId(body);
            }

            @Override
            public void onFailure(int code, FailureResponse failureResponse) {
                getListener().onErrorOccured(failureResponse);
            }

            @Override
            public void onError(Throwable t) {

            }
        });
    }

    private void getStoriesId(ResponseBody response) {
        try {
            JSONArray jsonArray=new JSONArray(response.string());
            for(int i=0;i<jsonArray.length();i++)
            {
                // stroiesAdapter.notifyDataSetChanged();
                hitStoriesApi(jsonArray.getLong(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void  hitStoriesApi(long aLong) {
        getDataManager().getRandomStories("item/"+aLong+".json").enqueue(new NetworkResponse<Stories>(this) {
            @Override
            public void onSuccess(Stories body) {
                mStoriesArrayList.add(body);
                getListener().fetchRandomStoriesFromApi(mStoriesArrayList); }
            @Override
            public void onFailure(int code, FailureResponse failureResponse) { }
            @Override
            public void onError(Throwable t) { }
        });
    }

}

package com.example.appinventiv.dailystories.data;

import com.example.appinventiv.dailystories.data.api.ApiManager;
import com.example.appinventiv.dailystories.data.api.IDataManager;
import com.example.appinventiv.dailystories.pojo.Example;
import com.example.appinventiv.dailystories.pojo.Stories;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class DataManager implements IDataManager {
    private static DataManager instance;
    private ApiManager apiManager;
    private DataManager() {
        apiManager=ApiManager.getInstance();
        }
    public static DataManager getInstance()
    {
        if(instance==null)
        {
            synchronized (DataManager.class) {
                if (instance == null)
                    instance = new DataManager();
            }
            }
        return instance;
    }

    @Override
    public Call<ResponseBody> getAllStoiresId() {
        return apiManager.fetchAllStoriesId();
    }

    @Override
    public Call<Stories> getRandomStories(String url) {
        return apiManager.fetchAllStories(url);
    }

    @Override
    public Call<Example> getRandomCommentsAndReply(String url) {
        return apiManager.fetchAllCommentsAndReply(url);
    }
}


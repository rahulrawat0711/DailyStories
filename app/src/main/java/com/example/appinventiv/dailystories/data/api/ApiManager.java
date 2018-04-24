package com.example.appinventiv.dailystories.data.api;

import com.example.appinventiv.dailystories.pojo.Example;
import com.example.appinventiv.dailystories.pojo.Stories;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by appinventiv on 21/4/18.
 */

public class ApiManager {
    private static final ApiManager instance=new ApiManager();
    private final SampleApiClient apiClient;

    private ApiManager()
    {
        apiClient = getStoriesInstance();
    }

    public static ApiManager getInstance()
    {
        return instance;
    }


    private static SampleApiClient getStoriesInstance() {
        Retrofit retrofit=new Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SampleApiClient.BASE_URL_STORIES)
                .build();
          return retrofit.create(SampleApiClient.class);
    }

    public Call<ResponseBody> fetchAllStoriesId()
    {
        return apiClient.savePost();
    }
    public Call<Stories>  fetchAllStories(String url)
    {
        return apiClient.storiesRandom(url);
    }
    public Call<Example>  fetchAllCommentsAndReply(String url)
    {
        return apiClient.randomComments(url);
    }
}

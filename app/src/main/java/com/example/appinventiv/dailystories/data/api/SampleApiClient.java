package com.example.appinventiv.dailystories.data.api;

import com.example.appinventiv.dailystories.pojo.Example;
import com.example.appinventiv.dailystories.pojo.Stories;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by appinventiv on 21/4/18.
 */

public interface SampleApiClient {

    // This url is used to get get data from the
    public static final String BASE_URL_STORIES="https://hacker-news.firebaseio.com/v0/";

    @GET("topstories.json")
    Call<ResponseBody> savePost();

    @GET
    Call<Example> randomComments(@Url String random);

    //@GET("item/")
    @GET
    Call<Stories> storiesRandom(@Url String random);
}

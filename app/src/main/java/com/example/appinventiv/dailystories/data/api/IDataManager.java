package com.example.appinventiv.dailystories.data.api;


import com.example.appinventiv.dailystories.pojo.Example;
import com.example.appinventiv.dailystories.pojo.Stories;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by appinventiv on 21/4/18.
 */

public interface IDataManager {
    Call<ResponseBody> getAllStoiresId();
    Call<Stories> getRandomStories(String url);
    Call<Example> getRandomCommentsAndReply(String url);
}

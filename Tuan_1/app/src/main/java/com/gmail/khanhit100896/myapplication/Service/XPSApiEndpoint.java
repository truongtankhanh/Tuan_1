package com.gmail.khanhit100896.myapplication.Service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Admin on 8/29/2017.
 */

public interface XPSApiEndpoint {

    @POST("/web/session/authenticate")
    Call<String> authenticate(
            @Body XPSCredsParam param);

}

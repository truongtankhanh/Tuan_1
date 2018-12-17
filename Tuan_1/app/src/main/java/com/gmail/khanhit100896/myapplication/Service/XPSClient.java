package com.gmail.khanhit100896.myapplication.Service;

import android.util.Log;

import java.io.IOException;
import java.net.CookieManager;

import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Admin on 9/1/2017.
 */

public  class XPSClient  {

    private static final String TAG = "XPSClient";
    /*public static final String XPS_URL = "https://hhd.e300.vn";
    public static final String XPS_DATABASE = "hhd_e300_vn";*/
    public   String XPS_URL = "https://test01.e300.vn";
    public static final String XPS_DATABASE = "hhd_e300_vn_test01";
    public static XPSApiEndpoint mxps;
    public static String session_id = "";

    public  static   XPSApiEndpoint getXPSClient() {
        Log.d("session_id1", session_id);
        try {
            if (mxps == null) {
                Interceptor interceptor = new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        final Request request = chain.request().newBuilder()
                                .addHeader("Cookie", "session_id="+session_id+";")
                                .build();
                        return chain.proceed(request);
                    }
                };
                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                httpClient.addInterceptor(interceptor);
                httpClient.cookieJar(new JavaNetCookieJar(new CookieManager()));
                OkHttpClient client = httpClient.build();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://test01.e300.vn")
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .build();
                mxps = retrofit.create(XPSApiEndpoint.class);
            }
        } catch (Exception e) {
            Log.d("error", "Authenticate Error: " + e.toString());
        }
        return mxps;
    }

}

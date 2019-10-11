package com.inossem.myinterceptordemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lyj on 2018/4/27.
 */
public class RetrofitUtil {

    private static RetrofitUtil mRUtils;
    public final String BASE_URL = "https://www.baidu.com/";
    private Retrofit mRetrofit;
    private RetrofitApi maretrofitApi;

    private static final OkHttpClient client = new OkHttpClient.Builder().
            connectTimeout(60, TimeUnit.SECONDS).
            readTimeout(60, TimeUnit.SECONDS).
            writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(new MyInterceptor())
            .build();

    public static synchronized RetrofitUtil getInstance() {

        if (mRUtils == null) {
            mRUtils = new RetrofitUtil();
        }
        return mRUtils;
    }

    private RetrofitUtil() {

        if (mRetrofit == null) {
            mRetrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();
        }

    }

    public RetrofitApi getRetrofitApi() {

        if (maretrofitApi == null) {
            maretrofitApi = mRetrofit.create(RetrofitApi.class);
        }
        return maretrofitApi;
    }

    private static Gson getGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").
                registerTypeAdapter(Date.class, GsonDateErrorAnalysis.getInstance()).create();
    }
}


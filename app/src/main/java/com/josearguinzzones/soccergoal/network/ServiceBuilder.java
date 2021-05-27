package com.josearguinzzones.soccergoal.network;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    private static final String URL2 = "https://api.football-data.org/v2/";
    private static final String key = "881ee6d7a3db4094a6d9ac561c25962a";
    private static final String value = "X-Auth-Token";

    // Create logger
    private static HttpLoggingInterceptor logger =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor
                            .Level.BODY);

    // Create OkHttp Client
    // Factory for calls, which can be used to send HTTP requests and read their responses.
    private static OkHttpClient.Builder okHttp = new OkHttpClient.Builder().addInterceptor(chain -> {
        Request request = chain.request().newBuilder().addHeader(key, value).build();
        return chain.proceed(request);
    });

//    okHttp.addInterceptor(chain -> {
//        Request request = chain.request().newBuilder().addHeader("key", "value").build();
//        return chain.proceed(request);
//    });

    private static Retrofit.Builder builder = new Retrofit
            .Builder()
            .baseUrl(URL2) // Config the base URL
            .addConverterFactory(GsonConverterFactory.create()) // Enable GSON converter
            .client(okHttp.build());

    private static Retrofit retrofit = builder.build();

    // Use builder and Service interface to generate required classes and objects
    public static <S> S buildService(Class<S> serviceType) {
        return retrofit.create(serviceType);
    }
}
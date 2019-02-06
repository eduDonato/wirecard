package com.example.wirecard.com;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit client
 */
public class RetrofitClient {

    private static final String API_BASE_URL = "https://sandbox.moip.com.br/";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static Interceptor retry =
            new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();

                    // try the request
                    Response response = chain.proceed(request);

                    int tryCount = 0;
                    while (!response.isSuccessful() && tryCount < 3) {

                        Log.d("intercept", "Request is not successful - " + tryCount);

                        tryCount++;

                        // retry the request
                        response = chain.proceed(request);
                    }

                    // otherwise just pass the original response on
                    return response;
                }
            };

    public static <S> S createService(
            Class<S> serviceClass, final String token) {
        if (token != null) {
            AuthenticationInterceptor interceptor =
                    new AuthenticationInterceptor(token);

            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor);
                httpClient.addInterceptor(logging);
                httpClient.addInterceptor(retry);

                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }
        return retrofit.create(serviceClass);
    }
}

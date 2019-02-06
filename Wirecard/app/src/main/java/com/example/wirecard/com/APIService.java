package com.example.wirecard.com;

import com.example.wirecard.com.model.details.ResponseOrderDetails;
import com.example.wirecard.com.model.login.ResponseLogin;
import com.example.wirecard.com.model.orders.ResponseOrders;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;
import rx.Observable;

/**
 * API service used to call transaction and get results
 */
public interface APIService {

    @FormUrlEncoded
    @POST
    Observable<ResponseLogin> login(@Url String url,
                                    @Field("client_id") String client_id,
                                    @Field("client_secret") String client_secret,
                                    @Field("grant_type") String grant_type,
                                    @Field("username") String username,
                                    @Field("password") String password,
                                    @Field("device_id") String device_id,
                                    @Field("scope") String scope);

    @GET("/v2/orders")
    Observable<ResponseOrders> getOrgersList();

    @GET("/v2/orders/{order_id}")
    Observable<ResponseOrderDetails> getOrderDetails(@Path("order_id") String orderId);
}
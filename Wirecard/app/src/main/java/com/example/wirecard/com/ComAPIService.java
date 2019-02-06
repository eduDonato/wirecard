package com.example.wirecard.com;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.example.wirecard.com.model.details.ResponseOrderDetails;
import com.example.wirecard.com.model.login.RequestLogin;
import com.example.wirecard.com.model.login.ResponseLogin;
import com.example.wirecard.com.model.orders.ResponseOrders;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Class that creates the transactions and its fields for call API
 */
public class ComAPIService {

    private APIService mAPIService;
    private ProgressDialog mDialog;
    private ComAPIInterface mListener;

    private static ComAPIService instance;

    public static ComAPIService getInstance(){
        if(instance == null){
            instance = new ComAPIService();
        }
        return instance;
    }
    private ComAPIService(){}

    /**
     * Create API instance
     * @param token
     */
    private void createAPI(String token){
        mDialog.show();
        mAPIService = RetrofitClient.createService(APIService.class, token);
    }

    /**
     * Call Login transaction
     * @param request
     * @param con
     */
    public void login(RequestLogin request, Context con){
        setProcess(con, "Login...");
        createAPI(null);

        request.setScope("APP_ADMIN");
        request.setGrantType("password");
        request.setClientSecret("05acb6e128bc48b2999582cd9a2b9787");
        request.setClientId("APP-H1DR0RPHV7SP");
        request.setDeviceId("1");

        String url = "https://connect-sandbox.moip.com.br/oauth/token";

        // RxJava
        mAPIService.login(url, request.getClientId(),
                request.getClientSecret(),
                request.getGrantType(),
                request.getUsername(),
                request.getPassword(),
                request.getDeviceId(),
                request.getScope()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseLogin>() {
                    @Override
                    public void onCompleted() {
                        Log.i("TEST", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("TEST", "onError");
                        mDialog.dismiss();
                        mListener.onTaskFailed(e);

                    }

                    @Override
                    public void onNext(ResponseLogin post) {
                        Log.i("TEST", "onNext");
                        mDialog.dismiss();
                        mListener.onTaskCompleted(post);
                        //showResponse(post.toString());
                    }
                });
    }

    /**
     * Call Order list transaction
     * @param token
     * @param con
     */
    public void getOrders(String token, Context con){
        setProcess(con, "Loading orders...");
        createAPI("Bearer " + token);

        // RxJava
        mAPIService.getOrgersList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseOrders>() {
                    @Override
                    public void onCompleted() {
                        Log.i("TEST", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("TEST", "onError");
                        mDialog.dismiss();
                        mListener.onTaskFailed(e);

                    }

                    @Override
                    public void onNext(ResponseOrders post) {
                        Log.i("TEST", "onNext");
                        mDialog.dismiss();
                        mListener.onTaskCompleted(post);
                        //showResponse(post.toString());
                    }
                });
    }

    /**
     * Call Order details transaction
     * @param token
     * @param con
     * @param id
     */
    public void getOrderDetails(String token, Context con, String id){
        setProcess(con, "Loading order...");
        createAPI("Bearer " + token);

        // RxJava
        mAPIService.getOrderDetails(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseOrderDetails>() {
                    @Override
                    public void onCompleted() {
                        Log.i("TEST", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("TEST", "onError");
                        mDialog.dismiss();
                        mListener.onTaskFailed(e);

                    }

                    @Override
                    public void onNext(ResponseOrderDetails post) {
                        Log.i("TEST", "onNext");
                        mDialog.dismiss();
                        mListener.onTaskCompleted(post);
                        //showResponse(post.toString());
                    }
                });
    }

    /**
     * Instantiate references needed for processing calls and start dialog
     * @param con
     * @param message
     */
    private void setProcess(Context con, String message){
        mListener = (ComAPIInterface) con;
        mDialog = new ProgressDialog(con);
        mDialog.setIndeterminate(true);
        mDialog.setMessage(message);
        mDialog.setCancelable(false);
        mDialog.show();
    }




}

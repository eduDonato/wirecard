package com.example.wirecard.com;

import com.example.wirecard.com.model.ResponseInterface;

/**
 * Interface for getting the result of a transaction
 */
public interface ComAPIInterface {

    public void onTaskCompleted(ResponseInterface c);
    public void onTaskFailed(Throwable t);
}

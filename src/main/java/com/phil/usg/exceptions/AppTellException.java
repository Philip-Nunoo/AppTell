/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.usg.exceptions;

/**
 *
 * @author Philip
 */
public class AppTellException extends Exception {

    public AppTellException() {
    }

    public AppTellException(String message) {
        super(message);
    }

    public AppTellException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppTellException(Throwable cause) {
        super(cause);
    }

    public AppTellException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

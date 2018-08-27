/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.usg.apptell;

import com.phil.usg.interfaces.IAuth;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Philip
 */
public final class BasicAuth implements IAuth {

    private final String username;
    private final String password;

    /**
     *
     * @param username
     * @param password
     */
    public BasicAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        String credentials = username.trim() + ":" + password.trim();
        String encodedAuthorization
                = DatatypeConverter.printBase64Binary(credentials.getBytes());
        return String.format("Basic %s", encodedAuthorization);
    }

    @Override
    public String getCredentials() {
        return this.toString();
    }

}

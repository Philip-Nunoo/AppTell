/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.usg.apptell;

/**
 *
 * @author Philip
 */
public class AppSell {

    private final BasicAuth basicAuth;
    private final String walletToken;
    private String senderId;

    public AppSell(String username, String password, String walletID) {
        this.basicAuth = new BasicAuth(username, password);
        this.walletToken = String.format("TOKEN %s", walletID);
    }

    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    public String getWalletToken() {
        return walletToken;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    @Override
    public String toString() {
        return "AppSell{" + "basicAuth=" + basicAuth + ", walletToken=" + walletToken + '}';
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.usg.apptell;

import com.phil.usg.exceptions.AppTellException;
import com.phil.usg.interfaces.TextualInterface;
import com.phil.usg.models.BulkMessage;
import com.phil.usg.models.Response;
import com.phil.usg.models.SmsMessage;
import com.phil.usg.models.SmsResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Philip
 */
public class Textual extends AppSell implements TextualInterface {

    public Textual(String username, String password, String walletId) {
        super(username, password, walletId);
    }

    @Override
    public Response sendSingleMessage(SmsMessage smsMessage) throws AppTellException {
        if (this.getSenderId() == null) {
            throw new AppTellException("No senderId set: .setSenderId(\"SENDER_ID\")");
        }
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, smsMessage.toJsonString(this.getSenderId()));
            Request request = new Request.Builder()
                    .url("https://api.apptellsl.com/v1/messages/sms")
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Cache-Control", "no-cache")
                    .addHeader("X-Wallet", this.getWalletToken())
                    .addHeader("Authorization", this.getBasicAuth().getCredentials())
                    .build();

            okhttp3.Response okhttpResponse = client.newCall(request).execute();
            Response response = new Response("999", "Unhandled error");

            if (okhttpResponse.isSuccessful()) {
                String responseString = okhttpResponse.body().string();
                JSONObject smsResponseObject = new JSONObject(responseString);

                SmsResponse smsResponse = SmsResponse.getSmsResponseObject(smsResponseObject);
                response.setResponseCode("000");
                response.setMessage("Successful");
                response.setData(smsResponse);
            } else {
                response.setResponseCode(((Integer) okhttpResponse.code()).toString());
                response.setMessage("Unhandled message error");
            }
            return response;
        } catch (IOException | IllegalArgumentException ex) {
            Logger.getLogger(Textual.class.getName()).log(Level.SEVERE, null, ex);
            throw new AppTellException(ex);
        }
    }

    @Override
    public Response sendBulkMessage(BulkMessage bulkMessage) throws AppTellException {
        try {
            OkHttpClient client = new OkHttpClient();
            String type = bulkMessage.getMessage() != null ? "otm" : "mtm";
            
            String url = String.format("https://api.apptellsl.com/v1/messages/sms/bulk/%s", type);
            
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, bulkMessage.toJsonString(this.getSenderId()));
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Cache-Control", "no-cache")
                    .addHeader("X-Wallet", this.getWalletToken())
                    .addHeader("Authorization", this.getBasicAuth().getCredentials())
                    .build();

            okhttp3.Response okhttpResponse = client.newCall(request).execute();
            Response response = new Response("999", "Unhandled error");

            if (okhttpResponse.isSuccessful()) {
                String responseString = okhttpResponse.body().string();
                
                JSONArray smsResponseArray = new JSONArray(responseString);
                ArrayList<SmsResponse> smsResponses = new ArrayList<>();
                
                for (int i = 0; i < smsResponseArray.length(); i++) {
                    JSONObject smsResponseObject = smsResponseArray.getJSONObject(i);
                    SmsResponse smsResponse = SmsResponse.getSmsResponseObject(smsResponseObject);
                    smsResponses.add(smsResponse);
                }

                response.setResponseCode("000");
                response.setMessage("Successful");
                response.setData(smsResponses);
            } else {
                response.setResponseCode(((Integer) okhttpResponse.code()).toString());
                response.setMessage("Unhandled message error");
            }
            return response;
        } catch (IOException ex) {
            Logger.getLogger(Textual.class.getName()).log(Level.SEVERE, null, ex);
            throw new AppTellException(ex);
        }
    }

}

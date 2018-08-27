/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.usg.models;

import java.util.ArrayList;

/**
 *
 * @author Philip
 */
public class BulkMessage {

    private String message;
    private ArrayList<Recipient> recipients;

    public BulkMessage(String message, ArrayList<Recipient> recipients) {
        this.message = message;
        this.recipients = recipients;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Recipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(ArrayList<Recipient> recipients) {
        this.recipients = recipients;
    }

    @Override
    public String toString() {
        return "BulkMessage{" + "message=" + message + ", recipients=" + recipients + '}';
    }

    public String toJsonString(String senderId) {
        String recipientsJsonStringArray = "";

        recipientsJsonStringArray = recipients.stream().map(
                (recipient) -> recipient.toJsonString() + ", \n")
                .reduce(recipientsJsonStringArray, String::concat);

        String jsonString = String.format(
                "{\n"
                + "	\"from\": \"%s\",\n"
                + "	\"recipients\": [%s],\n"
                + "	\"content\": \"%s\"\n"
                + "}",
                senderId, recipientsJsonStringArray, message
        );

        return jsonString;
    }
}

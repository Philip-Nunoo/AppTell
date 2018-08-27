/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.usg.models;

/**
 *
 * @author Philip
 */
public class SmsMessage {

    private String recipient;
    private String message;
    private String reference;

    public SmsMessage(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "SmsMessage{" + "recipient=" + recipient + ", message=" + message + ", reference=" + reference + '}';
    }

    public String toJsonString(String senderId) {
        String jsonString = String.format(
                "{\n"
                + "	\"from\": \"%s\",\n"
                + "	\"to\": \"%s\",\n"
                + "	\"content\": \"%s\",\n"
                + "	\"reference\": \"%s\"\n"
                + "}",
                senderId, this.recipient, this.message, this.reference);

        return jsonString;
    }

}

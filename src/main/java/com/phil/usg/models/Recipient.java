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
public class Recipient {

    private String message;
    private String recipient;
    private String reference;

    public Recipient(String recipient, String message) {
        this.message = message;
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Recipient{" + "message=" + message + ", recipient=" + recipient + ", reference=" + reference + '}';
    }

    public String toJsonString() {
        String jsonString = String.format(
                "{\n"
                + " \"to\": \"%s\", \n"
                + " \"content\": \"%s\", \n"
                + " \"reference\": \"%s\"\n"
                + "}",
                recipient, message, reference
        );

        return jsonString;
    }
}

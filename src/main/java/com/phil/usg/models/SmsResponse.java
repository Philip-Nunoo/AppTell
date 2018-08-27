/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.usg.models;

import org.json.JSONObject;

/**
 *
 * @author Philip
 */
public class SmsResponse {

    private static final String TICKET = "ticket";
    private static final String TO = "to";
    private static final String REFERENCE = "reference";
    private String recipient;
    private String ticketId;
    private String reference;

    public SmsResponse() {
    }

    public SmsResponse(String recipient, String ticketId, String reference) {
        this.recipient = recipient;
        this.ticketId = ticketId;
        this.reference = reference;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public static SmsResponse getSmsResponseObject(JSONObject smsResponseObject) {
        String _recipient = smsResponseObject.has(SmsResponse.TO)
                ? smsResponseObject.getString(SmsResponse.TO)
                : null;
        String _ticketId = smsResponseObject.has(SmsResponse.TICKET)
                ? smsResponseObject.getString(SmsResponse.TICKET)
                : null;

        String _reference = smsResponseObject.has(SmsResponse.REFERENCE)
                ? smsResponseObject.getString(SmsResponse.REFERENCE)
                : null;

        return new SmsResponse(_recipient, _ticketId, _reference);
    }

}

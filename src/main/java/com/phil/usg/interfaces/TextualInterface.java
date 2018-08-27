/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.usg.interfaces;

import com.phil.usg.exceptions.AppTellException;
import com.phil.usg.models.BulkMessage;
import com.phil.usg.models.Response;
import com.phil.usg.models.SmsMessage;

/**
 *
 * @author Philip
 */
public interface TextualInterface {

    /**
     * Send single message
     *
     * @param smsMessage
     * @return
     * @throws com.phil.usg.exceptions.AppTellException
     */
    public Response sendSingleMessage(SmsMessage smsMessage) throws AppTellException;

    /**
     * Send bulk message
     *
     * @param bulkMessage
     * @return
     * @throws com.phil.usg.exceptions.AppTellException
     */
    public Response sendBulkMessage(BulkMessage bulkMessage) throws AppTellException;
}

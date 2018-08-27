/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.usg.apptell;

import com.phil.usg.models.BulkMessage;
import com.phil.usg.models.Recipient;
import com.phil.usg.models.Response;
import com.phil.usg.models.SmsMessage;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Philip
 */
public class TextualTest {

    private static final String USERNAME = "USERNAME";
    private static final String PASSWORD = "PASSWORD";
    private static final String WALLET_ID = "WALLET_ID";
    private static final String SENDER_ID = "SENDER_ID";
    private final ArrayList<Recipient> recipients;

    public TextualTest() {
        this.recipients = new ArrayList<>();
        Recipient philip = new Recipient("+233206242008", "Message for philip");
        Recipient eugene = new Recipient("+233545088895", "Message for Eugene");

        recipients.add(philip);
        recipients.add(eugene);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sendSingleMessage method, of class Textual.
     */
    @Test
    public void testSendSingleMessage() throws Exception {
        System.out.println("sendSingleMessage");

        SmsMessage smsMessage = new SmsMessage("+233206242008", "Testing single sms");
        Textual instance = new Textual(
                TextualTest.USERNAME,
                TextualTest.PASSWORD,
                TextualTest.WALLET_ID
        );
        instance.setSenderId(TextualTest.SENDER_ID);
        Response expResult = new Response("000", "Success");
        Response response = instance.sendSingleMessage(smsMessage);
        assertNotNull(response);
        assertEquals(expResult.getResponseCode(), response.getResponseCode());
    }

    /**
     * Test of sendBulkMessage method, of class Textual.
     */
    @Test
    public void testSendBulkMessageOTM() throws Exception {
        System.out.println("sendBulkMessageOTM");

        BulkMessage bulkMessage = new BulkMessage("OTM message", this.recipients);
        Textual instance = new Textual(USERNAME, PASSWORD, WALLET_ID);
        instance.setSenderId(SENDER_ID);
        Response expResult = new Response("000", "Success");
        Response result = instance.sendBulkMessage(bulkMessage);

        assertNotNull(result);
        assertEquals(expResult.getResponseCode(), result.getResponseCode());
    }

    @Test
    public void testSendBulkMessageMTM() throws Exception {
        System.out.println("sendBulkMessageMTM");

//        BulkMessage bulkMessage = new BulkMessage(null, this.recipients);
//        Textual instance = new Textual(USERNAME, PASSWORD, WALLET_ID);
//        instance.setSenderId(SENDER_ID);
//        Response expResult = new Response("000", "Success");
//        Response result = instance.sendBulkMessage(bulkMessage);
//
//        assertNotNull(result);
//        assertEquals(expResult.getResponseCode(), result.getResponseCode());
    }

}

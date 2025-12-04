package io.sendflare.sdk;

import io.sendflare.sdk.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * SendflareClient Test
 */
class SendflareClientTest {

    private SendflareClient client;

    @BeforeEach
    void setUp() {
        client = new SendflareClient("this-is-my-token");
    }

    @Test
    void testNewSendflareClient() {
        SendflareClient testClient = new SendflareClient("this-is-my-token");
        System.out.println("Client created: " + testClient);
    }

    @Test
    void testSendEmail() {
        SendEmailReq req = new SendEmailReq(
                "test@example.com",
                "to@example.com",
                "test",
                "test email"
        );
        
        System.out.println("Request: " + req);
        
        try {
            SendEmailResp resp = client.sendEmail(req);
            System.out.println("Response: " + resp);
            System.out.println("Success: " + resp.isSuccess());
        } catch (Exception e) {
            System.out.println("Error (expected without valid token): " + e.getMessage());
        }
    }

    @Test
    void testGetContactList() {
        ListContactReq req = new ListContactReq("test", 1, 10);
        
        System.out.println("Request: " + req);
        
        try {
            ListContactResp resp = client.getContactList(req);
            System.out.println("Response: " + resp);
            System.out.println("Total count: " + resp.getTotalCount());
        } catch (Exception e) {
            System.out.println("Error (expected without valid token): " + e.getMessage());
        }
    }

    @Test
    void testSaveContact() {
        Map<String, String> data = new HashMap<>();
        data.put("firstName", "John");
        data.put("lastName", "Doe");
        
        SaveContactReq req = new SaveContactReq("test", "test@example.com", data);
        
        System.out.println("Request: " + req);
        
        try {
            SaveContactResp resp = client.saveContact(req);
            System.out.println("Response: " + resp);
            System.out.println("Success: " + resp.isSuccess());
        } catch (Exception e) {
            System.out.println("Error (expected without valid token): " + e.getMessage());
        }
    }

    @Test
    void testDeleteContact() {
        DeleteContactReq req = new DeleteContactReq("test@example.com", "test");
        
        System.out.println("Request: " + req);
        
        try {
            DeleteContactResp resp = client.deleteContact(req);
            System.out.println("Response: " + resp);
            System.out.println("Success: " + resp.isSuccess());
        } catch (Exception e) {
            System.out.println("Error (expected without valid token): " + e.getMessage());
        }
    }
}


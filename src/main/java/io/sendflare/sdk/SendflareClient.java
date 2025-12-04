package io.sendflare.sdk;

import io.sendflare.sdk.model.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Sendflare SDK Client
 */
public class SendflareClient {
    private static final String BASE_URL = "https://api.sendflare.io";
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(10);

    private final String token;
    private final HttpClient httpClient;
    private final Gson gson;

    /**
     * Create a new Sendflare client instance
     *
     * @param token API token
     */
    public SendflareClient(String token) {
        this.token = token;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(REQUEST_TIMEOUT)
                .build();
        this.gson = new Gson();
    }

    /**
     * Send an email
     *
     * @param req Send email request
     * @return Send email response
     * @throws IOException          if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public SendEmailResp sendEmail(SendEmailReq req) throws IOException, InterruptedException {
        String path = "/v1/send";
        String jsonBody = gson.toJson(req);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + path))
                .timeout(REQUEST_TIMEOUT)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), SendEmailResp.class);
    }

    /**
     * Get contact list
     *
     * @param req List contact request
     * @return List contact response
     * @throws IOException          if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public ListContactResp getContactList(ListContactReq req) throws IOException, InterruptedException {
        String path = "/v1/contact";

        Map<String, String> params = new HashMap<>();
        params.put("appId", req.getAppId());
        params.put("page", String.valueOf(req.getPage()));
        params.put("pageSize", String.valueOf(req.getPageSize()));

        String queryString = buildQueryString(params);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + path + "?" + queryString))
                .timeout(REQUEST_TIMEOUT)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), ListContactResp.class);
    }

    /**
     * Create or update contact
     *
     * @param req Save contact request
     * @return Save contact response
     * @throws IOException          if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public SaveContactResp saveContact(SaveContactReq req) throws IOException, InterruptedException {
        String path = "/v1/contact";
        String jsonBody = gson.toJson(req);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + path))
                .timeout(REQUEST_TIMEOUT)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), SaveContactResp.class);
    }

    /**
     * Delete a contact
     *
     * @param req Delete contact request
     * @return Delete contact response
     * @throws IOException          if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     */
    public DeleteContactResp deleteContact(DeleteContactReq req) throws IOException, InterruptedException {
        String path = "/v1/contact";

        Map<String, String> params = new HashMap<>();
        params.put("appId", req.getAppId());
        params.put("emailAddress", req.getEmailAddress());

        String queryString = buildQueryString(params);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + path + "?" + queryString))
                .timeout(REQUEST_TIMEOUT)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), DeleteContactResp.class);
    }

    /**
     * Build query string from parameters
     *
     * @param params Parameters map
     * @return URL encoded query string
     */
    private String buildQueryString(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            sb.append("=");
            sb.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }
        return sb.toString();
    }
}


package com.example.soulshelperbackend.api_facade;

import com.example.soulshelperbackend.dto.GameIgdbResponse;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IgdbFacade {
    RestTemplate restTemplate;

    public IgdbFacade() {
        restTemplate = new RestTemplate();
    }

    @Value("${app.igdb-key}")
    String API_KEY;
    String CLIENT_ID = "540t2yct4z9d43iv2ouue0i62jxj8g";
    String url = "https://api.igdb.com/v4/games";

    public GameIgdbResponse getGame(int igdbId)  {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Client-ID", CLIENT_ID);
        headers.add("Authorization", "Bearer " + API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestBody = "fields *; where id = " + igdbId + ";"; // Replace with your actual request body

        // Create the request entity with headers
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make the POST request
        String url = "https://api.igdb.com/v4/games";

        // Send the POST request and receive the response as an array
        GameIgdbResponse[] responses = restTemplate.postForObject(url, requestEntity, GameIgdbResponse[].class);

        // Check if the response array is not empty
        if (responses != null && responses.length > 0) {
            // Return the first element (assumes there is only one element in the array)
            GameIgdbResponse response = responses[0];
            // Handle the response
            System.out.println(response);
            return response;
        } else {
            return null;
        }
    }
}

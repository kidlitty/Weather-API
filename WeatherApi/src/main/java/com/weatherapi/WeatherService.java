package com.weatherapi; // Assuming your DTOs are also in this package

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WeatherService {

    private final String apiKey;
    private final String unitGroup;
    private static final String BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public WeatherService (String apiKey, String unitGroup) {
        this.apiKey = apiKey;
        this.unitGroup = unitGroup;
    }

    public static String getApiKey () {
        return "YOUR_VISUAL_CROSSING_API_KEY";
    }

    public WeatherResponse get15DayForecast (String location) throws IOException {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(14);

        String startDate = today.format(DateTimeFormatter.ISO_DATE);
        String endDate = futureDate.format(DateTimeFormatter.ISO_DATE);

        String jsonResponse = fetchWeatherDataJson(location, startDate, endDate, "days");
        if (jsonResponse != null) {
            return parseWeatherResponse(jsonResponse);
        }
        return null;
    }

    public WeatherResponse getCurrentConditions (String location) throws IOException {
        String jsonResponse = fetchWeatherDataJson(location, null, null, "current");
        if (jsonResponse != null) {
            return parseWeatherResponse(jsonResponse);
        }
        return null;
    }

    private String fetchWeatherDataJson (String location, String startDate, String endDate, String includeParam) throws IOException {
        String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8.toString());

        String apiUrl;
        if (startDate != null && endDate != null) {
            // URL for date range (e.g., 15-day forecast)
            apiUrl = String.format("%s/%s/%s/%s?key=%s&unitGroup=%s&include=%s&contentType=json",
                    BASE_URL, encodedLocation, startDate, endDate, this.apiKey, this.unitGroup, includeParam);
        } else {
            // URL for current conditions (no date range in path)
            apiUrl = String.format("%s/%s?key=%s&unitGroup=%s&include=%s&contentType=json",
                    BASE_URL, encodedLocation, this.apiKey, this.unitGroup, includeParam);
        }

        System.out.println("Fetching weather data from: " + apiUrl);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(apiUrl);

        try (CloseableHttpResponse response = httpClient.execute(request)){
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity());

            if (statusCode == 200) {
                return responseBody;
            } else if (statusCode == 401) {
                throw new IOException("Failed to fetch weather data. HTTP Status: " + statusCode +
                        ", Response: " + responseBody + "\nPlease find API key on https://www.visualcrossing.com");
            }
            else {
                throw new IOException("Failed to fetch weather data. HTTP Status: " + statusCode +
                        ", Response: " + responseBody);
            }
        } finally {
            httpClient.close();
        }
    }

    private WeatherResponse parseWeatherResponse(String jsonResponse) throws IOException { // Fixed 'throw' to 'throws'
        return objectMapper.readValue(jsonResponse, WeatherResponse.class);
    }
}

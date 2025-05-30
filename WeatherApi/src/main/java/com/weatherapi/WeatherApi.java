package com.weatherapi;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WeatherApi {

    private WeatherService weatherService;
    private final Scanner scanner;
    private String unitGroup;

    public WeatherApi () {
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        WeatherApi api = new WeatherApi();
        api.run();
    }

    public void run() {
        System.out.println("**************************");
        System.out.println("Welcome To The Weather API");
        System.out.println("**************************");

        System.out.print("Please enter your Visual Crossing API Key: ");
        String apiKey = scanner.nextLine().trim();

        if (apiKey.isEmpty()) {
            System.err.println("API Key cannot be empty. Please find API key at https://www.visualcrossing.com");
            System.err.println("Exiting Program...");
            return;
        }

        System.out.print("Choose units (C for Celsius/Metric, F for Fahrenheit/US): ");
        String unitChoice = scanner.nextLine().trim().toUpperCase();
        if ("F".equals(unitChoice)) {
            this.unitGroup = "us";
            System.out.println("Units set to Fahrenheit/US.");
        } else {
            this.unitGroup = "metric";
            System.out.println("Units set to Celsius/Metric (default).");
        }

        this.weatherService = new WeatherService(apiKey, this.unitGroup);

        while (true) {
            System.out.println("\n"+"--- Menu ---");
            System.out.println("1. Get Weather Forecast For A Location");
            System.out.println("2. Get Current Weather Conditions for a Location");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> get15DayTemperatureForecast();
                    case 2 -> getCurrentWeatherConditions();
                    case 3 -> {
                        System.out.println("Exiting application. Bye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private void get15DayTemperatureForecast() {
        System.out.print("Enter location (e.g, Johannesburg, South Africa or London): ");
        String location = scanner.nextLine().trim();

        try {
            WeatherResponse weatherResponse = weatherService.get15DayForecast(location);
            displayTemperatureForecast(weatherResponse);

        } catch (Exception e) {
            System.err.println("Error fetching weather data: " + e.getMessage());
        }

    }
    private void getCurrentWeatherConditions() {
        System.out.print("Enter location for current weather (e.g., London, UK): ");
        String location = scanner.nextLine();

        try {
            WeatherResponse weatherResponse = weatherService.getCurrentConditions(location);

            displayCurrentWeather(weatherResponse);

        } catch (Exception e) {
            System.err.println("Error fetching current weather data: " + e.getMessage());
        }
    }

    private void displayTemperatureForecast(WeatherResponse weatherResponse) {
        if (weatherResponse == null || weatherResponse.getDays() == null || weatherResponse.getDays().isEmpty()) {
            System.out.println("No weather data avaialable for the specified location.");
            return;
        }

        String tempUnitLabel = "metric".equals(this.unitGroup) ? "°C" : "°F";
        String speedUnitLabel = "metric".equals(this.unitGroup) ? "km/h" : "mph";

        System.out.println("\n--- 15-Day Temperature Forecast for: " + weatherResponse.getAddress() + " ---");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("%-12s | %-12s | %-12s | %-25s | %-12s%n",
                "Date", "Max Temp (" + tempUnitLabel + ")", "Min Temp (" + tempUnitLabel + ")", "Conditions", "Wind Speed (" + speedUnitLabel + ")");
        System.out.println("------------------------------------------------------------------------------------");


        // Display Daily Forecast including conditions and wind speed
        for (Day day : weatherResponse.getDays()) {
            System.out.printf("%-12s | %-12.1f | %-12.1f | %-25s | %-12.1f%n",
                    day.getDatetime(),
                    day.getTempmax(),
                    day.getTempmin(),
                    day.getConditions(),
                    day.getWindspeed());
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    private void displayCurrentWeather(WeatherResponse weatherResponse) {
        if (weatherResponse == null || weatherResponse.getCurrentConditions() == null) {
            System.out.println("No current weather data available for the specified location.");
            return;
        }


        String tempUnitLabel = "metric".equals(this.unitGroup) ? "°C" : "°F";
        String speedUnitLabel = "metric".equals(this.unitGroup) ? "km/h" : "mph";
        String pressureUnitLabel = "metric".equals(this.unitGroup) ? "hPa" : "mb";

        CurrentConditions current = weatherResponse.getCurrentConditions();

        long epochSeconds = current.getDatetimeEpoch();
        String timezoneId = weatherResponse.getTimezone();

        String formattedTime;
        try {
            Instant instant = Instant.ofEpochSecond(epochSeconds);
            ZoneId zoneId = ZoneId.of(timezoneId);
            ZonedDateTime currentLocalTime = ZonedDateTime.ofInstant(instant, zoneId);
            formattedTime = currentLocalTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"));

        } catch (Exception e) {
            System.err.println("Error parsing time or timezone for display: " + e.getMessage());
            formattedTime = current.getDatetime() + " (Timezone Error)";
        }
        System.out.println("\n--- Current Weather for: " + weatherResponse.getAddress() + " ---");
        System.out.println("--------------------------------------------------");
        System.out.printf("Time: %s%n", formattedTime);
        System.out.printf("Temperature: %.1f°C%n", current.getTemp());
        System.out.printf("Feels Like: %.1f°C%n", current.getFeelslike());
        System.out.printf("Conditions: %s%n", current.getConditions());
        System.out.printf("Humidity: %.1f%%%n", current.getHumidity());
        System.out.printf("Wind Speed: %.1f km/h%n", current.getWindspeed());
        System.out.printf("Pressure: %.1f hPa%n", current.getPressure());
        System.out.printf("UV Index: %d%n", current.getUvindex());
        System.out.printf("Sunrise: %s%n", current.getSunrise());
        System.out.printf("Sunset: %s%n", current.getSunset());
        System.out.println("--------------------------------------------------");
    }
}

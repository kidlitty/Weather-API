package com.weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties (ignoreUnknown = true)
public class WeatherResponse {
    private String queryCost;
    private double latitude;
    private double longitude;
    private String resolveAddress;
    private String address;
    private String timezone;
    private String tzoffset;
    private String description;
    private CurrentConditions currentConditions;
    private List<Day> days;

    public String getQueryCost() { return queryCost; }
    public void setQueryCost (String queryCost) { this.queryCost = queryCost; }

    public double getLatitude() { return latitude; }
    public void setLatitude (double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude (double longitude) { this.longitude = longitude; }

    public String getResolveAddress() { return resolveAddress; }
    public void setResolveAddress (String resolveAddress) { this.resolveAddress = resolveAddress; }

    public String getAddress() { return address; }
    public void setAddress (String address) { this.address = address; }

    public String getTimezone() { return timezone; }
    public void setTimezone (String timezone) { this.timezone = timezone; }

    public String getTzoffset() { return tzoffset; }
    public void setTzoffset (String tzoffset) { this.tzoffset = tzoffset; }

    public String getDescription() { return description; }
    public void setDescription (String description) { this.description = description; }

    public CurrentConditions getCurrentConditions() { return currentConditions; }
    public void setCurrentConditions (CurrentConditions currentConditions) { this.currentConditions = currentConditions; }

    public List<Day> getDays() { return days; }
    public void setDays (List<Day> days) { this.days = days; }
}

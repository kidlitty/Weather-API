package com.weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {
    private String datetime;
    private int datetimeEpoch;
    private double tempmax;
    private double tempmin;
    private double temp;
    private double feelslikemax;
    private double feelslikemin;
    private double feelslike;
    private double dew;
    private double humidity;
    private double precip;
    private double precipprob;
    private double precipcover;
    private String preciptype;
    private double snow;
    private double snowdepth;
    private double windgust;
    private double windspeed;
    private double winddir;
    private double pressure;
    private double cloudcover;
    private double visibility;
    private double solarradiation;
    private double solarenergy;
    private int uvindex;
    private double severerisk;
    private String sunrise;
    private int sunriseEpoch;
    private String sunset;
    private int sunsetEpoch;
    private double moonphase;
    private String conditions;
    private String description;
    private String icon;
    private List<String> stations;
    private String source;
    private List<Hour> hours;

    // Getters and Setters for all fields

    public String getDatetime() { return datetime; }
    public void setDatetime(String datetime) { this.datetime = datetime; }

    public int getDatetimeEpoch() { return datetimeEpoch; }
    public void setDatetimeEpoch(int datetimeEpoch) { this.datetimeEpoch = datetimeEpoch; }

    public double getTempmax() { return tempmax; }
    public void setTempmax(double tempmax) { this.tempmax = tempmax; }

    public double getTempmin() { return tempmin; }
    public void setTempmin(double tempmin) { this.tempmin = tempmin; }

    public double getTemp() { return temp; }
    public void setTemp(double temp) { this.temp = temp; }

    public double getFeelslikemax() { return feelslikemax; }
    public void setFeelslikemax(double feelslikemax) { this.feelslikemax = feelslikemax; }

    public double getFeelslikemin() { return feelslikemin; }
    public void setFeelslikemin(double feelslikemin) { this.feelslikemin = feelslikemin; }

    public double getFeelslike() { return feelslike; }
    public void setFeelslike(double feelslike) { this.feelslike = feelslike; }

    public double getDew() { return dew; }
    public void setDew(double dew) { this.dew = dew; }

    public double getHumidity() { return humidity; }
    public void setHumidity(double humidity) { this.humidity = humidity; }

    public double getPrecip() { return precip; }
    public void setPrecip(double precip) { this.precip = precip; }

    public double getPrecipprob() { return precipprob; }
    public void setPrecipprob(double precipprob) { this.precipprob = precipprob; }

    public double getPrecipcover() { return precipcover; }
    public void setPrecipcover(double precipcover) { this.precipcover = precipcover; }

    public String getPreciptype() { return preciptype; }
    public void setPreciptype(String preciptype) { this.preciptype = preciptype; }

    public double getSnow() { return snow; }
    public void setSnow(double snow) { this.snow = snow; }

    public double getSnowdepth() { return snowdepth; }
    public void setSnowdepth(double snowdepth) { this.snowdepth = snowdepth; }

    public double getWindgust() { return windgust; }
    public void setWindgust(double windgust) { this.windgust = windgust; }

    public double getWindspeed() { return windspeed; }
    public void setWindspeed(double windspeed) { this.windspeed = windspeed; }

    public double getWinddir() { return winddir; }
    public void setWinddir(double winddir) { this.winddir = winddir; }

    public double getPressure() { return pressure; }
    public void setPressure(double pressure) { this.pressure = pressure; }

    public double getCloudcover() { return cloudcover; }
    public void setCloudcover(double cloudcover) { this.cloudcover = cloudcover; }

    public double getVisibility() { return visibility; }
    public void setVisibility(double visibility) { this.visibility = visibility; }

    public double getSolarradiation() { return solarradiation; }
    public void setSolarradiation(double solarradiation) { this.solarradiation = solarradiation; }

    public double getSolarenergy() { return solarenergy; }
    public void setSolarenergy(double solarenergy) { this.solarenergy = solarenergy; }

    public int getUvindex() { return uvindex; }
    public void setUvindex(int uvindex) { this.uvindex = uvindex; }

    public double getSevererisk() { return severerisk; }
    public void setSevererisk(double severerisk) { this.severerisk = severerisk; }

    public String getSunrise() { return sunrise; }
    public void setSunrise(String sunrise) { this.sunrise = sunrise; }

    public int getSunriseEpoch() { return sunriseEpoch; }
    public void setSunriseEpoch(int sunriseEpoch) { this.sunriseEpoch = sunriseEpoch; }

    public String getSunset() { return sunset; }
    public void setSunset(String sunset) { this.sunset = sunset; }

    public int getSunsetEpoch() { return sunsetEpoch; }
    public void setSunsetEpoch(int sunsetEpoch) { this.sunsetEpoch = sunsetEpoch; }

    public double getMoonphase() { return moonphase; }
    public void setMoonphase(double moonphase) { this.moonphase = moonphase; }

    public String getConditions() { return conditions; }
    public void setConditions(String conditions) { this.conditions = conditions; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public List<String> getStations() { return stations; }
    public void setStations(List<String> stations) { this.stations = stations; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public List<Hour> getHours() { return hours; }
    public void setHours(List<Hour> hours) { this.hours = hours; }
}

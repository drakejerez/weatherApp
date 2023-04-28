package com.example.layerz;
import java.io.IOException;
// Author: Drake Jerez
// CNIT25501 Final Project
public class weatherGroup extends weather {
    // Weather Group will inherit the ability to get the weather from
    // weather.java, but will return a very different type of report
    private String group;
    private String[] forecastNums;
    public weatherGroup(String city, String state, String country) throws IOException, InterruptedException {
        super(city, state, country);
        weather tdy = new weather(city, state, country);
        String[] forecastNumbers = filterReport(tdy.apiCall);
        this.forecastNums = forecastNumbers;
        this.setGroup(this.makeWeatherReport(forecastNumbers));

        System.out.println(getGroup());
    }
    public String[] getForecastNums()
    {
        return this.forecastNums;
    }
    private void setGroup(String group)
    {
        this.group = group;
    }
    public String getGroup()
    {
        return this.group;
    }
    @Override public String makeWeatherReport(String[] inputFields)
    {
        // The weather report will be parsed as follow by index
        // 0            1           2           3       4 
        // minTemp      maxTemp     humidity    rain    wind
        String precipitation;
        String temperature;
        if (Float.parseFloat(inputFields[0]) <= 40.0)
        {
            temperature = "Freezing";
        }
        else if (Float.parseFloat(inputFields[1]) >= 80.0)
        {
            temperature = "Warm";
        }
        else {
            temperature = "Normal";
        }
        if (inputFields[3].toLowerCase().contains("rain")) {
            precipitation = "Rain";
        }
        else {
            precipitation = "Dry";
        }
        String groupReport = temperature + " " + precipitation;
        return groupReport;
    }
}

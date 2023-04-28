package com.example.layerz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
// Author: Drake Jerez
// CNIT 25501 Final Project
public class weather {
    
    String apiCall = "";
    public void callWeather(Float lat, Float lon) throws IOException, InterruptedException
    {
        // User will enter location details, need a lat and long numbers for the API request to work.
        // This is the http request for getting lat and long
        // http://api.openweathermap.org/geo/1.0/direct?q=West%20Lafayette,IN,US&limit=5&appid=2c246ec2dd8433644f68d4a4557d4477
        //var client = HttpClient.newHttpClient();
        //var weatherRequest = HttpRequest.newBuilder(URI.create(
          //  "https://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon="
           // + lon + "&cnt=1" + "&units=imperial" + "&appid=2c246ec2dd8433644f68d4a4557d4477")).build();
        //HttpResponse<String> response = client.send(weatherRequest, BodyHandlers.ofString());

        URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?lat=" + lat
                + "&lon=" + lon + "&cnt=1" + "&units=imperial" + "&appid=2c246ec2dd8433644f68d4a4557d4477");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        String responseBody;
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
                response.append(line);
        }
        bufferedReader.close();
        responseBody = response.toString();

        String strWeather = responseBody;
        strWeather = strWeather.replace("\"", "");
        strWeather = strWeather.substring(strWeather.indexOf(",main:"), strWeather.indexOf("dt_txt"));
        
        //System.out.println("\n This is the superclass weather: " + strWeather + "\n");
        
        this.apiCall = strWeather;
    }

    public static Float[] coords(String city, String state, String country) throws IOException {
        // Create an http client to send a request from, then collect the response as a string
        /*
        var client = HttpClient.newHttpClient();
        var locationRequest = HttpRequest.newBuilder(URI.create(
            "http://api.openweathermap.org/geo/1.0/direct?q="+city+","+state+","
            +country+"&limit=5&appid=2c246ec2dd8433644f68d4a4557d4477")).build();
        HttpResponse<String> response = client.send(locationRequest, BodyHandlers.ofString());
        */

        System.out.println("wCoords 1");
        URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q=" + city
                + "," + state + "," + country + "&limit=5&appid=2c246ec2dd8433644f68d4a4557d4477");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        System.out.println("wCoords 2");
        // The code below is breaking due to the use of input streams in the app version
        String responseBody;


        InputStream inputStream = (InputStream) connection.getContent();
        System.out.println("wCoordsInputStream 1");

        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println("wcoordsInputeStream 2");
        StringBuilder response = new StringBuilder();

        System.out.println("wCoords 3");
        String line;
        while ((line = in.readLine()) != null)
        {
            response.append(line);
        }

        in.close();
        responseBody = response.toString();

        //System.out.println(response.body());
        // Mangling the string response to isolate the latitute and longitude values
        System.out.println("bro");
        String strResponse = responseBody;
        strResponse = strResponse.replace("\"","");
        //System.out.println(strResponse);

        int latIndex = strResponse.indexOf("lat:");
        String latString = strResponse.substring(latIndex+4, latIndex+14);
        Float lat = Float.parseFloat(latString);
        
        int lonIndex = strResponse.indexOf("lon:");
        String lonString = strResponse.substring(lonIndex+4, lonIndex+14);
        Float lon = Float.parseFloat(lonString);

        Float[] coordinates = new Float[2];
        coordinates[0] = lat;
        coordinates[1] = lon;
        // WARNING: There is some loss of precision. It shouldnt matter, but be aware it isn't exact.
        //System.out.println(coordinates[0] + ", " + coordinates[1]);

        return coordinates;
    }

    public String[] filterReport(String report)
    {
        // weather.java 
        int minTempIndex = report.indexOf("temp_min:");
        int maxTempIndex = report.indexOf(",temp_max:");
        int pressureIndex = report.indexOf(",pressure:");
        String minTemp = report.substring(minTempIndex + 9, maxTempIndex);
        System.out.println(minTemp + " <- min temp");
        String maxTemp = report.substring(maxTempIndex + 10, pressureIndex);
        System.out.println(maxTemp + " <- max temp");

        int humidIndex = report.indexOf(",humidity:");
        int tempKfIndex = report.indexOf(",temp_kf:");
        String humidity = report.substring(humidIndex + 10, tempKfIndex);
        System.out.println(humidity + " <- humidity");
        //This needs to be reformatted, filter rerport should give me the raw values (no descriptions)
        // then make report needs to give me either a list of all the things (super) or a description
        // of the overall weather (sub)
        int rainIndex = report.indexOf(",description:");
        int iconIndex = report.indexOf(",icon:");
        String rain = report.substring(rainIndex + 13, iconIndex);
        System.out.println(rain + " <- weather description");

        int windIndex = report.indexOf("speed:");
        int degreeIndex = report.indexOf(",deg:");
        String wind = report.substring(windIndex + 6, degreeIndex);
        System.out.println(wind + " <- wind");

        String relevantFields = minTemp + "_" + maxTemp + "_" + humidity + "_" + rain + "_" + wind;
        //System.out.println(relevantFields);
        String[] fields = relevantFields.split("_");
        //System.out.println(fields[0] + fields[1] + fields[2] + fields[3] + fields[4]);
        return fields;
    }
    
    public String makeWeatherReport(String[] inputFields)
    {
        String weatherReport = "Here are today's forecast details: ";
        for(int i=0; i<inputFields.length; i++)
        {
            weatherReport = weatherReport + "|" + inputFields;
        }
        return weatherReport;
    }

    public weather(String city, String state, String country) throws IOException, InterruptedException
    {   
        //setTempRange();
        // Doesn't do anything :^)
        System.out.println("w 1");
        Float[] coordinates = coords(city, state, country);
        System.out.println("w 2");
        callWeather(coordinates[0], coordinates[1]);
        System.out.println("w 3");
    }
}

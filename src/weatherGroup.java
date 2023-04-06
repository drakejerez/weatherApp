import java.io.IOError;
import java.io.IOException;
import java.nio.file.attribute.GroupPrincipal;

import javax.lang.model.util.ElementScanner14;

public class weatherGroup extends weather
{
    // Weather Group will inherit the ability to get the weather from
    // weather.java, but will return a very different type of report

    private String group;

    public weatherGroup(String city, String state, String country) throws IOException, InterruptedException
    {
        super(city, state, country);
        String[] forecastNumbers = filterReport(super.apiCall);
        setGroup(this.makeWeatherReport(forecastNumbers));      
        System.out.println(getGroup());
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
        //System.out.println("wGroup mWRoverride: " + inputFields[0] + inputFields[1] + inputFields[2] + inputFields[3] + inputFields[4]);
        String precipitation;
        String temperature; 
        
        if (Float.parseFloat(inputFields[0]) <= 55.0)
        {
            temperature = "Freezing";
        }
        else if (Float.parseFloat(inputFields[1]) >= 80.0)
        {
            temperature = "Warm";
        }
        else
        {
            temperature = "Normal";
        }

        if (inputFields[3].toLowerCase().contains("rain"))
        {
            precipitation = "Rain";
        }
        else
        {
            precipitation = "Dry";
        }

        String groupReport = temperature + " " + precipitation;

        return groupReport;
        
    }
}

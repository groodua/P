package ArtCode.weather;

import org.apache.log4j.Logger;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WeatherData  {

    private static final Logger LOG = Logger.getLogger(WeatherData.class);
    private Map<String, String> weatherInfo = new HashMap<>();

    public WeatherData() {
    }

    public String getWeather (String nameCity){

        String adress = "http://api.openweathermap.org/data/2.5/weather?q=";
        String country = ",ua";
        String urlNew = adress + uppercase(nameCity) + country;
        try {
            URL url = new URL(urlNew);
            InputStream inputStream = url.openStream();

            JsonParser jsonParser = Json.createParser(inputStream);
            while (jsonParser.hasNext()){
                Event event = jsonParser.next();
                if (event == Event.KEY_NAME){
                    switch (jsonParser.getString()){
                        case "description" :
                            jsonParser.next();
                            event = Event.VALUE_STRING;
                            weatherInfo.put(jsonParser.toString(), event.toString());
                            break;

                        case "pressure" :
                            jsonParser.next();
                            event = Event.VALUE_STRING;
                            weatherInfo.put(jsonParser.toString(), event.toString());
                            break;

                        case "temp_max" :
                            jsonParser.next();
                            event = Event.VALUE_STRING;
                            weatherInfo.put(jsonParser.toString(), event.toString());
                            break;
                    }
                }
            }

        } catch (Exception e) {
            LOG.error(e);
        }
        return null;
    }

    private String uppercase (String word){
        if (word == null){
            LOG.info("нету слова");
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public void  showWeather (){
        for (Map.Entry<String, String> map : weatherInfo.entrySet()) {
             System.out.println(map.getKey() + " " + map.getValue());
        }

    }


}

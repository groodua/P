package ArtCode;

import ArtCode.weather.WeatherData;

public class TEst14 {

    public static void main(String[] args)  {

        WeatherData weatherData = new WeatherData();
        weatherData.getWeather("kiev");
        weatherData.showWeather();

    }
}

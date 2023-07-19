import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class Weather {
    private double temperature;
    private int humidity;
    private String description;

    public Weather(String weatherData) throws JSONException {
        JSONObject jsonObject = new JSONObject(weatherData);

        JSONObject main = jsonObject.getJSONObject("main");
        this.temperature = main.getDouble("temp");
        this.humidity = main.getInt("humidity");

        JSONArray weatherArray = jsonObject.getJSONArray("weather");
        JSONObject weather = weatherArray.getJSONObject(0);
        this.description = weather.getString("description");
    }

    private double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public String getTemperature() {
        return String.format("%.2f°C", kelvinToCelsius(temperature));
    }

    public String getHumidity() {
        return humidity + "%";
    }

    public String getDescription() {
        return description;
    }
}

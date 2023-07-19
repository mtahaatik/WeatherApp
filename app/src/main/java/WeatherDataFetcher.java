import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherDataFetcher {
    private static final String API_KEY = "api key here";

    public static String getWeatherData(String location) throws IOException {
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY;
        StringBuilder response = new StringBuilder();
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return response.toString();
    }
}

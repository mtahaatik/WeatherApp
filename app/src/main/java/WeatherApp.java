import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONException;

import java.io.IOException;

public class WeatherApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Weather App");

        TextField locationField = new TextField();
        locationField.setPromptText("Enter a location");

        Button submitButton = new Button("Get Weather");

        Label weatherLabel = new Label();

        submitButton.setOnAction(event -> {
            String location = locationField.getText();
            try {
                String weatherData = WeatherDataFetcher.getWeatherData(location);
                Weather weather = new Weather(weatherData);
                weatherLabel.setText("Temperature: " + weather.getTemperature() +
                        "\nHumidity: " + weather.getHumidity() +
                        "\nDescription: " + weather.getDescription());
            } catch (IOException e) {
                weatherLabel.setText("An error occurred while fetching weather data: " + e.getMessage());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        });

        VBox vbox = new VBox(locationField, submitButton, weatherLabel);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

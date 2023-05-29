import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BrowserApp extends Application {

   
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Browser.fxml"));
        primaryStage.setTitle("Web Browser");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class BrowserController {

    private TextField urlTextField;

    private Button goButton;

    private Button backButton;

    private Button homeButton;

    private WebView webView;

    private WebEngine webEngine;

    public void initialize() {
        webEngine = webView.getEngine();

        goButton.setOnAction(event -> {
            String url = urlTextField.getText();
            webEngine.load(url);
        });

        backButton.setOnAction(event -> {
            if (webEngine.getHistory().getCurrentIndex() > 0) {
                webEngine.getHistory().go(-1);
            }
        });

        homeButton.setOnAction(event -> {
            webEngine.load("https://www.google.com");
        });

        webEngine.locationProperty().addListener((observable, oldValue, newValue) -> {
            urlTextField.setText(newValue);
        });
    }
}

<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.layout.BorderPane?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.web.WebView?>
<?import javafx.scene.layout.HBox?>
<?import javafx.geometry.Insets?>

<BorderPane xmlns="http://javafx.com/javafx/15.0.1" xmlns:fx="http://javafx.com/fxml/1"
            fx:controller="BrowserController">
    <top>
        <HBox spacing="5" padding="5">
            <TextField fx:id="urlTextField" HBox.hgrow="ALWAYS"/>
            <Button fx:id="goButton" text="Go"/>
            <Button fx:id="backButton" text="Back"/>
            <Button fx:id="homeButton" text="Home"/>
        </HBox>
    </top>
    <center>
        <WebView fx:id="webView" BorderPane.margin="5">
            <WebEngine/>
        </WebView>
    </center>
</BorderPane>


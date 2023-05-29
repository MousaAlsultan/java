import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserInformationApp extends Application {

    public void start(Stage primaryStage) {
        // Create UI components
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Label dateLabel = new Label("Date:");
        DatePicker datePicker = new DatePicker();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Label genderLabel = new Label("Gender:");
        RadioButton maleRadioButton = new RadioButton("Male");
        RadioButton femaleRadioButton = new RadioButton("Female");
        ToggleGroup genderToggleGroup = new ToggleGroup();
        maleRadioButton.setToggleGroup(genderToggleGroup);
        femaleRadioButton.setToggleGroup(genderToggleGroup);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            // Get user input
            String name = nameField.getText();
            String email = emailField.getText();
            String date = datePicker.getValue().toString();
            String password = passwordField.getText();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";

            // Print the result
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Date: " + date);
            System.out.println("Password: " + password);
            System.out.println("Gender: " + gender);
        });

        // Create a layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(
                nameLabel, nameField,
                emailLabel, emailField,
                dateLabel, datePicker,
                passwordLabel, passwordField,
                genderLabel, maleRadioButton, femaleRadioButton,
                submitButton
        );

 
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("User Information App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

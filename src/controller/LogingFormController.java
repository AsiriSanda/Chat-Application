package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogingFormController {
    public TextField txtUsername;
    public TextField txtPassword;
    public AnchorPane logingForm;

    String username = "client1";
    String password = "123";

    String userName2 = "client2";
    String password2 = "123";

    public void LogingButton(ActionEvent actionEvent) throws IOException {
        if (txtUsername.getText().equals(username) && txtPassword.getText().equals(password)) {
            Parent load = FXMLLoader.load(getClass().getResource("../views/clientForm1.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } else if (txtUsername.getText().equals(userName2) && txtPassword.getText().equals(password2)) {
            Parent load = FXMLLoader.load(getClass().getResource("../views/clientForm2.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
    }
}

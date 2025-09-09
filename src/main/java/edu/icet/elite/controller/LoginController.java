package edu.icet.elite.controller;

import edu.icet.elite.bo.UserBo;
import edu.icet.elite.bo.UserBoImpl;
import edu.icet.elite.dto.UserDto;
import edu.icet.elite.exception.InvalidCredentialsException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private ComboBox<String> cmbRole;

    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField TxtPassword;

    @FXML
    private Button btnButton;

    private final UserBo userBo = new UserBoImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbRole.setItems(FXCollections.observableArrayList("Admin", "Receptionist"));
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        String role = cmbRole.getValue();
        String username = txtUserName.getText();
        String password = TxtPassword.getText();

        if (role == null || username.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "All fields are required.").show();
            return;
        }

        UserDto userDto = new UserDto(username, password, role);

        try {
            UserDto loggedInUser = userBo.login(userDto);
            if (!loggedInUser.getRole().equals(role)) {
                new Alert(Alert.AlertType.ERROR, "The selected role does not match the user's role.").show();
                return;
            }

            // Successful login, navigate to dashboard
            new Alert(Alert.AlertType.INFORMATION, "Login Successful!").show();
            navigateToDashboard();

        } catch (InvalidCredentialsException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void navigateToDashboard() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/DashBoardView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnButton.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Elite Driving School - Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to load the dashboard.").show();
        }
    }
}

package edu.lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    public Label lblRole;
    @FXML
    private PasswordField TxtPassword;

    @FXML
    private Button btnButton;

    @FXML
    private ComboBox<?> cmbRole;

    @FXML
    private Label forogotPasssword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) {

    }

}

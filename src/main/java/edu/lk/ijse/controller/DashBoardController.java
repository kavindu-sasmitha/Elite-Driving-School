package edu.lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class DashBoardController {

    private void loadView(String resourcePath, AnchorPane container) {
        try {
            if (container != null) {
                container.getChildren().clear(); // Clear existing content
                Parent root = FXMLLoader.load(getClass().getResource(resourcePath));
                if (root != null) {
                    container.getChildren().add(root); // Add the new content
                } else {
                    showAlert("Error", "Failed to load the requested view! Resource not found.");
                }
            } else {
                showAlert("Error", "Target container is null!");
            }
        } catch (IOException e) {
            showAlert("Error", "An error occurred while loading the view: " + e.getMessage());
            e.printStackTrace();
        }
        lbDateTime.setText(LocalDate.now().toString());
        lbTime.setText(LocalTime.now().withNano(0).toString());
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private AnchorPane ancMainContainer;

    @FXML
    private AnchorPane ancPage1;

    @FXML
    private Label lbDateTime;

    @FXML
    private Label lbTime;

    @FXML
    void btnCourseDetailsOnAction(ActionEvent event) {
        loadView("/edu/lk/ijse/view/coursedetails.fxml", ancPage1);

    }

    @FXML
    void btnCourseOnAction(ActionEvent event) {
        loadView("/edu/lk/ijse/view/course/ManageCourse.fxml", ancPage1);

    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) {
        loadView("/edu/lk/ijse/view/DashBoardView.fxml", ancPage1);

    }

    @FXML
    void btnEnrollCourseOnAction(ActionEvent event) {
        loadView("/edu/lk/ijse/view/course/CourseEnroll.fxml", ancPage1);

    }

    @FXML
    void btnInstructorOnAction(ActionEvent event) {
        loadView("/edu/lk/ijse/view/instructor/ManageInstructor.fxml", ancPage1);

    }

    @FXML
    void btnLessonOnAction(ActionEvent event) {
        loadView("/edu/lk/ijse/view/course/lesson.fxml", ancPage1);

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {


    }

    @FXML
    void btnPaymentDetailsOnAction(ActionEvent event) {

    }

    @FXML
    void btnStudentOnAction(ActionEvent event) {
        loadView("/edu/lk/ijse/view/student/ManageStudent.fxml", ancPage1);

    }

}

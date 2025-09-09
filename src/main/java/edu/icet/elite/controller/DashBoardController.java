package edu.icet.elite.controller;

import edu.icet.elite.bo.DashBoardBo;
import edu.icet.elite.bo.DashBoardBoImpl;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {

    @FXML
    private AnchorPane ancMainContainer;

    @FXML
    private Label lbDateTime;

    @FXML
    private Label lblStudentCount;

    @FXML
    private Label lblCourseCount;

    @FXML
    private Label lblInstructorCount;

    private final DashBoardBo dashBoardBo = new DashBoardBoImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCounts();
        startClock();
    }

    private void loadCounts() {
        lblStudentCount.setText(String.valueOf(dashBoardBo.getStudentCount()));
        lblCourseCount.setText(String.valueOf(dashBoardBo.getCourseCount()));
        lblInstructorCount.setText(String.valueOf(dashBoardBo.getInstructorCount()));
    }

    private void startClock() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            lbDateTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) {
        // Reload the main dashboard view (or simply do nothing)
        // For now, we can just clear the main container
        ancMainContainer.getChildren().clear();
        // Or reload the initial state if it was complex
    }

    @FXML
    void btnStudentOnAction(ActionEvent event) {
        loadPage("/view/student/ManageStudent.fxml");
    }

    @FXML
    void btnEnrollCourseOnAction(ActionEvent event) {
        loadPage("/view/course/CourseEnroll.fxml");
    }

    @FXML
    void btnCourseOnAction(ActionEvent event) {
        loadPage("/view/course/ManageCourse.fxml");
    }

    @FXML
    void btnLessonOnAction(ActionEvent event) {
        loadPage("/view/course/lesson.fxml");
    }

    @FXML
    void btnInstructorOnAction(ActionEvent event) {
        loadPage("/view/instructor/ManageInstructor.fxml");
    }

    @FXML
    void btnPaymentDetailsOnAction(ActionEvent event) {
        // Assuming a PaymentDetails.fxml, which is not in the initial file list
        // I will create a placeholder or ignore for now.
        new Alert(Alert.AlertType.INFORMATION, "Payment Details page is not yet implemented.").show();
    }

    @FXML
    void btnCourseDetailsOnAction(ActionEvent event) {
        // This might be the same as ManageCourse or a different view.
        loadPage("/view/course/ManageCourse.fxml");
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/loginView/LoginController.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ancMainContainer.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Elite Driving School - Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPage(String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            ancMainContainer.getChildren().clear();
            ancMainContainer.getChildren().add(root);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to load page: " + fxmlPath).show();
        }
    }
}

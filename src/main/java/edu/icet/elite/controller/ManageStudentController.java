package edu.icet.elite.controller;

import edu.icet.elite.bo.StudentBo;
import edu.icet.elite.bo.StudentBoImpl;
import edu.icet.elite.dto.StudentDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ManageStudentController implements Initializable {

    @FXML
    private TableView<StudentDto> tblStudents;

    @FXML
    private TableColumn<StudentDto, Integer> colStudentId;

    @FXML
    private TableColumn<StudentDto, String> colName;

    @FXML
    private TableColumn<StudentDto, String> colAddress;

    @FXML
    private TableColumn<StudentDto, String> colContact;

    @FXML
    private TableColumn<StudentDto, Date> colRegDate;

    private final StudentBo studentBo = new StudentBoImpl();
    private final ObservableList<StudentDto> studentList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colRegDate.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));

        loadStudents();
    }

    private void loadStudents() {
        studentList.clear();
        List<StudentDto> students = studentBo.getAllStudents();
        studentList.addAll(students);
        tblStudents.setItems(studentList);
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/student/RegisterStudent.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Register New Student");
            stage.setScene(new Scene(root));

            // Pass this controller to the registration form so it can call a refresh method
            RegisterStudentController registerController = loader.getController();
            registerController.setManageStudentController(this);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Could not load the registration form.").show();
        }
    }

    // This method will be called by the registration form to refresh the table
    public void refreshTable() {
        loadStudents();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        StudentDto selectedStudent = tblStudents.getSelectionModel().getSelectedItem();
        if (selectedStudent == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a student to update.").show();
            return;
        }
        // Open the registration form in "update mode"
        // This is a more complex scenario that involves passing data to the new window
        new Alert(Alert.AlertType.INFORMATION, "Update functionality is not fully implemented yet.").show();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        StudentDto selectedStudent = tblStudents.getSelectionModel().getSelectedItem();
        if (selectedStudent == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a student to delete.").show();
            return;
        }

        studentBo.deleteStudent(selectedStudent.getStudentId());
        new Alert(Alert.AlertType.INFORMATION, "Student deleted successfully.").show();
        loadStudents(); // Refresh table
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Search functionality is not implemented yet.").show();
    }
}

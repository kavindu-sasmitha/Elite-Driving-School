package edu.icet.elite;

import edu.icet.elite.db.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/loginView/LoginController.fxml"));
        primaryStage.setTitle("Elite Driving School - Login");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        // Ensure Hibernate shuts down gracefully
        primaryStage.setOnCloseRequest(event -> {
            HibernateUtil.shutdown();
        });
    }
}

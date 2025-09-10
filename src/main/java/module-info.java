module Elite.Driving.School {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;
    requires jbcrypt;

    // Open packages to Hibernate
    opens edu.icet.elite.entity to org.hibernate.orm.core;

    // Open packages to JavaFX
    opens edu.icet.elite.controller to javafx.fxml;
    opens edu.icet.elite.dto to javafx.base; // For TableView

    exports edu.icet.elite;
    exports edu.icet.elite.controller;
    exports edu.icet.elite.dto;
    exports edu.icet.elite.bo;
    exports edu.icet.elite.db;
    exports edu.icet.elite.exception;
}
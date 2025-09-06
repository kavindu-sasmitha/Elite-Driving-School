module edu.lk.ijse {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires net.sf.jasperreports.core;
    requires java.mail;

    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;

    opens edu.lk.ijse.config to jakarta.persistence;
    opens edu.lk.ijse.entity to org.hibernate.orm.core;

    opens edu.lk.ijse.controller to javafx.fxml;
    opens edu.lk.ijse.dto.tm to javafx.base;

    exports edu.lk.ijse.config;
    // මේ line එක add කරන්න
    exports edu.lk.ijse;
}
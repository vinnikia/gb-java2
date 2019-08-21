module Java2 {

    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    opens lesson4;
    opens lesson7.client;
}
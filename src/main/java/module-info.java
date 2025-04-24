module com.ijse.gdse.serenitymentalhealththerapycenter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ijse.gdse.serenitymentalhealththerapycenter to javafx.fxml;
    exports com.ijse.gdse.serenitymentalhealththerapycenter;
    exports com.ijse.gdse.serenitymentalhealththerapycenter.controller;
    opens com.ijse.gdse.serenitymentalhealththerapycenter.controller to javafx.fxml;
    exports com.ijse.gdse.serenitymentalhealththerapycenter.controller.Login;
    opens com.ijse.gdse.serenitymentalhealththerapycenter.controller.Login to javafx.fxml;
}
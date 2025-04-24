package com.ijse.gdse.serenitymentalhealththerapycenter.controller;

import com.ijse.gdse.serenitymentalhealththerapycenter.bo.BOFactory;
import com.ijse.gdse.serenitymentalhealththerapycenter.bo.BOType;
import com.ijse.gdse.serenitymentalhealththerapycenter.bo.custom.AppointmentBO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AppointmentController implements Initializable {

    @FXML
    private Button PatientsBTN;

    @FXML
    private Button addAppointmentBTN;

    @FXML
    private Button addDoctors;

    @FXML
    private Button addPrograms;

    @FXML
    private AnchorPane appointmentPage;

    @FXML
    private Label date;

    @FXML
    private Label docLoadLabel;

    @FXML
    private ImageView image;

    @FXML
    private Label patientAddress;

    @FXML
    private Label patientDOB;

    @FXML
    private Label patientEMAIL;

    @FXML
    private Label patientGender;

    @FXML
    private Label patientID;

    @FXML
    private Label patientNIC;

    @FXML
    private Label patientName;

    @FXML
    private Label patientTelNO;

    @FXML
    private TextField payAMOUNT;

    @FXML
    private Label paymentID;

    @FXML
    private ComboBox<String> paymentMethod;

    @FXML
    private Button printBillBTN;

    @FXML
    private ListView<?> programmsListView;

    @FXML
    private Button registerPatient;

    @FXML
    private Button reset;

    @FXML
    private TextField search;

    @FXML
    private Button searchPatient;

    @FXML
    private DatePicker sessionDate;

    @FXML
    private Label sessionID;

    @FXML
    private TextField sessionNotes;

    @FXML
    private TextField sessionTime;

    @FXML
    private Label time;

    @FXML
    private VBox vbox1;

    @FXML
    private VBox vbox2;

    @FXML
    private Button viewAppointmentsBTN;

    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    AppointmentBO appointmentBO = BOFactory.getInstance().getBO(BOType.APPOINTMENT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateDateTime();
        try{
            refreshPage();
        }catch(Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to load the Page",ButtonType.CLOSE).show();
        }
    }


    private void updateDateTime() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    String currentTime = LocalTime.now().format(timeFormatter);
                    time.setText(currentTime);
                    String currentDate = LocalDate.now().format(formatter);
                    date.setText(currentDate);
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void refreshPage(){
        generateNextAppointmentID();
        generateNextPatientID();
        generateNextPaymentID();
        paymentMethod.setItems(FXCollections.observableArrayList("Card Payment","Cash Payment"));
        sessionTime.clear();
        sessionNotes.clear();
        payAMOUNT.clear();
        docLoadLabel.setDisable(true);
        programmsListView.refresh();
        vbox1.setVisible(false);
        vbox2.setVisible(false);

    }

    private void generateNextAppointmentID() {
        String nextAptID =appointmentBO.getNextSessionID();
        sessionID.setText(nextAptID);
    }

    private void generateNextPatientID() {
        String nextPatientId = appointmentBO.getNextPatientID();
        patientID.setText(nextPatientId);
    }

    private void generateNextPaymentID() {
        String nextPaymentID = appointmentBO.getNextPaymentID();
        paymentID.setText(nextPaymentID);
    }

    @FXML
    void PatientsBTNAction(ActionEvent event) {

    }

    @FXML
    void addAppointmentBTNAction(ActionEvent event) {

    }

    @FXML
    void addDoctorsAction(MouseEvent event) {

    }

    @FXML
    void addProgramsAction(MouseEvent event) {

    }

    @FXML
    void printBillBTNAction(ActionEvent event) {

    }

    @FXML
    void registerPatientAction(MouseEvent event) {

    }

    @FXML
    void resetAction(ActionEvent event) {

    }

    @FXML
    void searchPatientAction(MouseEvent event) {

    }

    @FXML
    void viewAppointmentsBTNAction(ActionEvent event) {

    }

}

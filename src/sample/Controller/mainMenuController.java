package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainMenuController implements Initializable {

    @FXML
    private Button btnTenants;

    @FXML
    private Button btnProperties;

    @FXML
    private Button btnRentalAllocations;

    @FXML
    private Button btnPayments;

    @FXML
    private Button btnClose;

    @FXML
    void close(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void openTenants(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../Views/Tenants.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Solas Property Rental - Tenants");
            stage.setScene(new Scene(root, 800, 400));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openProperties(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../Views/rentalProperties.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Solas Property Rental - Properties Controller");
            stage.setScene(new Scene(root, 700, 600));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openRentalAllocations(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../Views/RentalAllocations.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Solas Property Rental - Rental Allocations");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openPayments(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../Views/rentPayments.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Solas Property Rental - Payments");
            stage.setScene(new Scene(root, 640, 360));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

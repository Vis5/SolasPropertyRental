package sample.Controller;

import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class propertyEditorController implements Initializable {

    @FXML
    private TextField txtPropertyCode;

    @FXML
    private ChoiceBox<String> cbxPropertyTypes;

    @FXML
    private Button btnOK;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtC;

    @FXML
    private TextField txtState;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtZipCode;

    @FXML
    private ChoiceBox<String> cbxOccupancyStatus;

    @FXML
    private CheckBox chbxWasherDryer;

    @FXML
    private CheckBox chbxHardWoodFloor;

    @FXML
    private TextField txtBedrooms;

    @FXML
    private TextField txtMonthlyRent;

    @FXML
    private TextField txtBathrooms;

    @FXML
    private CheckBox chbxIndoorCarage;

    @FXML
    private CheckBox chbxHasCarpet;

    @FXML
    private CheckBox chbxPetsAllowed;
    private Connection connection;

    @FXML
    void close(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        connection = new ConnectionClass().getConnection();
        ObservableList<String> propertyTypes = FXCollections.observableArrayList(
                "Apartment",
                "Townhouse",
                "Single Family",
                "Other"
        );
        cbxPropertyTypes.setItems(propertyTypes);
        cbxPropertyTypes.setValue("Apartment");
        ObservableList<String> occupancyStatus = FXCollections.observableArrayList(
                "Available",
                "Occupied",
                "Needs Repair",
                "Other"
        );
        cbxOccupancyStatus.setItems(occupancyStatus);
        cbxPropertyTypes.setValue("Available");
    }

    @FXML
    void submit(ActionEvent event) {
        String sql = "INSERT INTO RentalProperties VALUES("
                +"0,'"
                +txtPropertyCode.getText()+"','"
                +cbxPropertyTypes.getSelectionModel().getSelectedItem().toString()+"','"
                +txtAddress.getText()+"','"
                +txtC.getText()+"','"
                +txtState.getText()+"',"
                +txtZipCode.getText()+","
                +txtBedrooms.getText()+","
                +txtBathrooms.getText()+","
                +chbxHasCarpet.isSelected()+","
                +chbxHardWoodFloor.isSelected()+","
                +chbxIndoorCarage.isSelected()+","
                +chbxWasherDryer.isSelected()+","
                +chbxPetsAllowed.isSelected()+",'"
                +cbxOccupancyStatus.getSelectionModel().getSelectedItem().toString()+"',"
                +txtMonthlyRent.getText()+")";
        System.out.println(sql);
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.executeUpdate(sql);
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

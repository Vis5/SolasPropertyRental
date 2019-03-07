package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class rentalPropertiesController implements Initializable {

    @FXML
    private TableView<?> dgvRentalProperties;

    @FXML
    private RadioButton rdoShowAllFields;

    @FXML
    private ToggleGroup show;

    @FXML
    private RadioButton rdoShowSomeFields;

    @FXML
    private RadioButton rdoShowDistinct;

    @FXML
    private ComboBox<String> cbxColumns;

    @FXML
    private ComboBox<String> cbxAscendingDescending;

    @FXML
    private Button btnExecute;

    @FXML
    private Label grpFieldsToShow;

    @FXML
    private Button btnNewProperty;

    @FXML
    private Button btnClose;

    @FXML
    void close(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbxAscendingDescending.getItems().removeAll(cbxAscendingDescending.getItems());
        cbxAscendingDescending.getItems().addAll("Ascending", "Descending");
        cbxAscendingDescending.getSelectionModel().select("Ascending");

        cbxColumns.getItems().removeAll(cbxColumns.getItems());
        cbxColumns.getItems().addAll("RentalPropertyID", "ZIPCode", "IndoorGarage", "PropertyCode", "Bedrooms",
                "HasWasherDryer", "Property Type", "Bathrooms", "PetsAllowed", "Address",
                "HasCarpet", "OccupancyStatus", "City", "HasAirCondition", "MonthlyRent", "State", "HardWoodFloor");
        cbxColumns.getSelectionModel().select("RentalPropertyID");

    }
}

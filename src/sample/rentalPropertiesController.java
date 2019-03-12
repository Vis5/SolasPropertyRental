package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class rentalPropertiesController {

    private Main main;

    @FXML
    private TableView<Property> dgvRentalProperties;

    private TableColumn<Property, String> propertyTypeColumn;

    @FXML
    private TableColumn<Property, String> cityColumn;

    @FXML
    private TableColumn<Property, Double> bedroomsColumn;

    @FXML
    private TableColumn<Property, Double> bathroomsColumn;

    @FXML
    private TableColumn<Property, String> occupancyStatusColumn;

    @FXML
    private TableColumn<Property, Double> monthlyRentColumn;

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

    public rentalPropertiesController() {
    }

    @FXML
    private void initialize(){

        propertyTypeColumn.setCellValueFactory(cellData -> cellData.getValue().propertyTypeProperty());
        cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        bedroomsColumn.setCellValueFactory(cellData -> cellData.getValue().bedroomsProperty().asObject());
        bathroomsColumn.setCellValueFactory(cellData -> cellData.getValue().bathroomsProperty().asObject());
        occupancyStatusColumn.setCellValueFactory(cellData -> cellData.getValue().occupancyStatusProperty());
        monthlyRentColumn.setCellValueFactory(cellData -> cellData.getValue().monthlyRentProperty().asObject());

        cbxAscendingDescending.getItems().removeAll(cbxAscendingDescending.getItems());
        cbxAscendingDescending.getItems().addAll("Ascending", "Descending");
        cbxAscendingDescending.getSelectionModel().select("Ascending");

        cbxColumns.getItems().removeAll(cbxColumns.getItems());
        cbxColumns.getItems().addAll("RentalPropertyID", "ZIPCode", "IndoorGarage", "PropertyCode", "Bedrooms",
                "HasWasherDryer", "Property Type", "Bathrooms", "PetsAllowed", "Address",
                "HasCarpet", "OccupancyStatus", "City", "HasAirCondition", "MonthlyRent", "State", "HardWoodFloor");
        cbxColumns.getSelectionModel().select("RentalPropertyID");
    }

    public void setMain(Main main) {
        this.main = main;

        // Add observable list data to the table
        dgvRentalProperties.setItems(main.getPropertyData());
    }
}

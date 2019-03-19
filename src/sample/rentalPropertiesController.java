package sample;

import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/*
CREATE TABLE RentalProperties(
    RentalPropertyID int PRIMARY KEY AUTO_INCREMENT,
    PropertyCode varchar(7),
    PropertyType varchar(25),
    Address varchar(100),
    City varchar(25),
    State varchar(25),
    ZIPCode int,
    Bedrooms int,
    Bathrooms double,
    HasCarpet boolean,
    HardWoodFloor boolean,
    IndoorGarage boolean,
    HasWasherDryer boolean,
    PetsAllowed boolean,
    OccupancyStatus varchar(25),
    MonthlyRent double);
 */

public class rentalPropertiesController {

    private Main main;

    @FXML
    private TableView<Property> dgvRentalProperties;

    @FXML
    private TableColumn<Property, String> propertyTypeColumn;

    @FXML
    private TableColumn<Property, String> cityColumn;

    @FXML
    private TableColumn<Property, Integer> bedroomsColumn;

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

    private ObservableList<Property> properties_list = FXCollections.observableArrayList();
    Connection connection;

    @FXML
    void close(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void execute(ActionEvent event) {
        dgvRentalProperties.getColumns().removeAll();
//        dgvRentalProperties.getColumns().remove(propertyTypeColumn);
    }

    public rentalPropertiesController() {
    }

    @FXML
    private void initialize(){

        cbxAscendingDescending.getItems().removeAll(cbxAscendingDescending.getItems());
        cbxAscendingDescending.getItems().addAll("Ascending", "Descending");
        cbxAscendingDescending.getSelectionModel().select("Ascending");

        cbxColumns.getItems().removeAll(cbxColumns.getItems());
        cbxColumns.getItems().addAll("RentalPropertyID", "ZIPCode", "IndoorGarage", "PropertyCode", "Bedrooms",
                "HasWasherDryer", "Property Type", "Bathrooms", "PetsAllowed", "Address",
                "HasCarpet", "OccupancyStatus", "City", "HasAirCondition", "MonthlyRent", "State", "HardWoodFloor");
        cbxColumns.getSelectionModel().select("RentalPropertyID");


        propertyTypeColumn.setCellValueFactory(new PropertyValueFactory<>("PropertyType"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("City"));
        bedroomsColumn.setCellValueFactory(new PropertyValueFactory<>("Bedrooms"));
        bathroomsColumn.setCellValueFactory(new PropertyValueFactory<>("Bathrooms"));
        occupancyStatusColumn.setCellValueFactory(new PropertyValueFactory<>("OccupancyStatus"));
        monthlyRentColumn.setCellValueFactory(new PropertyValueFactory<>("MonthlyRent"));
        connection = new ConnectionClass().getConnection();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM RentalProperties");

            while(rs.next()){
                properties_list.add(new Property(
                        rs.getInt("RentalPropertyID"),
                        rs.getString("PropertyCode"),
                        rs.getString("PropertyType"),
                        rs.getString("Address"),
                        rs.getString("City"),
                        rs.getString("State"),
                        rs.getInt("ZIPCode"),
                        rs.getInt("Bedrooms"),
                        rs.getDouble("Bathrooms"),
                        rs.getBoolean("HasCarpet"),
                        rs.getBoolean("HardwoodFloor"),
                        rs.getBoolean("IndoorGarage"),
                        rs.getBoolean("HasWasherDryer"),
                        rs.getBoolean("PetsAllowed"),
                        rs.getString("OccupancyStatus"),
                        rs.getDouble("MonthlyRent")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dgvRentalProperties.setItems(properties_list);

    }

}

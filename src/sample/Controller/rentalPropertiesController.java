package sample.Controller;

import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Main;
import sample.Model.Property;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    private TableColumn<Property, Integer> rentalPropertyIDColumn;

    @FXML
    private TableColumn<Property, String> propertyCodeColumn;

    @FXML
    private TableColumn<Property, String> propertyTypeColumn;

    @FXML
    private TableColumn<Property, String> addressColumn;

    @FXML
    private TableColumn<Property, String> cityColumn;

    @FXML
    private TableColumn<Property, String> stateColumn;

    @FXML
    private TableColumn<Property, Integer> zipCodeColumn;

    @FXML
    private TableColumn<Property, Integer> bedroomsColumn;

    @FXML
    private TableColumn<Property, Double> bathroomsColumn;

    @FXML
    private TableColumn<Property, Boolean> hasCarpetColumn;

    @FXML
    private TableColumn<Property, Boolean> hardwoodFloorColumn;

    @FXML
    private TableColumn<Property, Boolean> indoorGarageColumn;

    @FXML
    private TableColumn<Property, Boolean> hasWasherDryerColumn;

    @FXML
    private TableColumn<Property, Boolean> petsAllowedColumn;

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
    private CheckBox some1, some2, some3, some4, some5, some6, some7, some8, some9, some10, some11, some12, some13, some14, some15, some16, some17;

    @FXML
    private CheckBox dist1, dist2, dist3, dist4, dist5, dist6, dist7, dist8, dist9, dist10, dist11, dist12, dist13, dist14, dist15, dist16, dist17;

    private ObservableList<Property> properties_list = FXCollections.observableArrayList();
    Connection connection;

    @FXML
    void close(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void newProperty(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../Views/propertyEditor.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Solas Property Rental - New Rental Property");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void execute(ActionEvent event) {
        dgvRentalProperties.getColumns().removeAll(dgvRentalProperties.getColumns());
        if (rdoShowAllFields.isSelected()) {
            dgvRentalProperties.getColumns().addAll(rentalPropertyIDColumn, propertyCodeColumn, propertyTypeColumn,
                    addressColumn, cityColumn, stateColumn, zipCodeColumn, bedroomsColumn, bathroomsColumn, hasCarpetColumn,
                    hardwoodFloorColumn, indoorGarageColumn, hasWasherDryerColumn, petsAllowedColumn, occupancyStatusColumn, monthlyRentColumn);
        } else if (rdoShowSomeFields.isSelected()) {
            if (some1.isSelected()) dgvRentalProperties.getColumns().add(rentalPropertyIDColumn);
            if (some2.isSelected()) dgvRentalProperties.getColumns().add(propertyCodeColumn);
            if (some3.isSelected()) dgvRentalProperties.getColumns().add(propertyTypeColumn);
            if (some4.isSelected()) dgvRentalProperties.getColumns().add(addressColumn);
            if (some5.isSelected()) dgvRentalProperties.getColumns().add(cityColumn);
            if (some6.isSelected()) dgvRentalProperties.getColumns().add(stateColumn);
            if (some7.isSelected()) dgvRentalProperties.getColumns().add(zipCodeColumn);
            if (some8.isSelected()) dgvRentalProperties.getColumns().add(bedroomsColumn);
            if (some9.isSelected()) dgvRentalProperties.getColumns().add(bathroomsColumn);
            if (some10.isSelected()) dgvRentalProperties.getColumns().add(hasCarpetColumn);
            if (some11.isSelected()) dgvRentalProperties.getColumns().add(hardwoodFloorColumn);
            if (some12.isSelected()) dgvRentalProperties.getColumns().add(indoorGarageColumn);
            if (some13.isSelected()) dgvRentalProperties.getColumns().add(hasWasherDryerColumn);
            if (some14.isSelected()) dgvRentalProperties.getColumns().add(petsAllowedColumn);
            if (some15.isSelected()) dgvRentalProperties.getColumns().add(occupancyStatusColumn);
            if (some16.isSelected()) dgvRentalProperties.getColumns().add(monthlyRentColumn);
        } else if (rdoShowDistinct.isSelected()) {
            if (dist1.isSelected()) dgvRentalProperties.getColumns().add(rentalPropertyIDColumn);
            if (dist2.isSelected()) dgvRentalProperties.getColumns().add(propertyCodeColumn);
            if (dist3.isSelected()) dgvRentalProperties.getColumns().add(propertyTypeColumn);
            if (dist4.isSelected()) dgvRentalProperties.getColumns().add(addressColumn);
            if (dist5.isSelected()) dgvRentalProperties.getColumns().add(cityColumn);
            if (dist6.isSelected()) dgvRentalProperties.getColumns().add(stateColumn);
            if (dist7.isSelected()) dgvRentalProperties.getColumns().add(zipCodeColumn);
            if (dist8.isSelected()) dgvRentalProperties.getColumns().add(bedroomsColumn);
            if (dist9.isSelected()) dgvRentalProperties.getColumns().add(bathroomsColumn);
            if (dist10.isSelected()) dgvRentalProperties.getColumns().add(hasCarpetColumn);
            if (dist11.isSelected()) dgvRentalProperties.getColumns().add(hardwoodFloorColumn);
            if (dist12.isSelected()) dgvRentalProperties.getColumns().add(indoorGarageColumn);
            if (dist13.isSelected()) dgvRentalProperties.getColumns().add(hasWasherDryerColumn);
            if (dist14.isSelected()) dgvRentalProperties.getColumns().add(petsAllowedColumn);
            if (dist15.isSelected()) dgvRentalProperties.getColumns().add(occupancyStatusColumn);
            if (dist16.isSelected()) dgvRentalProperties.getColumns().add(monthlyRentColumn);
        }
        try {
            System.out.println(cbxColumns.getSelectionModel().getSelectedItem());
            String asc = cbxAscendingDescending.getSelectionModel().getSelectedItem();
            if (asc == "Ascending") {
                asc = "ASC";
            } else if (asc == "Descending") {
                asc = "DESC";
            }
            String distinct = "";
            if (rdoShowDistinct.isSelected()) {
                asc += "DISTINCT";
            }
            ResultSet rs = connection.createStatement().executeQuery("SELECT "+distinct+" * FROM RentalProperties ORDER BY " + cbxColumns.getSelectionModel().getSelectedItem() + " " + asc);

            properties_list.removeAll(properties_list);
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
        rdoShowAllFields.setSelected(true);

        rentalPropertyIDColumn.setCellValueFactory(new PropertyValueFactory<>("RentalPropertyID"));
        propertyCodeColumn.setCellValueFactory(new PropertyValueFactory<>("PropertyCode"));
        propertyTypeColumn.setCellValueFactory(new PropertyValueFactory<>("PropertyType"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("City"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<>("State"));
        zipCodeColumn.setCellValueFactory(new PropertyValueFactory<>("ZIPCode"));
        bedroomsColumn.setCellValueFactory(new PropertyValueFactory<>("Bedrooms"));
        bathroomsColumn.setCellValueFactory(new PropertyValueFactory<>("Bathrooms"));
        hasCarpetColumn.setCellValueFactory(new PropertyValueFactory<>("HasCarpet"));
        hardwoodFloorColumn.setCellValueFactory(new PropertyValueFactory<>("HardwoodFloor"));
        indoorGarageColumn.setCellValueFactory(new PropertyValueFactory<>("IndoorGarage"));
        hasWasherDryerColumn.setCellValueFactory(new PropertyValueFactory<>("HasWasherDryer"));
        petsAllowedColumn.setCellValueFactory(new PropertyValueFactory<>("PetsAllowed"));
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

package sample;

import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
//SolarDB table name tenants
/*
* Create table tenants(
tenantID int Primary key AUTO_INCREMENT,
tenantCode VARCHAR(7),
tenantName varchar(255),
tenantStatus varchar(255),
tenantNumber varchar(255)
)*/
public class Tenants implements Initializable {

    @FXML
    private TableView<Tenant> dgvTenants;
    @FXML
    private TableColumn<Tenant, Integer> col_TenantID;
    @FXML
    private TableColumn<Tenant, String> col_TenantCode;
    @FXML
    private TableColumn<Tenant, String> col_TenantName;
    @FXML
    private TableColumn<Tenant, String> col_TenantStat;
    @FXML
    private TableColumn<Tenant, String> col_TenantNumber;


    @FXML
    private MaskedTextField txtTenantCode;

    @FXML
    private TextField txtTenantName;

    @FXML
    private ComboBox<String> cbxMaritalStatus;

    @FXML
    private TextField txtContactNumber;

    @FXML
    private Button Reset;

    @FXML
    private Button Submit;

    @FXML
    private Button Close;

    private ObservableList<Tenant> tenant_List = FXCollections.observableArrayList();

    Connection connection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> status = FXCollections.observableArrayList(
                "Other",
                "Single no children",
                "Widow no children",
                "Married no children",
                "Single with children",
                "Widow with children",
                "Divorced no children",
                "Married with children",
                "Separeted no children",
                "Divorced no children",
                "Separeted with children"
        );
        cbxMaritalStatus.setItems(status);

        col_TenantID.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_TenantCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        col_TenantName.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_TenantStat.setCellValueFactory(new PropertyValueFactory<>("stat"));
        col_TenantNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        connection = new ConnectionClass().getConnection();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM TENANTS");

            while(rs.next()){
                tenant_List.add(new Tenant(rs.getInt("TenantID"), rs.getString("TenantCode"), rs.getString("TenantName"), rs.getString("TenantStatus"), rs.getString("TenantNumber")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dgvTenants.setItems(tenant_List);

    }
    @FXML
    public void cls(ActionEvent actionEvent) {

    }
    @FXML
    void reset(ActionEvent event) {

    }


    @FXML
    public void submit(ActionEvent event) {
        if(txtTenantCode.getLength() < 7) return;//check if every textfield is filled
        if(txtTenantName.getText().isEmpty()) return;
        if(cbxMaritalStatus.getValue().isEmpty()) return;
        if(txtContactNumber.getText().isEmpty()) return;
        String sql = "INSERT INTO tenants (TenantCode, TenantName, TenantStatus, TenantNumber) VALUES('"
                +txtTenantCode.getText()+"','"
                +txtTenantName.getText()+"','"
                +cbxMaritalStatus.getValue()+"','"
                +txtContactNumber.getText()+
                "')";
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.executeUpdate(sql);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM TENANTS");
            tenant_List.removeAll();
            while(rs.next()){
                tenant_List.add(new Tenant(rs.getInt("TenantID"), rs.getString("TenantCode"), rs.getString("TenantName"), rs.getString("TenantStatus"), rs.getString("TenantNumber")));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

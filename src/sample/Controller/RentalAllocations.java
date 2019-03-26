package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import connectivity.ConnectionClass;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.MaskedTextField;
import sample.Model.Rent_Alloc;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
/*
create table RentalAllocations(
 id int PRIMARY KEY AUTO_INCREMENT,
 loc_Code varchar(12),
    loc_Date Date,
    prop_Code varchar(9),
    tenantCode varchar(7),
    start_Date date,
    contract_length varchar(10),
    monthlyRent int
);
 */
public class RentalAllocations implements Initializable{

    @FXML
    private TableView<Rent_Alloc> dgvRentalAllocation;

    @FXML
    private TableColumn<Rent_Alloc, Integer> col_loc_ID;

    @FXML
    private TableColumn<Rent_Alloc, String> col_loc_Code;

    @FXML
    private TableColumn<Rent_Alloc, String> col_loc_Date;

    @FXML
    private TableColumn<Rent_Alloc, String> col_prop_Code;

    @FXML
    private TableColumn<Rent_Alloc, String> col_TenantCode;

    @FXML
    private TableColumn<Rent_Alloc, String> col_StartDate;

    @FXML
    private TableColumn<Rent_Alloc, String> col_cont_Length;

    @FXML
    private TableColumn<Rent_Alloc, Integer> col_monthlyRent;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSubmit;

    @FXML
    private ComboBox<String> cbxContractLength;

    @FXML
    private TextField txtMonthlyRent;

    @FXML
    private DatePicker dtpDateAllocated;

    @FXML
    private DatePicker dtpStartDate;

    @FXML
    private MaskedTextField txtAllocationCode;

    @FXML
    private MaskedTextField txtTenantCode;

    @FXML
    private MaskedTextField txtPropertyCode;

    @FXML
    private Button btnClose;

    private ObservableList<String> contract_length;
    private ObservableList<Rent_Alloc> rent_List = FXCollections.observableArrayList();
    private Connection connection;
    private LocalDate localDate;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contract_length = FXCollections.observableArrayList(
                "1 Month",
                "2 Month",
                "3 Month",
                "4 Month",
                "6 Month",
                "9 Month",
                "12 Month"
        );
        cbxContractLength.setItems(contract_length);
        dgvRentalAllocation.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        localDate = LocalDate.now();
        dtpDateAllocated.setValue(localDate);
        dtpStartDate.setValue(localDate);

        col_loc_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_loc_Code.setCellValueFactory(new PropertyValueFactory<>("loc_Code"));
        col_loc_Date.setCellValueFactory(new PropertyValueFactory<>("loc_Date"));
        col_prop_Code.setCellValueFactory(new PropertyValueFactory<>("prop_Code"));
        col_TenantCode.setCellValueFactory(new PropertyValueFactory<>("tenantCode"));
        col_StartDate.setCellValueFactory(new PropertyValueFactory<>("start_Date"));
        col_cont_Length.setCellValueFactory(new PropertyValueFactory<>("contract_length"));
        col_monthlyRent.setCellValueFactory(new PropertyValueFactory<>("monthlyRent"));

        connection = new ConnectionClass().getConnection();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM RentalAllocations");
            while (rs.next()) {
                rent_List.add(
                        new Rent_Alloc(
                                //id, loc_Code, loc_Date, prop_Code, tenantCode, start_Date,contract_length, monthlyRent
                                rs.getInt("id"),
                                rs.getString("loc_Code"),
                                rs.getString("loc_Date"),
                                rs.getString("prop_Code"),
                                rs.getString("tenantCode"),
                                rs.getString("start_Date"),
                                rs.getString("contract_length"),
                                rs.getInt("monthlyRent")
                        )
                );
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        dgvRentalAllocation.setItems(rent_List);
    }

    @FXML
    void close(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void reset(ActionEvent event) {
        txtAllocationCode.setText("___-____-___");
        txtMonthlyRent.setText("0.00");
        txtTenantCode.setText("___-___");
        txtPropertyCode.setText("____-____");
        dtpStartDate.setValue(localDate);
        dtpDateAllocated.setValue(localDate);

    }

    @FXML
    void submit(ActionEvent event) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/mm/dd");
        String sql = "INSERT INTO RentalAllocations (loc_Code,loc_Date,prop_Code, tenantCode, start_Date, contract_length,monthlyRent) VALUES('"
                + txtAllocationCode.getText() + "','"
                + dtpDateAllocated.getValue().toString() + "','"
                + txtPropertyCode.getText() + "','"
                + txtTenantCode.getText() + "','"
                + dtpStartDate.getValue().toString() + "','"
                + cbxContractLength.getValue() + "',"
                + txtMonthlyRent.getText()
                +")";
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM RentalAllocations");
            rent_List.removeAll(rent_List);
            while (rs.next()) {
                rent_List.add(
                        new Rent_Alloc(
                                //id, loc_Code, loc_Date, prop_Code, tenantCode, start_Date,contract_length, monthlyRent
                                rs.getInt("id"),
                                rs.getString("loc_Code"),
                                rs.getString("loc_Date"),
                                rs.getString("prop_Code"),
                                rs.getString("tenantCode"),
                                rs.getString("start_Date"),
                                rs.getString("contract_length"),
                                rs.getInt("monthlyRent")
                        )
                );
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

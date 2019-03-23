package sample.Controller;

import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.MaskedTextField;
import sample.Model.Property;
import sample.Model.Tenant;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/*
CREATE TABLE Payments(
ReceiptNo int primary key AUTO_INCREMENT,
PaymentDate Date,
AllocationCode varchar(10),
PaymentFor varchar(25),
PaymentForAmount int,
AmountPaid double,
PropertyCode varchar(10),
PropertyType varchar(25),
MonthlyRent double,
Location varchar(100),
TenantCode varchar(7),
TenantName varchar(25),
ContactNo int
);
*/

public class NewPaymentController implements Initializable {

    private Connection connection;

    @FXML
    private TextField txtReceiptNumber;

    @FXML
    private DatePicker dtpPaymentDate;

    @FXML
    private TextField txtAmountPaid;

    @FXML
    private TextField txtTenantName;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtPropertType;

    @FXML
    private TextField txtMonthlyRent;

    @FXML
    private MaskedTextField txtAllocationCode;

    @FXML
    private MaskedTextField txtPropertyCode;

    @FXML
    private MaskedTextField txtTenantCode;

    @FXML
    void close(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connection = new ConnectionClass().getConnection();
    }

    @FXML
    public void submit(ActionEvent event) {
        if(txtTenantCode.getLength() < 6) return;//check if every textfield is filled
        if(txtTenantName.getText().isEmpty()) return;
        if(txtReceiptNumber.getText().isEmpty()) return;
        if(txtAmountPaid.getText().isEmpty()) return;
        if(txtMonthlyRent.getText().isEmpty()) return;

        String sql = "INSERT INTO Payments VALUES("
                +txtReceiptNumber.getText()+",'"
                +dtpPaymentDate.getValue().toString()+"','"
                +txtAllocationCode.getText()+"','',0,"
                +txtAmountPaid.getText()+",'"
                +txtPropertyCode.getText()+"','"
                +txtPropertType.getText()+"',"
                +txtMonthlyRent.getText()+",'"
                +txtLocation.getText()+"','"
                +txtTenantCode.getText()+"','"
                +txtTenantName.getText()+"',"
                +txtContact.getText()+""
                +")";
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

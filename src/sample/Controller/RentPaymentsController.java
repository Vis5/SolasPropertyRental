package sample.Controller;

import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Model.Payment;
import sample.Model.Tenant;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RentPaymentsController implements Initializable {

    @FXML
    private TableView<Payment> TablePayment;

    @FXML
    private TableColumn<Payment, String> ColReceiptNo;

    @FXML
    private TableColumn<Payment, String> ColPaymentDate;
    @FXML
    private TableColumn<Payment, String> ColAllocationCode;
    @FXML
    private TableColumn<Payment, String> ColAmountPaid;
    @FXML
    private TableColumn<Payment, String> ColPropertyCode;
    @FXML
    private TableColumn<Payment, String> ColPropertyType;
    @FXML
    private TableColumn<Payment, String> ColMonthlyRent;
    @FXML
    private TableColumn<Payment, String> ColLocation;
    @FXML
    private TableColumn<Payment, String> ColTenantCode;
    @FXML
    private TableColumn<Payment, String> ColTenantName;
    @FXML
    private TableColumn<Payment, String> ColContactNo;

    private ObservableList<Payment> payment_List = FXCollections.observableArrayList();
    Connection connection;

    @FXML
    void close(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void newPayment(ActionEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../Views/newPayment.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Solas Property Rental - New Payment");
            stage.setScene(new Scene(root, 700, 320));
            stage.show();
            stage.setOnHidden(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    System.out.println("Hidd");
                    updateTable();

                }
            });
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColReceiptNo.setCellValueFactory(new PropertyValueFactory<>("ReceiptNo"));
        ColPaymentDate.setCellValueFactory(new PropertyValueFactory<>("PaymentDate"));
        ColAllocationCode.setCellValueFactory(new PropertyValueFactory<>("AllocationCode"));
        ColAmountPaid.setCellValueFactory(new PropertyValueFactory<>("AmountPaid"));
        ColPropertyCode.setCellValueFactory(new PropertyValueFactory<>("PropertyCode"));
        ColPropertyType.setCellValueFactory(new PropertyValueFactory<>("PropertyType"));
        ColMonthlyRent.setCellValueFactory(new PropertyValueFactory<>("MonthlyRent"));
        ColLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
        ColTenantCode.setCellValueFactory(new PropertyValueFactory<>("TenantCode"));
        ColTenantName.setCellValueFactory(new PropertyValueFactory<>("TenantName"));
        ColContactNo.setCellValueFactory(new PropertyValueFactory<>("ContactNo"));
        connection = new ConnectionClass().getConnection();
        updateTable();
        TablePayment.setItems(payment_List);
    }

    public void updateTable(){
        payment_List.removeAll(payment_List);
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM Payments");

            while(rs.next()){
                payment_List.add(new Payment(rs.getInt("ReceiptNo"),
                        rs.getString("PaymentDate"),
                        rs.getString("AllocationCode"),
                        rs.getDouble("AmountPaid"),
                        rs.getString("PropertyCode"),
                        rs.getString("PropertyType"),
                        rs.getDouble("MonthlyRent"),
                        rs.getString("Location"),
                        rs.getString("TenantCode"),
                        rs.getString("TenantName"),
                        rs.getInt("ContactNo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

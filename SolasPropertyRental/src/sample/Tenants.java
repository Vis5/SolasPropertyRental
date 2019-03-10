package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Tenants {

    @FXML
    private TableView<?> dgvTenants;

    @FXML
    private TextField txtTenantCode;

    @FXML
    private TextField txtTenantName;

    @FXML
    private ComboBox<?> cbxMaritalStatus;

    @FXML
    private TextField txtContactNumber;

    @FXML
    private Button Reset;

    @FXML
    private Button Submit;

    @FXML
    private Button Close;

}

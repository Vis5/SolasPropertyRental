package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RentalAllocations {

    @FXML
    private TableView<?> dgvRentalAllocation;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSubmit;

    @FXML
    private ComboBox<?> cbxContractLength;

    @FXML
    private TextField txtMonthlyRent;

    @FXML
    private DatePicker dtpDateAllocated;

    @FXML
    private DatePicker dtpStartDate;

    @FXML
    private TextField txtAllocationCode;

    @FXML
    private TextField txtTenantCode;

    @FXML
    private TextField txtPropertyCode;

    @FXML
    private Button btnClose;

}

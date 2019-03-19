package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RentPaymentsController {

    @FXML
    void close(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void newPayment(ActionEvent event) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("newPayment.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Solas Property Rental - New Payment");
            stage.setScene(new Scene(root, 700, 320));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

public class propertyEditorController {

    @FXML
    void close(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}

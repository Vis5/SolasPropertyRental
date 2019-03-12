package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private ObservableList<Property> propertyData = FXCollections.observableArrayList();

    public Main() {
        propertyData.add(new Property("Apartment", "Silver Spring", 1.0, 1.0, "Available", 925.0));
    }

    public ObservableList<Property> getPropertyData() {
        return propertyData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("rentalProperties.fxml"));

        rentalPropertiesController controller = loader.getController();

        Parent root = loader.load();
        controller.setMain(this);

        primaryStage.setTitle("Solas Property Rental: Rental Properties");
        primaryStage.setScene(new Scene(root, 700, 675));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

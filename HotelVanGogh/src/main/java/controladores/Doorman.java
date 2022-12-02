package controladores;

import connection.Network;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Doorman extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Resident.class.getResource("doormanUI.fxml"));
        fxmlLoader.setController(new DoormanController());
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static class AdmDenControl implements Initializable {

        @FXML
        private TextArea messageTA;

        @FXML
        void admBtn(ActionEvent event) {

        }

        @FXML
        void denBtn(ActionEvent event) {

        }
        private Network net;

        public AdmDenControl(Network net){
         this.net=net;
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

            messageTA.setText(net.message);
        }
    }
}
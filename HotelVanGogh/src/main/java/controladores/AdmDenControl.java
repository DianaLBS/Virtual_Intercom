package controladores;

import connection.Client;
import connection.Network;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;


    public class AdmDenControl implements Initializable {

        @FXML
        private TextArea messageTA;

        @FXML
        void admBtn(ActionEvent event) {
            Client cliente = new Client();
            cliente.startConnect("127.0.0.1","1","",3);
        }

        @FXML
        void denBtn(ActionEvent event) {
            Client cliente = new Client();
            cliente.startConnect("127.0.0.1","1","",-3);
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


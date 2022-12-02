package controladores;

import connection.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
public class DoormanController {

    private String ipServer="";

    private String numApt="";

    private String namePerson="";
    @FXML
    private TextField nameVisitorTF;

    @FXML
    private Button NotificateBtn;

    @FXML
    private RadioButton nApt1Btn;

    @FXML
    private RadioButton nApt2Btn;

    @FXML
    private Button noPassBtn;

    @FXML
    private Button passBtn;

    @FXML
    private TextField IPaddressDTF;

    @FXML
    private Button playIPD;

    @FXML
    private TextArea MessageDTF;

    @FXML
    private TextArea EmergencyTF;

    @FXML
    void notificateAction(ActionEvent event) {
        namePerson=nameVisitorTF.getText();
        if(numApt.equals("1")) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        while (true) {
                            Client client = new Client();
                            client.startConnect(ipServer, numApt, namePerson, 1);
                            Thread.sleep(100000);
                        }

                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start();
        }else if(numApt.equals("2")){
            new Thread(new Runnable() {
                public void run() {
                    try {
                        while (true) {
                            Client client = new Client();
                            client.startConnect(ipServer, numApt, namePerson, 2);
                            Thread.sleep(20000);
                        }

                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    @FXML
    void playAction(ActionEvent event) {
        ipServer=IPaddressDTF.getText();
    }

    @FXML
    void onAction1(ActionEvent event) {
        numApt = "1";
    }

    @FXML
    void onAction2(ActionEvent event) {
        numApt = "2";
    }
    public DoormanController() {
    }

}


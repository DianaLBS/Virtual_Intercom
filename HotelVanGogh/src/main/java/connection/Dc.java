package connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Dc {

    private String ipServer="";

    private String numApt="";

    private String namePerson="";
    @FXML
    private TextArea EmergencyTF;

    @FXML
    private Button playIPD;
    @FXML
    private TextField IPaddressDTF;
    @FXML
    private TextArea MessageDTF;

    @FXML
    private Button NotificateBtn;

    @FXML
    private Button emergency1Btn;

    @FXML
    private Button emergency2Btn;

    @FXML
    private RadioButton nApt1Btn;

    @FXML
    private RadioButton nApt2Btn;

    @FXML
    private TextField nameVisitorTF;

    @FXML
    private Button noPassBtn;

    @FXML
    private Button passBtn;

    @FXML
    void Notificate(ActionEvent event) {

        new Thread(new Runnable() {
            public void run() {
                try {
                    while(true){
                        namePerson=nameVisitorTF.getText();
                        Client client = new Client();
                        client.startConnect(ipServer,numApt,namePerson,1);
                        Thread.sleep(100000);
                    }

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();

    }
    @FXML
    void ipAddress(ActionEvent event) {
        ipServer=IPaddressDTF.getText();

    }

    @FXML
    void onNum1(ActionEvent event) {
         numApt = "1";
         System.out.println(numApt);
    }

    @FXML
    void onNum2(ActionEvent event) {
         numApt = "2";
        System.out.println(numApt);
    }

}

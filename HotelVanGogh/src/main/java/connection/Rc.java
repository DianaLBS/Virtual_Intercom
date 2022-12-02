package connection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Rc {


    private String ipResident="";
    @FXML
    private TextField IPaddressTF;

    @FXML
    private TextField MessageTF;

    @FXML
    private Button alert;

    @FXML
    private TextArea chatScreen;

    @FXML
    private Button initChat;

    @FXML
    private Button playIP;

    @FXML
    private Button sendMessage;

    @FXML
    void sendM(ActionEvent event) {


       /* new Thread(()->{
            while(true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("si");
                Client cliente = new Client();
                cliente.startConnect(ipResident,"1",MessageTF.getText(),4);


            }
        }).start();
*/
    }
    @FXML
    void playIPBtn(ActionEvent event) {
        ipResident= IPaddressTF.getText();

        new Thread(()->{
            while(true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("si");
                Client cliente = new Client();
                cliente.startConnect(ipResident,"1","",-1);

            }
        }).start();

       //Thread t = new Thread(new Thr(ipResident,"connecting",-1));
        //t.start();
    }


}



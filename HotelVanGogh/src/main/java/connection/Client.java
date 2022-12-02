package connection;

import controladores.Doorman;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    private String m1="";
    private String m2="";

    public void startConnect(String ip,String numApt,String name,int id){

        try{
            Socket sc = new Socket(ip,5100);
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
            String message = "Usuario del"+numApt+" lo espera "+name;
            Network con = new Network(ip,message,id);
            out.writeObject(con);


            ObjectInputStream in = new ObjectInputStream(sc.getInputStream());

            try {
                Network net = (Network) in.readObject();
                if(net.id == -1 || net.id==-2){

                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            try {
                                chargeNewWindow(net);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }
                if(net.id==3){
                    System.out.println(net.message);
                }else if(net.id==-3){
                    System.out.println(net.message);
                }
                if(net.id==4){
                    System.out.println(net.message);
                }
                if(net.id==5){
                    m2 = net.message;
                    System.out.println(net.message);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void chargeNewWindow(Network net) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Server.class.getResource("admDen.fxml"));
        fxmlLoader.setController(new Doorman.AdmDenControl(net));
        Parent parent = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}

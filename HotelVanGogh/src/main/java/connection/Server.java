package connection;

import javafx.beans.Observable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;


//server
public class Server {


    public String answer="";
    public String messageA="";
    public String m1 = "";
    public String m2= "";

    //iniciar server
    public static void main(String[] args) {

        Server obj =new Server();
        obj.initserver();
    }

    public void initserver(){

        boolean request1 =false;
        boolean request2 = false;
        boolean request3 = false;
        try {
            //escucha de solicitudes
            ServerSocket server = new ServerSocket(5100);
            Socket sc;


            while (true) {

                sc = server.accept();
                //System.out.println(request1);



                //lectura de cliente
            ObjectInputStream in = new ObjectInputStream(sc.getInputStream());
                try {
                    Network net = (Network) in.readObject();

                    //switch de respuesta
                    if(net.id==1) {
                        Network nets = new Network("","connecting",1);
                        ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
                        os.writeObject(nets);
                        request1=true;
                        messageA = net.message;
                    }
                    if(net.id==2) {
                        Network nets = new Network("","connecting",1);
                        ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
                        os.writeObject(nets);
                        request2=true;
                        messageA = net.message;
                    }
                    if(net.id==3) {
                        Network nets = new Network("","connecting",3);
                        ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
                        os.writeObject(nets);
                        request3=true;

                    }
                    if(net.id==-3){
                        Network nets = new Network("","connecting",-3);
                        ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
                        os.writeObject(nets);
                        request3=false;
                    }
                    if(net.id==1&&request3){
                        Network nets = new Network("","Puede pasar",3);
                        ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
                        os.writeObject(nets);
                    }
                    if(net.id==1&&request3==false){
                        Network nets = new Network("","No Puede pasar",3);
                        ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
                        os.writeObject(nets);
                    }
                    if(net.id==-1&& request1 ==false) {
                        Network nets = new Network("","connecting",1);
                        ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
                        os.writeObject(nets);
                    }else if(net.id==-1&&request1){
                        Network nets = new Network("",messageA,-1);
                        ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
                        os.writeObject(nets);
                    }
                    if(net.id==-2&& request2 ==false) {
                        Network nets = new Network("","connecting",1);
                        ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
                        os.writeObject(nets);
                    }else if(net.id==-2&&request2){
                        Network nets = new Network("",messageA,-2);
                        ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
                        os.writeObject(nets);
                    }
                    if(net.id==4){
                        m1 = net.message;
                        Network nets = new Network("",m2,4);
                        ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
                        os.writeObject(nets);

                    }


                    if(net.id==5){
                        m2 = net.message;
                        Network nets = new Network("",m1,5);
                        ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
                        os.writeObject(nets);
                    }


                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                /*   if(ipT!=null&&ipT.equals("/127.0.0.1")){
                    System.out.println("enter "+sc.getInetAddress());
                    ObjectOutputStream os=new ObjectOutputStream(sc.getOutputStream());
                    //Conexion leader =new Conexion(false);
                    //os.writeObject(leader);
                }*/



            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

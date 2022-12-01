package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {


    public static void main(String[] args) {

        String invitado="";
        boolean solicitud1=false;
        try {
            ServerSocket server = new ServerSocket(5100);
            Socket sc;

            sc = server.accept();

            ObjectInputStream in = new ObjectInputStream(sc.getInputStream());
            try {
                Conexion con = (Conexion) in.readObject();
                System.out.println(con.flag);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            while(true){

                // Espero la conexion del cliente
                sc = server.accept();

                String ipT=String.valueOf(sc.getInetAddress());

                if(ipT!=null&&ipT.equals("/127.0.0.1")){
                    System.out.println("enter "+sc.getInetAddress());
                    ObjectOutputStream os=new ObjectOutputStream(sc.getOutputStream());
                    //Conexion leader =new Conexion(false);
                    //os.writeObject(leader);
                }


            }

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }


    }


}

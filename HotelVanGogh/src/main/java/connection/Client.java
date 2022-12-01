package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public void startConnect(String ip,String numApt,String name,int id){

        try{
            Socket sc = new Socket(ip,5100);
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
            Conexion con = new Conexion(true);
            out.writeObject(con);

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

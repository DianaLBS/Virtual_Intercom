package connection;

import java.io.Serializable;

public class Network implements Serializable {

    public String ip;
    public String message;
    public int id;
    public Network(String ip,String message,int id){
        this.ip=ip;
        this.message=message;
        this.id=id;
    }
}

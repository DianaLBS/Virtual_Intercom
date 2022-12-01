package connection;

import java.io.Serializable;

public class Conexion implements Serializable {

    public boolean flag;
    public Conexion(boolean flag){
        this.flag=flag;
    }
}

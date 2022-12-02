package connection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class SCon {
    @FXML
    private TextArea serverRunningTA;

    @FXML
    void acept(ActionEvent event) {

        Client cliente = new Client();
        cliente.startConnect("127.0.0.1","1","",3);
    }
}

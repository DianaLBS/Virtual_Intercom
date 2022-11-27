package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class menuDoormanControl implements Initializable {
	

    public menuDoormanControl(String ip, String port) {
		// TODO Auto-generated constructor stub
	}

    @FXML
    private Label titleLabel;

    @FXML
    private TextField nameVisitorTF;

    @FXML
    private ComboBox<String> numAPTcombobx;

    @FXML
    private Button notifyResidentBTN;

    @FXML
    private Label labelNumMessages;

    @FXML
    private ListView<?> messagesListView;

    @FXML
    private ImageView imageSirena;

    @FXML
    private ListView<?> emergenciesListView;

	@FXML
    void notifyResident(ActionEvent event) {

    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Label t = new Label("Virtual Intercom");
		titleLabel.setLabelFor(t);
		numAPTcombobx.getItems().removeAll(numAPTcombobx.getItems());
		numAPTcombobx.getItems().addAll("1","2");
		numAPTcombobx.getSelectionModel().select("1");
		
	}

}

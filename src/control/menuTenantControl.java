package control;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class menuTenantControl {

	public menuTenantControl(String ip, String port, String numApt) {
		
	}


	 @FXML
	    private TextArea ChatView_TA;

	    @FXML
	    private TextField message_TF;

	    @FXML
	    private Button send_Button;

	    @FXML
	    private ComboBox<String> cb_selectUser;

	    @FXML
	    private ImageView imageSirena;

	    @FXML
	    private Button panic_Button;

	    @FXML
	    private Label titleLabel;
	    
	    @FXML
	    void pressPanicButton(ActionEvent event) {
	    }

	    @FXML
	    void selectOptionResident(ActionEvent event) {

	    }

	    @FXML
	    void sendMessage(ActionEvent event) {

	    }

	    @FXML
	    void writterMessage(ActionEvent event) {

	    }
	    
	    public void initialize(URL location, ResourceBundle resources) {
	    	cb_selectUser.getItems().removeAll(cb_selectUser.getItems());
	    	cb_selectUser.getItems().add("other");
	    	cb_selectUser.getSelectionModel().select("Other");
	    	
	    	ImagesIcons();
	    	
			
		}
	    
	    private void ImagesIcons() {
	    	URL buttonSend = getClass().getResource("//images/EnviarIcon.png");
	    	URL buttonPanic = getClass().getResource("/images/panic1.png");
	    	
	    	Image imagenSend = new Image(buttonSend.toString(),46,46,false,true);
	    	Image imagenPanic = new Image(buttonPanic.toString(),46,46,false,true);
	    	
	    	send_Button.setGraphic(new ImageView(imagenSend));
	    	panic_Button.setGraphic(new ImageView(imagenSend));
	    }
	    

}

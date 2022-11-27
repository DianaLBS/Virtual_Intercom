package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.Main;

public class LoginAsDoormanControl implements Initializable {

    @FXML
    private Label titleLabel;

    @FXML
    private TextField ipAddressTF;

    @FXML
    private TextField portTF;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Label t = new Label("Virtual Intercom");
		titleLabel.setLabelFor(t);
	}
	
    @FXML
    void continueBTN(ActionEvent event) throws IOException {
	   if(ipAddressTF.getText().equals("") || portTF.getText().equals("")) {
	  	  Alert alert = new Alert(Alert.AlertType.ERROR);
	      alert.setHeaderText(null);
	      alert.setTitle("ERROR");
	      alert.setContentText("Complete all fields to continue");
	      alert.showAndWait();
	    }else {
	  	  String ip = ipAddressTF.getText();
	  	  String port=portTF.getText();
	  	 FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/MenuDoormanWindow.fxml"));
		 loader.setController(new menuDoormanControl(ip,port));
		 Parent parent = (Parent) loader.load();
		 Stage stage = new Stage();
		 Scene scene = new Scene(parent);
		 stage.getIcons().add(new Image(Main.class.getResourceAsStream("../images/T5.png")));
		stage.setTitle("Virtual Intercom");
		 stage.setScene(scene);
		 stage.show();
		 Stage stage2 = (Stage) titleLabel.getScene().getWindow();
		 stage2.close();
	    }
    }

}

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.Main;

public class ChooseLoginControl implements Initializable{
	

    @FXML
    private Label titleLabel;

    @FXML
    private Button btnD;

    @FXML
    private Button btnT;

    @FXML
    void LoginAsDoorman(ActionEvent event) throws IOException {
    	openNewWindow("../ui/LoginAsDoormanWindow.fxml");
    }

    @FXML
    void loginAsTenant(ActionEvent event) throws IOException {
    	openNewWindow("../ui/LoginAsTenantWindow.fxml");
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		Label t = new Label("Virtual Intercom");
		titleLabel.setLabelFor(t);
	}
	
	public void openNewWindow(String address) throws IOException {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource(address));
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


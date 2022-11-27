package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
		
	}
	@Override
	public void start(Stage primaryStage)  {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ChooseLoginWindow.fxml"));
		Parent parent;
		try {
			parent = (Parent) loader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.getIcons().add(new Image(Main.class.getResourceAsStream("../images/T5.png")));
			stage.setTitle("Virtual Intercom");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

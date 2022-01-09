package ihm;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FXMLdemo extends Application {


	public void start(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		URL fxmlFileUrl = getClass().getResource("Menu_Principal.fxml");
		if (fxmlFileUrl == null) {
			System.out.println("Impossible de charger le fichier fxml");
			System.exit(-1);
			
		}
		loader.setLocation(fxmlFileUrl);
		
		Parent root = loader.load();
		
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.getIcons().add(new Image("ihm/ColorWheel.png"));
		stage.setTitle("Choix des couleurs");
		stage.setResizable(false);
		stage.show();
		System.out.println("java version: "+System.getProperty("java.version"));
		System.out.println("javafx.version: " + System.getProperty("javafx.version"));
	}




	public static void main(String[] args) {
		Application.launch(args);
	}

}

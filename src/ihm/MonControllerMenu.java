package ihm;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MonControllerMenu {
	    @FXML
	    Button continuer;
	    @FXML
	    Button exit;

        public void initialize() {
        	System.out.println("Initialisation...");
        }
        

        //ferme la fenetre du menu
        public void pressedExitButton(ActionEvent event) {
            Stage stage = (Stage) exit.getScene().getWindow();
            stage.close();
        }
        
        //ouvre la fenetre principale du choix des couleurs
        public void pressedContinuerButton(ActionEvent event) throws IOException {
        	Stage stage = (Stage) continuer.getScene().getWindow();
			stage.close();
			
			FXMLLoader loader = new FXMLLoader();
			URL fxmlFileUrl = getClass().getResource("IHMdeFOUmalade.fxml");
			if (fxmlFileUrl == null) {
				System.out.println("Impossible de charger le fichier fxml");
				System.exit(-1);
				
			}
			loader.setLocation(fxmlFileUrl);
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Choix des couleurs");
			stage.setResizable(false);
			stage.show();
        }
        
        

        
        
        
        

}

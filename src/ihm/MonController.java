package ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class MonController {
		@FXML
		VBox partGauche;
		@FXML
		Button ajoutCouleur;
		@FXML
		Button suppCouleur;
        @FXML
        ColorPicker colorPicker;
        @FXML
        Button exit;
        
        public static LigneChoix ligneSelect;

        public void initialize() {
        	System.out.println("Initialisation...");
        	addColor();
        }
        
        //ajoute une ligne de choix de couleur
        public void addColor() {
        	if(LigneChoix.cpt<=10) {
        		LigneChoix lc=new LigneChoix(LigneChoix.cpt);
        		LigneChoix.tabLignes.add(lc);
        		LigneChoix.cpt++;
        		
	        	partGauche.getChildren().add(lc.getAll());

	        	for (LigneChoix ligneChoix : LigneChoix.tabLignes) {
	        		if(!(ligneChoix.equals(ligneSelect))) {
	        			ligneChoix.rB.setSelected(false);
	        		}
						
				}
        	}

        }
        
      //supprime ligne de choix de couleur
        public void removeColor() {
        	if(!(LigneChoix.tabLignes.isEmpty())){
        		if(ligneSelect==null) {
            		MonController.ligneSelect=LigneChoix.tabLignes.get(LigneChoix.tabLignes.size()-1);
            	} 	
    	        	partGauche.getChildren().remove(ligneSelect.getAll());
    	    		LigneChoix.tabLignes.remove(MonController.ligneSelect);
    	    		

    	    		LigneChoix.cpt--;
    	    		LigneChoix.reindex();
    	    		
    	    		MonController.ligneSelect=null;
    	    	
        	}
        	
        	
        }
        
        //affecte le choix du colorPicker a la ligne selecionnee
        public void chooseColor() {
        	if(ligneSelect!=null) {
            	Color c =colorPicker.getValue();
            	
            	String hex="#"+c.toString().substring(2,8);
            	ligneSelect.tF.setText(hex);
            	
            	ligneSelect.rC.setFill(Paint.valueOf(hex));
            		
            	int gris=LigneChoix.getNivGris(c);
            	ligneSelect.rG.setFill(Color.rgb(gris,gris,gris));
            	
        	}
        }
        
        //ferme la fenetre
        public void exitMenu() {
            Stage stage = (Stage) exit.getScene().getWindow();
            stage.close();
        }
        

        
        
        
        

}

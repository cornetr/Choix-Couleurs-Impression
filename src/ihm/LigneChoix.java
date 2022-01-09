package ihm;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class LigneChoix extends Region {
	public RadioButton rB;
	public Label lb;
	public Rectangle rC;
	public Rectangle rG;
	public TextField tF;
	
	static int cpt=1;
	
	//tableau contenant toutes les lignes de couleur
    public static ArrayList<LigneChoix> tabLignes=new ArrayList<LigneChoix>();
	
    //Constructeur qui s'occupe des elements necessaires a la creation d'une ligne de couleur
	public LigneChoix(int cpt) {
		this.rB=new RadioButton();
		this.rB.setPadding(new Insets(0,0,15,15));
		this.rB.setCursor(Cursor.HAND);
		
		this.rB.addEventHandler(ActionEvent.ACTION, event -> {
			if(this.rB.isSelected()) { 
				MonController.ligneSelect=this;

				for (LigneChoix ligneChoix : tabLignes) {
					if(!(this.rB.equals(ligneChoix.rB))) {
						ligneChoix.rB.setSelected(false);
					}					
				}
			}	
		});
		
		this.lb=new Label(""+cpt);
		this.lb.setMinSize(15, 20);
		
		this.rC=new Rectangle(80,25);
		this.rC.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-type: inside; -fx-stroke-width: 1; -fx-arc-height: 5;-fx-arc-width: 5");
		this.rG=new Rectangle(80,25);
		this.rG.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-type: inside; -fx-stroke-width: 1; -fx-arc-height: 5;-fx-arc-width: 5");
		
		this.tF=new TextField();
		this.tF.setMaxSize(80,25);
		this.tF.textProperty().addListener((observable, oldValue, newValue) -> {
		    try {
		    	Color c=(Color) Paint.valueOf(newValue);
		    	int gris=LigneChoix.getNivGris(c);
		    	
		    	this.rC.setFill(c);
		    	this.rG.setFill(Color.rgb(gris,gris,gris));
		    	
		    	this.tF.setStyle("-fx-text-inner-color: black;");
		    }catch (IllegalArgumentException e) {
				this.tF.setStyle("-fx-text-inner-color: red;");
			}
		});   

	}
	
	//recupere tous les elements sous la forme d'une HBox
	public HBox getAll() {
		HBox hB =new HBox();
    	hB.getChildren().addAll(rB,lb,rC,rG,tF);
    	hB.setSpacing(10);
    	return hB;
	}
	
	//reindex le numero de chaque ligne, utile lors de la supression d'une ligne
	public static void reindex() {
		int idx;
		int idxSuivant;
		
		if(Integer.parseInt(MonController.ligneSelect.lb.getText())==1) {
			int i=0;
			for (LigneChoix ligneChoix : tabLignes) {
				ligneChoix.lb.setText(""+(i+1));
				i++;
			}
		}else for(int cpt2=0;cpt2<tabLignes.size()-1;cpt2++) {
			
			idx = Integer.parseInt(tabLignes.get(cpt2).lb.getText());
			idxSuivant = Integer.parseInt(tabLignes.get(cpt2+1).lb.getText());
			
			if(idxSuivant!=(idx+1)) {
				tabLignes.get(cpt2+1).lb.setText(""+(cpt2+2 ));
			}
		}
	}
	
	//retourne le niveau de gris d'une couleur donnee
	public static int getNivGris(Color c) {
		int red=(int)(c.getRed()*255);
    	int green=(int)(c.getGreen()*255);
    	int blue=(int)(c.getBlue()*255);
    	
    	
    	int niveauGris=(int)(red*0.3+green*0.59+blue*0.11);
    	return niveauGris;
	}
	
	
}

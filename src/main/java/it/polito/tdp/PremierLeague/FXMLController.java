/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.PremierLeague;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.PremierLeague.model.CoppiaMatch;
import it.polito.tdp.PremierLeague.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCreaGrafo"
    private Button btnCreaGrafo; // Value injected by FXMLLoader

    @FXML // fx:id="btnConnessioneMassima"
    private Button btnConnessioneMassima; // Value injected by FXMLLoader

    @FXML // fx:id="btnCollegamento"
    private Button btnCollegamento; // Value injected by FXMLLoader

    @FXML // fx:id="txtMinuti"
    private TextField txtMinuti; // Value injected by FXMLLoader

    @FXML // fx:id="cmbMese"
    private ComboBox<Integer> cmbMese; // Value injected by FXMLLoader

    @FXML // fx:id="cmbM1"
    private ComboBox<?> cmbM1; // Value injected by FXMLLoader

    @FXML // fx:id="cmbM2"
    private ComboBox<?> cmbM2; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doConnessioneMassima(ActionEvent event) {
    	
    	this.txtResult.clear();
    	
       int min;
    	
    	try {
    		min=Integer.parseInt(this.txtMinuti.getText());
    	}catch(NumberFormatException nfe) {
    		this.txtResult.appendText("Errore: inserire un numero!!");
    		return;
    	}
    	
    	int mese;
    	try {
    	mese=this.cmbMese.getValue();
    	}catch(NullPointerException npe) {
    		this.txtResult.setText("Errore: scegliere un mese dal menu!!");
    		return;
    	}
    	
    	model.creaGrafo(mese, min);
    	
    	this.txtResult.appendText("Coppie con connessione massima: \n");
    	
    	for(CoppiaMatch cm : this.model.getMigliore(mese, min)) {
    	     this.txtResult.appendText(cm.getM1()+"-"+cm.getM2()+"\n");
    	}
    }

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	
    	int min;
    	
    	try {
    		min=Integer.parseInt(this.txtMinuti.getText());
    	}catch(NumberFormatException nfe) {
    		this.txtResult.appendText("Errore: inserire un numero!!");
    		return;
    	}
    	
    	int mese;
    	try {
    	mese=this.cmbMese.getValue();
    	}catch(NullPointerException npe) {
    		this.txtResult.setText("Errore: scegliere un mese dal menu!!");
    		return;
    	}
    	
    	model.creaGrafo(mese, min);
    	
    	this.txtResult.appendText("GRAFO CREATO!! \n");
    	this.txtResult.appendText("Numero di vertici: "+model.getNumeroVertici()+"\n");  
    	this.txtResult.appendText("Numero di archi: "+model.getNumeroArchi());  
    	
    }

    @FXML
    void doCollegamento(ActionEvent event) {
    	
    	
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnConnessioneMassima != null : "fx:id=\"btnConnessioneMassima\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCollegamento != null : "fx:id=\"btnCollegamento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMinuti != null : "fx:id=\"txtMinuti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbMese != null : "fx:id=\"cmbMese\" was not injected: check your FXML file 'Scene.fxml'.";        assert cmbM1 != null : "fx:id=\"cmbM1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbM2 != null : "fx:id=\"cmbM2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
        this.cmbMese.getItems().addAll(model.getMesi());
    }
    
    
}

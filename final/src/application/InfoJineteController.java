package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class InfoJineteController {
	

	    @FXML
	    private TextField txtNombre;

	    @FXML
	    private TextField txtEdad;

	    @FXML
	    private TextField txtPeso;

	    @FXML
	    private TextField txtNumero;

	    @FXML
	    private TextField txtCarrerasGandas;

	    @FXML
	    private TextField txtAltura;

	    

	   

	
	
	
	public InfoJineteController() {
		
	}
	public void inititialize() {
		
	}
	
public void openCuponDeApuestas(ActionEvent event) throws Exception {
		

		try {
			Parent showBegginer = FXMLLoader.load(getClass().getResource("CuponDeApuestas.fxml"));
			Scene sceneBegginer = new Scene(showBegginer);
			Stage windowBegginer = (Stage)((Node) event.getSource()).getScene().getWindow();
			windowBegginer.setScene(sceneBegginer);
			windowBegginer.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

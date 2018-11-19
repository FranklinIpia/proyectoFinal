package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InfoCaballoController {
	
	

	    @FXML
	    private TextField txtNombre;

	    @FXML
	    private TextField txtNumero;

	    @FXML
	    private TextField txtEdad;

	    @FXML
	    private TextField txtPeso;

	    @FXML
	    private TextField txtCarrerasGanadas;

	    @FXML
	    private TextField txtCarrerasPerdidas;

	    @FXML
	    private TextField txtAltura;

	    @FXML
	    private TextField txtGenero;

	    @FXML
	    private TextField txtVelocidadMaxima;

	  
	  

	
	
	
	public InfoCaballoController() {
		
	}
	
	public void initialize() {
		
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

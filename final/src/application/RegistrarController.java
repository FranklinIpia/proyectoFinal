package application;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class RegistrarController {
	@FXML
	private TextField texNombre;
	@FXML
	private TextField texApellido;
	@FXML
	private TextField texCedula;
	@FXML
	private TextField texEdad;
	@FXML
	private TextField texEmail;
	@FXML
	private TextField texConfirmarEmail;
	@FXML
	private TextField texContrasena;
	@FXML
	private TextField texConfirmarContrasena;
	@FXML
	private Button btHombre;
	@FXML
	private Button btMujer;
	@FXML
	private Button btVolver;
	@FXML
	private Button btRegistrarse;
	
	public RegistrarController() {
		
	}
	public void initialize() {
		
	}
	

	
	
	public void openMenu(ActionEvent event) throws Exception {
		try {
			Parent showBegginer = FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene sceneBegginer = new Scene(showBegginer);
			Stage windowBegginer = (Stage)((Node) event.getSource()).getScene().getWindow();
			windowBegginer.setScene(sceneBegginer);
			windowBegginer.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}

package application;
//X#3
	
import javafx.application.Application;
import javafx.stage.Stage;
import modelo.Administrador;
import modelo.SimuladorApuesta;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static SimuladorApuesta simulador= new SimuladorApuesta();
	@FXML
private Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stage=primaryStage;
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene scene = new Scene(root,653,496);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public SimuladorApuesta darSimulador() {
		return simulador;
	}
	
	
	public Stage darEstage() {
		return stage;
	}
	
	public static void main(String[] args) {
		
		launch(args);
		Administrador admin= new Administrador("final", "final", "final", "final", 20, 1);

//		Administrador admin= new Administrador("proyecto", "final", "final", "12345", 21, Administrador.MASCULINO);
		simulador.setAdmin(admin);
	}
}

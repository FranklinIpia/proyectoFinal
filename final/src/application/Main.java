package application;
//jajajajajajajjax2x3X4X5X10
	
import javafx.application.Application;
import javafx.stage.Stage;
import modelo.SimuladorApuesta;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static SimuladorApuesta simulador= new SimuladorApuesta();
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene scene = new Scene(root,310,393);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public SimuladorApuesta darSimulador() {
		return simulador;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

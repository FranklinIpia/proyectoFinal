package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Caballo;
import modelo.Jinete;

public class CuponDeApuestasController {

	private Main main;
	@FXML
	private TextField txtUsuario;
	//Estos texfield hacen referencia a los numeros de los caballos 
	@FXML
	private TextField txtNumero1;
	@FXML
	private TextField txtNumero2;
	@FXML
	private TextField txtNumero3;
	@FXML
	private TextField txtNumero4;
//Estos texfield hacen referenica al nombre del jinete junto con el caballo
	@FXML
	private TextField txtNombreJineteCaballo1;
	@FXML
	private TextField txtNombreJineteCaballo2;
	@FXML
	private TextField txtNombreJineteCaballo3;
	@FXML
	private TextField txtNombreJineteCaballo4;
	
	//Botones que hacen referencia a los botones organizados en forma como se ve en la interfaz
	@FXML
	private Button btnGanador1;
	@FXML
	private Button btnGanador2;
	@FXML
	private Button btnGanador3;
	@FXML
	private Button btnGanador4;

	@FXML
	private ImageView img1;
	
	MenuController menu;
	
	public CuponDeApuestasController() {
		main= new Main();
//		menu=new MenuController();
	txtUsuario= new TextField();
		txtNombreJineteCaballo1= new TextField();
		txtNombreJineteCaballo2=new TextField();
		txtNombreJineteCaballo3= new TextField();
		txtNombreJineteCaballo4=new TextField();
		txtNumero1= new TextField();
		txtNumero2=new TextField();
		txtNumero3=new TextField();
		txtNumero4=new TextField();
		btnGanador1=new Button("1.5");
		btnGanador2=new Button();
		btnGanador3= new Button();
		btnGanador4= new Button();
		cargarJinetes();
	cargarCaballos() ;
	
	}
	
	public void initialize() {
//		txtUsuario.setText(cedula);
		 mostrarEnInterfaz();
		 btnGanador1.setText("1.5");
		 btnGanador2.setText("1.6");
		 btnGanador3.setText("2.1");
		 btnGanador4.setText("1.0");
	}
	
	
	
	
	
	
	
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public TextField getTxtNumero1() {
		return txtNumero1;
	}

	public void setTxtNumero1(TextField txtNumero1) {
		this.txtNumero1 = txtNumero1;
	}

	public TextField getTxtNumero2() {
		return txtNumero2;
	}

	public void setTxtNumero2(TextField txtNumero2) {
		this.txtNumero2 = txtNumero2;
	}

	public TextField getTxtNumero3() {
		return txtNumero3;
	}

	public void setTxtNumero3(TextField txtNumero3) {
		this.txtNumero3 = txtNumero3;
	}

	public TextField getTxtNumero4() {
		return txtNumero4;
	}

	public void setTxtNumero4(TextField txtNumero4) {
		this.txtNumero4 = txtNumero4;
	}

	public TextField getTxtNombreJineteCaballo1() {
		return txtNombreJineteCaballo1;
	}

	public void setTxtNombreJineteCaballo1(TextField txtNombreJineteCaballo1) {
		this.txtNombreJineteCaballo1 = txtNombreJineteCaballo1;
	}

	public TextField getTxtNombreJineteCaballo2() {
		return txtNombreJineteCaballo2;
	}

	public void setTxtNombreJineteCaballo2(TextField txtNombreJineteCaballo2) {
		this.txtNombreJineteCaballo2 = txtNombreJineteCaballo2;
	}

	public TextField getTxtNombreJineteCaballo3() {
		return txtNombreJineteCaballo3;
	}

	public void setTxtNombreJineteCaballo3(TextField txtNombreJineteCaballo3) {
		this.txtNombreJineteCaballo3 = txtNombreJineteCaballo3;
	}

	public TextField getTxtNombreJineteCaballo4() {
		return txtNombreJineteCaballo4;
	}

	public void setTxtNombreJineteCaballo4(TextField txtNombreJineteCaballo4) {
		this.txtNombreJineteCaballo4 = txtNombreJineteCaballo4;
	}

	public Button getBtnGanador1() {
		return btnGanador1;
	}

	public void setBtnGanador1(Button btnGanador1) {
		this.btnGanador1 = btnGanador1;
	}

	public Button getBtnGanador2() {
		return btnGanador2;
	}

	public void setBtnGanador2(Button btnGanador2) {
		this.btnGanador2 = btnGanador2;
	}

	public Button getBtnGanador3() {
		return btnGanador3;
	}

	public void setBtnGanador3(Button btnGanador3) {
		this.btnGanador3 = btnGanador3;
	}

	public Button getBtnGanador4() {
		return btnGanador4;
	}

	public void setBtnGanador4(Button btnGanador4) {
		this.btnGanador4 = btnGanador4;
	}

	
	
	
	
public TextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(TextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

///Este metodo carga los jinetes del archivo txt
public void cargarJinetes() {
	
	File file= new File("archivos/jinetes.txt");
	try {
		FileReader fileReader= new FileReader(file);
		BufferedReader buffr= new BufferedReader(fileReader);
		String line="";
		
		while((line=buffr.readLine())!=null) {
		String[] data=line.split(";");
		String nombre=data[0];
		int edad=Integer.parseInt(data[1]);
		double altura=Double.parseDouble(data[2]);
		double peso=Double.parseDouble(data[3]);
		int numero=Integer.parseInt(data[4]);
		int carrerasGanadas=Integer.parseInt(data[5]);
		int carrerasPerdidas=Integer.parseInt(data[6]); 
		
		
		Jinete nuevoJinete= new Jinete(nombre,edad ,peso,numero, carrerasGanadas, carrerasPerdidas,altura);
		main.darSimulador().insertarJinete(nuevoJinete);
		System.out.println(nuevoJinete.getNombre());
		
			
		}
		buffr.close();
		
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("No existe el archivo");
		e.printStackTrace();
	}
		
	}
	
	
	
	
	//Este metodoc carga los caballos del archivo txt
	
	public void cargarCaballos() {
			
		File file= new File("archivos/Caballos.txt");
		try {
			FileReader fileReader= new FileReader(file);
			BufferedReader buffer= new BufferedReader(fileReader);
			String line="";
			int contador=0;
			while((line = buffer.readLine())!=null) {
				String[] data= line.split(";");
				String nombre= data[0];
				int numero= Integer.parseInt(data[1]);
				int edad= Integer.parseInt(data[2]);
				double peso= Double.parseDouble(data[3]);
				int carrerasGanadas=Integer.parseInt(data[4]);
				int carrerasPerdidas=Integer.parseInt(data[5]);
				int genero=Integer.parseInt(data[6]);
				double altura=Double.parseDouble(data[7]);
				int factorVeocilidad=Integer.parseInt(data[8]);
				
				Caballo caballo= new Caballo(img1,nombre, numero,edad, peso, carrerasGanadas, carrerasPerdidas, genero, altura, factorVeocilidad);
				System.out.println(caballo.getNumero());
				Jinete jineteEncontrado=main.darSimulador().buscarJinete(numero);
				
				if(jineteEncontrado==null) {
					System.out.println("No se enontro el jinete");
				}else {
					System.out.println("Numero del jinete encontraod" + jineteEncontrado.getNumero());
					jineteEncontrado.insertarCaballo(caballo);
				
				}
				contador++;
				System.out.println("Contador " +contador);
			}
			buffer.close();
		}catch(Exception e) {
			System.out.println(e.getMessage() );
			e.printStackTrace();
		}
		
	}
	
	
	public void mostrarEnInterfaz() {
		
	Jinete actual1= main.darSimulador().buscarJinete(468);
	Jinete actual2= main.darSimulador().buscarJinete(475);
	Jinete actual3= main.darSimulador().buscarJinete(318);
	Jinete actual4=main.darSimulador().buscarJinete(295);


			txtNumero1.setText(actual1.getPrimerCaballo().getNumero()+"");
			
			txtNombreJineteCaballo1.setText(actual1.getPrimerCaballo().getNombre() + "/" + actual1.getNombre());
	
			txtNumero2.setText(actual2.getPrimerCaballo().getNumero()+"");
		
			txtNombreJineteCaballo2.setText(actual2.getNombre() + "/" + actual2.getNombre());

			txtNumero3.setText(actual3.getPrimerCaballo().getNumero()+"");
			
			txtNombreJineteCaballo3.setText(actual3.getPrimerCaballo().getNombre() + "/" + actual3.getNombre());
	
			txtNumero4.setText(actual4.getPrimerCaballo().getNumero()+"");
		
			txtNombreJineteCaballo4.setText(actual4.getPrimerCaballo().getNombre() + "/" + actual4.getNombre());
	
	

	
	
	
}
		
	
	
	public void cargarUsuariosSerializables() {
		
	}
	
	
	public void mostrar() {
		main.darSimulador().mostrarJinetes();
	}
	
	
	//Este metodo busca un jinete dado el numero del jinete
	public void buscarJinete(int numero) {
		Jinete jinete=main.darSimulador().buscarJinete(numero);
		System.out.println("Numero del jiente encontrado"+ jinete.getNumero());
	}
	
	

	
	
	
	public void imprimirCaballos() {
		main.darSimulador().imprimirCaballos();
	}
	
	
	//abre la ventana que da la informacion del caballo ( el cual se busca por el nombre)
	   public void openBuscarCaballo(ActionEvent event) throws Exception {
			

			try {
				Parent showBegginer = FXMLLoader.load(getClass().getResource("InfoCaballo.fxml"));
				Scene sceneBegginer = new Scene(showBegginer);
				Stage windowBegginer = (Stage)((Node) event.getSource()).getScene().getWindow();
				windowBegginer.setScene(sceneBegginer);
				windowBegginer.show();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	   
	   // abre la venta que da la informacion del jinete.
	   public void openBuscarJinete(ActionEvent event) throws Exception {
			

			try {
				Parent showBegginer = FXMLLoader.load(getClass().getResource("InfoCaballo.fxml"));
				Scene sceneBegginer = new Scene(showBegginer);
				Stage windowBegginer = (Stage)((Node) event.getSource()).getScene().getWindow();
				windowBegginer.setScene(sceneBegginer);
				windowBegginer.show();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	
	
	   public void openCarrera(ActionEvent event) throws Exception {
			

				try {
					Parent showBegginer = FXMLLoader.load(getClass().getResource("Carrera.fxml"));
					Scene sceneBegginer = new Scene(showBegginer);
					Stage windowBegginer = (Stage)((Node) event.getSource()).getScene().getWindow();
					windowBegginer.setScene(sceneBegginer);
					windowBegginer.show();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
	
	public void eligioBoton(ActionEvent e) {
		////SSs
		if(btnGanador1==e.getSource()) {
			btnGanador2.setDisable(true);
			btnGanador3.setDisable(true);
			btnGanador4.setDisable(true);
			
			
		}
		
	}
	

}

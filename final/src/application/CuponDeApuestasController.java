package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Caballo;
import modelo.Jinete;

public class CuponDeApuestasController {

	private Main main;
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

	
	
	
	
	public CuponDeApuestasController() {
		main= new Main();
		cargarJinetes();
	cargarCaballos() ;
		mostrar();
		buscarJinete(318);
		imprimirCaballos();
	}
	
	public void initialize() {
		
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
				
				Caballo caballo= new Caballo(nombre, numero,edad, peso, carrerasGanadas, carrerasPerdidas, genero, altura, factorVeocilidad);
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
	
	
	public void mostrar() {
		main.darSimulador().mostrarJinetes();
	}
	
	
	//Este metodo busca un jinete dado el numero del jinete
	public void buscarJinete(int numero) {
		Jinete jinete=main.darSimulador().buscarJinete(numero);
		System.out.println("Numero del jiente encontrado"+ jinete.getNumero());
	}
	
	

	
	
	public void escribirJinetes() {
		
	}
	
	public void escribirCaballos() {
		
	}
	
	
	
	
	public void imprimirCaballos() {
		main.darSimulador().imprimirCaballos();
	}
	
	
	
	
	
	
	

}

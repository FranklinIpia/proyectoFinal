package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

import javax.swing.JOptionPane;

import Excepciones.ExcepcionNoExisteElUsuarioConId;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modelo.Apuesta;
import modelo.Caballo;
import modelo.Jinete;
import modelo.Usuario;
import modelo.UsuarioVip;

public class CuponDeApuestasController {

	private Main main;


	@FXML
	private ImageView img1;
	
	@FXML
	private Label lblCuotaApuesta;
	
	@FXML
	private Label lblPagoPotencial;
	
	@FXML
	private Label lblImporteApostado;
	
	@FXML
	private TextField txtCantidadApuesta;
	
	@FXML
	private TextField txtCedulaUsuario;
	@FXML
	private Button btnGenerarApuesta;
	
	@FXML
	private TextField txtNumeroCaballo;
	
	@FXML
	private TextField txtID;
	
	
	@FXML
	private Button btnEmpezarCarrera;

	
	public CuponDeApuestasController() {
//		menu=new MenuController();
		main=new Main();
	btnEmpezarCarrera= new Button();
	btnEmpezarCarrera.setDisable(true);
	lblCuotaApuesta=new Label();
	lblImporteApostado=new Label();
	lblPagoPotencial=new Label();
	
//		cargarJinetes();
//	cargarCaballos() ;
//	
	}
	
	public void initialize() {
//		txtUsuario.setText(cedula);
//		 mostrarEnInterfaz();
	
	}
	
	
	
	
	
	
	
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
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
	
	
	
	
	public void gernerarApuesta(ActionEvent e) {
		 
		String cedula=JOptionPane.showInputDialog(null,"Confirmar Id");
		double cantidadApuesta= Double.parseDouble(txtCantidadApuesta.getText());
		
		
		if(cantidadApuesta<=1000000) {
	
					
	try {
		Usuario usuarioEncontrado=main.darSimulador().buscarUsuariofor(cedula);
		
      if(usuarioEncontrado==null) {
	     throw new ExcepcionNoExisteElUsuarioConId("No existe el Usuario con el id" + cedula);
       }else {
    	   System.out.println("Encontro el usuario");
    	   
    	   txtCedulaUsuario.setText(cedula+"");
   		int numeroCaballo=468;
   		double cuotaCaballo=Double.parseDouble(lblCuotaApuesta.getText());
   		double importe= cantidadApuesta;
   		double pagoPotencial=cantidadApuesta*cuotaCaballo;
		SecureRandom ran= new SecureRandom();
		double numeroApuesta=(double) 1+ ran.nextInt(9);
   		Apuesta apuestaNueva= new Apuesta(Apuesta.APUESTA_GANADOR,pagoPotencial,numeroApuesta+"",numeroCaballo);

   		usuarioEncontrado.agregarApuesta(apuestaNueva);
   	
   		lblImporteApostado.setText(importe+"");
   		lblPagoPotencial.setText(pagoPotencial+"");
   		txtNumeroCaballo.setText(numeroCaballo+"");
   		txtID.setText(numeroApuesta+"");
   		guardarArchivoEnComputadora( e);
       }
	} catch (ExcepcionNoExisteElUsuarioConId e2) {
	JOptionPane.showMessageDialog(null,e2.getMessage());
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
		
		}else {
			
			int num=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el numero del cupon"));
			UsuarioVip usuarioVip= main.darSimulador().buscarUsarioVip(num);
			try {
			
				if(usuarioVip==null) {
					throw new ExcepcionNoExisteElUsuarioConId("No existe el cupon" + num);
				}else {
					
			
				}
			}catch(ExcepcionNoExisteElUsuarioConId e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage());
			}
			
						
			
			
			
		}
		
		
		
		
	}
	
	

	
	
	
	public void guardarArchivoEnComputadora(ActionEvent e) throws IOException {
	
		
		if (e.getSource()==btnGenerarApuesta) {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setInitialFileName("Apuesta");
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			fileChooser.setSelectedExtensionFilter(extFilter);
			File file = fileChooser.showSaveDialog(main.darEstage());
			
			
			
//			BufferedReader buffer= new BufferedReader(fileReader);
			

			
			if(file!=null){
				
				FileWriter fw = null;
				BufferedWriter bw = null;
				try {
					// EL segundo parametro es un boolean
					// En true escribe al final
					// En false escribe al inicio
					fw = new FileWriter(file, false);
					bw = new BufferedWriter(fw);
					String importe=lblImporteApostado.getText();
					String cedula=txtCedulaUsuario.getText();
					String idApuesta1=txtID.getText();
					String numeroCaballo1=txtNumeroCaballo.getText();
					bw.write(importe+";"+cedula+";"+numeroCaballo1+";"+";"+idApuesta1);
					
//					String texto = textArea.getText();
//					bw.write(texto, 0, texto.length());
				} catch (Exception e1) {
//					textArea.appendText(e1.toString());
				} finally {
					try {
						bw.close();
					} catch (Exception e2) {
//						textArea.appendText(e2.toString());
					}
				}
			}
		}
		
		
		
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
	

	

}

package application;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.SimuladorApuesta;
import modelo.Usuario;

public class MenuController {
	
	@FXML
	private TextField texUsuario;
	@FXML
	private TextField texContrasena;
	@FXML
	private Button btEntrar;
	@FXML
	private Button btRegistrar;
	
	private Main main;
	
	private CuponDeApuestasController cupon;
	
	public MenuController() {
		main=new Main();
		cupon= new CuponDeApuestasController();
		guardarUsuariosSerializable();
		cargarJugadoresSerializables();
	}
	public void initialize() {
	
		
	}
	
	
	
	
	///Este metodo guarda el nuevo usuario serializable que se ha registrado
	public void guardarUsuariosSerializable() {
	
FileOutputStream fileOut = null;
ObjectOutputStream salida = null;
ArrayList<Usuario> usuarios=null;
Usuario uno= new Usuario("Sebastian", "Rebolledo", "1062332841","0000", 20,Usuario.MASCULINO, 20.000,"issareme@hotmail.com", 2,null);
boolean entro=false;
for(int i=0;i<main.darSimulador().getUsuarios().length&&!entro;i++) {
	if(main.darSimulador().getUsuarios()[i]==null) {
		main.darSimulador().getUsuarios()[i]=uno;
		usuarios= new ArrayList<Usuario>();
		usuarios.add(uno);
		entro=true;
	}
}


try {
	
	fileOut= new FileOutputStream("archivos/usuarios.dat");
	salida= new ObjectOutputStream(fileOut);
	for (int i = 0; i < main.darSimulador().getUsuarios().length; i++) {
		if(main.darSimulador().getUsuarios()[i]!=null) {
			usuarios.add(i, main.darSimulador().getUsuarios()[i]);
//			salida.writeObject(main.darSimulador().getUsuarios()[i]);
		}
	}
	salida.writeObject(usuarios);
	
}catch (FileNotFoundException e) {
	System.out.println(e.getMessage() +"1Excepcion metodo guardarJugadores de menucontroller");
}catch(IOException e) {
	System.out.println(e.getMessage()+"2Excepcion metodo guardarJugadores de menucontroller");
}finally{
	try {
		if(usuarios!=null) {
			fileOut.close();
		}
			
		if (salida != null) {
			salida.close();
		}
	} catch (IOException e) {
		System.out.println(e.getMessage()+ "3Excepcion metodo guardarJugadores de menucontroller");
	}
}
				
	
		

		
		
		
		
		
		
	}
	
	
	
	public void cargarJugadoresSerializables() {
		
		FileInputStream fileInput=null;
		ObjectInputStream entrada=null;
		Usuario[] nuevosUsuarios=null;
		ArrayList<Usuario> usuariosArray=null;
		
		try {
			fileInput= new FileInputStream("archivos/usuarios.dat");
			entrada= new ObjectInputStream(fileInput);
			usuariosArray=(ArrayList<Usuario>) entrada.readObject();
			nuevosUsuarios= new Usuario[SimuladorApuesta.MAX_USUARIOS];
			
			for(int i=0;i<usuariosArray.size();i++) {
				nuevosUsuarios[i]=usuariosArray.get(i);
			}
			
			main.darSimulador().setUsuarios(nuevosUsuarios);
			
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println(e.getMessage()+"1Excepcion metodo cargarJugadores menu");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage() +"2Excepcion metodo cargarJugadores menu");
		}catch(IOException e) {
			System.out.println(e.getMessage()+ "3Excepcion metodo cargarJugadores menu");
		}finally {
			
			 try {
		            if (fileInput != null) {
		            	fileInput.close();
		            }
		            if (entrada != null) {
		                entrada.close();
		            }
		        } catch (IOException e) {
		            System.out.println(e.getMessage()+"excep4");
		        }
			
			
			
		}
		
		
		
	}
	
	
	
	public void verificarUsuario() {
		
		String cedula=texUsuario.getText();
		String contraseña= texContrasena.getText();
		
		Usuario usuarioEncontrado=main.darSimulador().buscarUsuarioId(cedula);
		
		
		if(usuarioEncontrado!=null) {
			if(!usuarioEncontrado.getContraseña().equals(contraseña)) {
				System.out.println("La contraseña es incorrecta");
				}else {
					System.out.println("Entro");
//					cupon.initialize("hjaja");
				cupon.getTxtUsuario().setText("lllllll");
					
				}
		}else {
			System.out.println("No existe el usuario");
		}

		
		
		
		
	}
	




	
	
	
	
	public void openRegistrar(ActionEvent event) throws Exception {
		
		try {
			Parent showBegginer = FXMLLoader.load(getClass().getResource("Registrar.fxml"));
			Scene sceneBegginer = new Scene(showBegginer);
			Stage windowBegginer = (Stage)((Node) event.getSource()).getScene().getWindow();
			windowBegginer.setScene(sceneBegginer);
			windowBegginer.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void openEntrar(ActionEvent event) throws Exception {
		verificarUsuario() ;

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

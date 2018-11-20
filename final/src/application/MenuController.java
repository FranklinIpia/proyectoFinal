package application;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.omg.PortableServer.ThreadPolicyOperations;

import Excepciones.ExcepcionLaContraseñaEsInavalida;
import Excepciones.ExcepcionNoExisteElUsuarioConId;
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
//	cupon= new CuponDeApuestasController();
//		guardarUsuariosSerializable();
	cargarJugadoresSerializables();
	}
	public void initialize() {
	
		
	}
	
	
	
	
	public TextField getTexUsuario() {
		return texUsuario;
	}
	public void setTexUsuario(TextField texUsuario) {
		this.texUsuario = texUsuario;
	}
	public TextField getTexContrasena() {
		return texContrasena;
	}
	public void setTexContrasena(TextField texContrasena) {
		this.texContrasena = texContrasena;
	}
	///Este metodo guarda el nuevo usuario serializable que se ha registrado
	public void guardarUsuariosSerializable() {
	
FileOutputStream fileOut = null;
ObjectOutputStream salida = null;
ArrayList<Usuario> usuarios=null;
Usuario u1= new Usuario("Sebastian", "Rebolledo", "1062332841", "12345", 20, 1, 20.000, "issareme@hotmail.com",0, null);
Usuario u2= new Usuario("Sebastian", "Rebolledo", "1111", "12345", 20, 1, 20.000, "issareme@hotmail.com",0, null);
Usuario u3= new Usuario("Sebastian", "Rebolledo", "2222", "12345", 20, 1, 20.000, "issareme@hotmail.com",0, null);
Usuario u4= new Usuario("Sebastian", "Rebolledo", "0000", "12345", 20, 1, 20.000, "issareme@hotmail.com",0, null);
Usuario u5= new Usuario("Sebastian", "Rebolledo", "4444", "12345", 20, 1, 20.000, "issareme@hotmail.com",0, null);
Usuario u6= new Usuario("Sebastian", "Rebolledo", "6666", "12345", 20, 1, 20.000, "issareme@hotmail.com",0, null);


    try {
    	
    usuarios=new ArrayList<Usuario>();
    usuarios.add(u1);
    usuarios.add(u2);
    usuarios.add(u3);
    usuarios.add(u4);
    usuarios.add(u5);
    usuarios.add(u6);
	fileOut= new FileOutputStream("archivos/usuarios.dat");
	salida= new ObjectOutputStream(fileOut);
	for (int i = 0; i < main.darSimulador().getUsuarios().length; i++) {
		if(main.darSimulador().getUsuarios()[i]!=null) {
			usuarios.add(main.darSimulador().getUsuarios()[i]);
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
			System.out.println("No entro");
			System.out.println(usuariosArray.size());
			for(int i=0;i<usuariosArray.size();i++) {
				System.out.println(usuariosArray.get(i).getCedula());
			}
			
			for(int i=0;i<usuariosArray.size();i++) {
				nuevosUsuarios[i]=usuariosArray.get(i);
				System.out.println(":D" +nuevosUsuarios[i].getCedula());
			}

			System.out.println(usuariosArray.size());
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
	
	

	public void verificarUsuario(ActionEvent e) {
		
		String contraseña=texContrasena.getText();
		String cedula=texUsuario.getText();
		Usuario usuarioEncontrado=main.darSimulador().buscarUsuariofor(cedula);
	try {
		
		if(usuarioEncontrado==null) {
			
			throw new ExcepcionNoExisteElUsuarioConId("No existe el usuarios con ede id:" + cedula);
		}
		
		
		else {
			System.out.println(" no es nulo");
			if(usuarioEncontrado.getContraseña().compareTo(contraseña)!=0) {
				throw new ExcepcionLaContraseñaEsInavalida("La contraseña es invalida");
			}else {
				try {
					this.texUsuario= new TextField(cedula);
//					this.texUsuario.setText(cedula);
					handleButtonAction(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
		
	} catch (ExcepcionLaContraseñaEsInavalida e2) {
		JOptionPane.showMessageDialog(null,e2.getMessage());
		System.out.println(e2.getMessage());
		// TODO: handle exception
	}catch (ExcepcionNoExisteElUsuarioConId e2) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null,e2.getMessage());
		System.out.println(e2.getMessage());
	}
		
		
		
	}




	
	
	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException{
	    Stage stage ; 
	    Parent root ;
	    
	          
	     stage=(Stage) btEntrar.getScene().getWindow();
	    root = FXMLLoader.load(getClass().getResource("CuponDeApuestas.fxml"));

	    
	    Scene scene = new Scene(root);
	     stage.setScene(scene);
	     stage.show();
	     
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
//		verificarUsuario() ;

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

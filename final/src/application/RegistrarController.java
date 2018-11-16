package application;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Usuario;



public class RegistrarController {
	
	private Main main;
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
		main=new Main();
		
	}
	public void initialize() {
		
	}
	

	
	////El usuario se registra con los atributos basicos con un  dinero de 0.0
	//y la pauesta en null, ya que apenas se registro.
	public void registrarUsuario() {
		
		
		btRegistrarse.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(texNombre.getText()==null ||texNombre.getText()=="" ) {
					System.out.println("Debes llenar todos los campos");
				}else {
					
					String nombre=texNombre.getText();
					String apellido=texApellido.getText();
					String cedula=texCedula.getText();
					String contraseña=texContrasena.getText();
					String email=texConfirmarEmail.getText();
					int edad= Integer.parseInt(texEdad.getText());
					Usuario nuevoUsuario=null;
					btHombre.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
						
//					Usuario	 nuevoUsuario= new Usuario(nombre, apellido, cedula, contraseña, edad, Usuario.MASCULINO, 0.0, contraseña, email, 0, null);

							
							
						}
					});
					
//					 nuevoUsuario= new Usuario(nombre, apellido, cedula, contraseña, edad, Usuario.FEMENINO, 0.0, contraseña, email, 0, null);

					 boolean agrego=false;
					    for(int i=0;i<main.darSimulador().getUsuarios().length&&!agrego;i++) {
					        	if(main.darSimulador().getUsuarios()[i]==null) {
						            main.darSimulador().getUsuarios()[i]=nuevoUsuario;
						             agrego=true;
						             guardarUsuariosSerializable() ;
											
							}
						}
				}
				
			}
		});
	}
	
	
	///Este metodo guarda el nuevo usuario serializable que se ha registrado
	public void guardarUsuariosSerializable() {
	
FileOutputStream fileOut = null;
ObjectOutputStream salida = null;
ArrayList<Usuario> usuarios=null;

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
	System.out.println(e.getMessage());
}catch(IOException e) {
	System.out.println(e.getMessage());
}finally{
	try {
		if(usuarios!=null) {
			fileOut.close();
		}
			
		if (salida != null) {
			salida.close();
		}
	} catch (IOException e) {
		System.out.println(e.getMessage());
	}
}
				
	
		

		
		
		
		
		
		
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

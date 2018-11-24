package application;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Excepciones.ExcepcionElUsuarioYaEstaRegistrado;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Administrador;
import modelo.Apuesta;
import modelo.SimuladorApuesta;
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
	
	private MenuController menu;
	
	public RegistrarController() {
		main=new Main();
		menu= new MenuController();
//		registrarUsuario2();
		
//		cargarJugadoresSerializables();
//		guardarUsuariosSerializable();

	}
	public void initialize() {
		
	}
	

	
	public void registrarUsuario2() {
		
		
		String nombre=texNombre.getText();
		String apellido=texApellido.getText();
		String cedula=texCedula.getText();
		String contrase�a=texContrasena.getText();
		String email=texConfirmarEmail.getText();
		int edad= Integer.parseInt(texEdad.getText());
		Usuario usuarioEn=main.darSimulador().buscarUsuariofor(cedula);
		try {
			
	
			
			if(usuarioEn!=null) {
				throw new ExcepcionElUsuarioYaEstaRegistrado("ya existe un usuarios con le id:" + usuarioEn.getCedula());
			}else {
				
				Usuario nuevo= new Usuario(nombre, apellido, cedula, contrase�a, edad, 1, 0.0, email, 0, null);
				boolean ensarto=false;
				for(int i=0;i<main.darSimulador().getUsuarios().length&&!ensarto;i++) {
					
					if(main.darSimulador().getUsuarios()[i]==null) {
						main.darSimulador().getUsuarios()[i]=nuevo;
						ensarto=true;
						guardarUsuariosSerializable();
					}
				}
				
			}
			
			
//			menu.guardarUsuariosSerializable();
			menu.guardarUsuariosSerializable();
			main.darSimulador().imprimirUsuarios();
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,e2.getMessage());
		}
		
		
		
		
	}
	
	public void registrarAdmin() {
		String nombre=texNombre.getText();
		String apellido=texApellido.getText();
		String cedula=texCedula.getText();
		String contrase�a=texContrasena.getText();
		String email=texConfirmarEmail.getText();
		int edad= Integer.parseInt(texEdad.getText());
		
		Administrador admin= new Administrador(nombre, apellido, cedula, contrase�a, edad, 1);
		guardarUsuariosSerializable();
			
		
						
						
	 FileOutputStream fileOut = null;
	ObjectOutputStream salida = null;
	ArrayList<Usuario> usuarios=null;


		 try {
						    	
						
			fileOut= new FileOutputStream("archivos/admin.dat");
		     salida= new ObjectOutputStream(fileOut);
							
			salida.writeObject(admin);
							
						}catch (FileNotFoundException e) {
							System.out.println(e.getMessage() +"1Excepcion metodo guardarJugadores de menucontroller");
						}catch(IOException e) {
							System.out.println(e.getMessage()+"2Excepcion metodo guardarJugadores de menucontroller");
						}finally{
							try {
								if(admin!=null) {
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
	
	
	
	
	////El usuario se registra con los atributos basicos con un  dinero de 0.0
	//y la pauesta en null, ya que apenas se registro.
//	public void registrarUsuario() {
//		
//		
//		btRegistrarse.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				
//				if(texNombre.getText()==null ||texNombre.getText()=="" ) {
//					System.out.println("Debes llenar todos los campos");
//				}else {
//					
//					String nombre=texNombre.getText();
//					String apellido=texApellido.getText();
//					String cedula=texCedula.getText();
//					String contrase�a=texContrasena.getText();
//					String email=texConfirmarEmail.getText();
//					int edad= Integer.parseInt(texEdad.getText());
//					Usuario nuevoUsuario=null;
//					btHombre.setOnAction(new EventHandler<ActionEvent>() {
//						
//						@Override
//						public void handle(ActionEvent arg0) {
//							// TODO Auto-generated method stub
//						
////					Usuario	 nuevoUsuario= new Usuario(nombre, apellido, cedula, contrase�a, edad, Usuario.MASCULINO, 0.0, contrase�a, email, 0, null);
//
//							
//							
//						}
//					});
//					
////					 nuevoUsuario= new Usuario(nombre, apellido, cedula, contrase�a, edad, Usuario.FEMENINO, 0.0, contrase�a, email, 0, null);
//
//					 boolean agrego=false;
//					    for(int i=0;i<main.darSimulador().getUsuarios().length&&!agrego;i++) {
//					        	if(main.darSimulador().getUsuarios()[i]==null) {
//						            main.darSimulador().getUsuarios()[i]=nuevoUsuario;
//						             agrego=true;
//						             guardarUsuariosSerializable() ;
//											
//							}
//						}
//				}
//				
//			}
//		});
//	}
	
	
//	///Este metodo guarda el nuevo usuario serializable que se ha registrado
//	public void guardarUsuariosSerializable() {
//	
//FileOutputStream fileOut = null;
//ObjectOutputStream salida = null;
//ArrayList<Usuario> usuarios=null;
//
//try {
//	
//	fileOut= new FileOutputStream("archivos/usuarios.dat");
//	salida= new ObjectOutputStream(fileOut);
//	for (int i = 0; i < main.darSimulador().getUsuarios().length; i++) {
//		if(main.darSimulador().getUsuarios()[i]!=null) {
//			usuarios.add(i, main.darSimulador().getUsuarios()[i]);
////			salida.writeObject(main.darSimulador().getUsuarios()[i]);
//		}
//	}
//	salida.writeObject(usuarios);
//	
//}catch (FileNotFoundException e) {
//	System.out.println(e.getMessage());
//}catch(IOException e) {
//	System.out.println(e.getMessage());
//}finally{
//	try {
//		if(usuarios!=null) {
//			fileOut.close();
//		}
//			
//		if (salida != null) {
//			salida.close();
//		}
//	} catch (IOException e) {
//		System.out.println(e.getMessage());
//	}
//}
//				
//	
//		
//
//		
//		
//		
//		
//		
//		
//	}
	
	
	
	public void cargarJugadoresSerializables() {
		
		FileInputStream fileInput=null;
		ObjectInputStream entrada=null;
		Usuario[] nuevosUsuarios=null;
		ArrayList<Usuario> usuariosArray=null;
		
		try {
			fileInput= new FileInputStream("archivos/usuarios3.dat");
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
	
	
	public void guardarUsuariosSerializable() {
		
FileOutputStream fileOut = null;
ObjectOutputStream salida = null;
ArrayList<Usuario> usuarios=null;
//Usuario u2= new Usuario("Sebastian", "Rebolledo", "00000", "00000", 20, 1, 20.000, "issareme@hotmail.com",0, null);

//Usuario u1= new Usuario("Sebastian", "Rebolledo", "1062332841", "12345", 20, 1, 20.000, "issareme@hotmail.com",0, null);
//Usuario u2= new Usuario("Sebastian", "Rebolledo", "1111", "12345", 20, 1, 20.000, "issareme@hotmail.com",0, null);
//Usuario u3= new Usuario("Sebastian", "Rebolledo", "2222", "12345", 20, 1, 20.000, "issareme@hotmail.com",0, null);
//Usuario u4= new Usuario("Sebastian", "Rebolledo", "0000", "12345", 20, 1, 20.000, "issareme@hotmail.com",0, null);
//Usuario u5= new Usuario("Sebastian", "Rebolledo", "4444", "12345", 20, 1, 20.000, "issareme@hotmail.com",0, null);
//Usuario u6= new Usuario("Sebastian", "Rebolledo", "6666", "12345", 20, 1, 20.000, "issareme@hotmail.com",0, null);


    try {
    	
    usuarios=new ArrayList<Usuario>();
//    usuarios.add(u1);
//    usuarios.add(u2);
//    usuarios.add(u2);
//    usuarios.add(u3);
//    usuarios.add(u4);
//    usuarios.add(u5);
//    usuarios.add(u6);
	fileOut= new FileOutputStream("archivos/usuarios2.dat");
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

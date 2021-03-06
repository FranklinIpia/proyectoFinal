package application;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Excepciones.ExcepcionElUsuarioYaEstaRegistrado;
import Excepciones.ExcepcionLaContraseñaEsInavalida;
import Excepciones.ExcepcionNoEresElAdministrador;
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
import modelo.Administrador;
import modelo.SimuladorApuesta;
import modelo.Usuario;
import modelo.UsuarioVip;

public class MenuController {
	
	@FXML
	private TextField texUsuario;
	@FXML
	private TextField texContrasena;
	@FXML
	private Button btEntrar;
	@FXML
	private Button btRegistrar;
	
	@FXML
	private TextField txtAdmin;
	
	@FXML
	private TextField txtContraAdd;
	
	
	private Main main;
	
	private CuponDeApuestasController cupon;
	
	public MenuController() {
		main=new Main();
		txtAdmin= new TextField();
		txtContraAdd= new TextField();
		Administrador admin= new Administrador("final", "final", "final", "final", 20, 1);
		main.darSimulador().setAdmin(admin);
//		guardarUsuariosSerializable();
cargarJugadoresSerializables();
//	try {
//		guardarUsuariosVip( );
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
	cargarUsuariosVip( );
	impirmirIn();
	darTotales();
	
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

    try {
    	
    usuarios=new ArrayList<Usuario>();

	fileOut= new FileOutputStream("archivos/usuarios3.dat");
	salida= new ObjectOutputStream(fileOut);
	for (int i = 0; i < main.darSimulador().getUsuarios().length; i++) {

		
		if(main.darSimulador().getUsuarios()[i]!=null) {
			Usuario usuario=main.darSimulador().getUsuarios()[i];
			salida.writeObject(usuario);
		}
	}
	
	
	
	
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
	
	
	
	
    /**
     * Guarda en un archivo identificado con el nombre, el estado del mundo. <br>
     * <b>post:</b> El estado del mundo quedará guardado en un archivo que estará identificado con rutaNombre<br>
     * @param rutaNombre ruta y nombre del archivo - rutNombre != null
     * @throws PersistenciaException Lanzada cuando no se encuentra el archivo o no se puede guardar en él.
     */
    public void guardarUsuariosVip( ) throws IOException{
    	
    	
        try{
        	
        	
        	
            FileOutputStream archivo = new FileOutputStream( "archivos/usuariosVip3.dat");
            ObjectOutputStream objetoSaliente = new ObjectOutputStream( archivo );
            objetoSaliente.writeObject( main.darSimulador().getUsuarioVipRaiz() );
            objetoSaliente.close( );
            archivo.close( );
        }
        catch( IOException e ){
        	System.out.println(e.getMessage());
        	JOptionPane.showMessageDialog(null,e.getMessage() + ":D");
//            throw new PersistenciaException( "Error al salvar: " + e.getMessage( ) );
        } 


    }
	
    
    /**
     * Cargar de un archivo identificado con el nombre el estado del mundo que se encuentra guardado.<br>
     * <b>post:</b> El archivo que está identificado con rutaNombre queda cargado en el sistema.<br>
     * @param rutaNombre ruta y nombre del archivo - rutaNombre != null
     * @throws PersistenciaException Lanzada cuando ocurre algún problema con el archivo o con su formato
     * 
     */
    public void cargarUsuariosVip( )  {
        ObjectInputStream ois = null;
        try
        {
            File archivo = new File( "archivos/usuariosVip3.dat" );
            if( archivo.exists( ) )
            {
                ois = new ObjectInputStream( new FileInputStream( archivo ) );
                UsuarioVip usuariosVip= ( UsuarioVip )ois.readObject( );
                main.darSimulador().setUsuarioVipRaiz(usuariosVip);
                 System.out.println("Entro a usuarios vip");
               
                ois.close( );
            }
            else
            {
                main.darSimulador().setUsuarioVipRaiz(null);
            }
            
           
        }
        catch( FileNotFoundException e ){
        	System.out.println(e.getMessage() +"1--");
//            throw new PersistenciaException( "No se encontró el archivo de persistencia. \nAl cerrar la aplicación se generará por primera vez el archivo de persistencia " );
        }
        catch( IOException e ){
        	System.out.println(e.getMessage()+"2--");
//            throw new PersistenciaException( "No fue posible leer el archivo de persistencia. \n " + e.getMessage( ) );
        }
        catch( ClassNotFoundException e ){
        	System.out.println(e.getMessage()+"3--");
//            throw new PersistenciaException( "Problemas al cargar el archivo de persistencia. \n " + e.getMessage( ) );
        } 
//        catch (ExcepcionElUsuarioYaEstaRegistrado e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
    }
    
    
	
	
	
	
	public void cargarJugadoresSerializables() {
		
		FileInputStream fileInput=null;
		ObjectInputStream entrada=null;
		Usuario[] nuevosUsuarios=null;
		ArrayList<Usuario> usuariosArray=null;
		
		try {
			fileInput= new FileInputStream("archivos/usuarios3.dat");
			entrada= new ObjectInputStream(fileInput);

			
			boolean termino=false;
			for(int i=0;i<main.darSimulador().getUsuarios().length&&!termino;i++) {
				Usuario u1=(Usuario)entrada.readObject();
				if(u1!=null) {
					main.darSimulador().getUsuarios()[i]=u1;
					System.out.println(u1.getNombre() + u1.getApellido()+ u1.getCedula() +"contra"+ u1.getContraseña() );
	
				}else {
					termino=true;
				}
			}
			

			
			
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

	
	public void impirmirIn() {
		main.darSimulador().imprimirEntre();
	}
	
	
	public void darTotales() {
		System.out.println(main.darSimulador().getCantidadUsuariosVip());
		System.out.println(main.darSimulador().getUsuarioVipRaiz());
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


public void verificarAdmin(ActionEvent e) {
	
	String nombre= txtAdmin.getText();
	String contra= txtContraAdd.getText();
	
	try {
		String nombreAdmin= main.darSimulador().getAdmin().getNombre();
		String contraseñaAdmin=main.darSimulador().getAdmin().getContraseña();
		if(nombreAdmin.compareToIgnoreCase(nombre)==0&&contraseñaAdmin.compareToIgnoreCase(contra)==0) {
			
			openAdministrador(e);
			
		}
		else {
			throw new ExcepcionNoEresElAdministrador("No eres el adminsitrador");
		}
		
		
		
	} catch (ExcepcionNoEresElAdministrador e1) {
		JOptionPane.showMessageDialog(null,e1.getMessage());
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
}




public void openAdministrador(ActionEvent event) throws Exception {
	
	try {
		Parent showBegginer = FXMLLoader.load(getClass().getResource("Admin.fxml"));
		Scene sceneBegginer = new Scene(showBegginer);
		Stage windowBegginer = (Stage)((Node) event.getSource()).getScene().getWindow();
		windowBegginer.setScene(sceneBegginer);
		windowBegginer.show();
	}catch(IOException e) {
		e.printStackTrace();
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

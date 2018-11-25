package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;

import javax.swing.JOptionPane;

import Excepciones.ExcepcionElCaballoNoExiste;
import Excepciones.ExcepcionElJineteNoExiste;
import Excepciones.ExcepcionElUsuarioYaEstaRegistrado;
import Excepciones.ExcepcionNoExisteElUsuarioConId;
import Excepciones.ExcepcionNoTieneApuestasGanadas;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
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
	private ListView lista;
	
	@FXML
	private Label lblIpoApusta;
	
	@FXML
	private Label lblNumeroCaballo;

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
	
	
	@FXML
	private Button btnGanador;
	
	@FXML 
	private Button btnSegundo;
	
	@FXML
	private Button btnColocado;
	
	@FXML
	private ObservableList<String> dataLista = FXCollections.observableArrayList();

	
	////////////////////////////////////////////////////////////////////////
	@FXML
	private TextField txtCabNombre;
	
	@FXML
	private TextField txtCaballoNum;
	
	@FXML
	private TextField txtCaballoEdad;
	
	@FXML
	private TextField txtCaballoPeso;

	
	@FXML
	private TextField txtCaballoCarrerasGanadas;
	
	@FXML
	private TextField txtCarrerasPerdidas;
	
	@FXML
	private TextField txtVelocidadMaxima;
	
	@FXML
	private TextField txtGenero;
	
	@FXML
	private TextField  txtAltura;
	
	
	/////////////////////////////////////////////
    @FXML
    private TextField txtNombreJinete;

    @FXML
    private TextField txtEdadJinete;

    @FXML
    private TextField txtPesoJinete;

    @FXML
    private TextField txtNumeroJinete;

    @FXML
    private TextField txtCarrerasGandasJinetes;

    @FXML
    private TextField txtAlturaJinetes;

	
	public CuponDeApuestasController() {
//		menu=new MenuController();
		main=new Main();
		lista= new ListView();
	btnEmpezarCarrera= new Button();
	btnEmpezarCarrera.setDisable(true);
	lblCuotaApuesta=new Label();
	lblImporteApostado=new Label();
	lblPagoPotencial=new Label();
	txtAltura=new TextField();
	txtCaballoCarrerasGanadas=new TextField();
	txtCaballoEdad= new TextField();
	txtCaballoNum=new TextField();
	txtCaballoPeso=new TextField();
	txtCabNombre=new TextField();
	txtCarrerasPerdidas=new TextField();	
	txtVelocidadMaxima=new TextField();
	txtAlturaJinetes=new TextField();
	txtCarrerasGandasJinetes=new TextField();
	txtEdadJinete=new TextField();
	txtNombreJinete=new TextField();
	txtNumeroJinete=new TextField();
	txtVelocidadMaxima=new TextField();
	txtPesoJinete=new TextField();
	
		cargarJinetes();
	cargarCaballos() ;
//	
	}
	
	public void initialize() {
//		txtUsuario.setText(cedula);
//		 mostrarEnInterfaz();
		mostrarCaballos() ;
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
		boolean esVip=false;
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
   		int numeroCaballo=Integer.parseInt(lblNumeroCaballo.getText());
   		double cuotaCaballo=Double.parseDouble(lblCuotaApuesta.getText());
   		double importe= cantidadApuesta;
   		double pagoPotencial=cantidadApuesta*cuotaCaballo;
		SecureRandom ran= new SecureRandom();
		double numeroApuesta=(double) 1+ ran.nextInt(9);
		int tipoApuesta=Integer.parseInt(lblIpoApusta.getText());

   		Apuesta apuestaNueva= new Apuesta(tipoApuesta,pagoPotencial,numeroApuesta+"",numeroCaballo);

   		usuarioEncontrado.agregarApuesta(apuestaNueva);
   	
   		lblImporteApostado.setText(importe+"");
   		lblPagoPotencial.setText(pagoPotencial+"");
   		txtNumeroCaballo.setText(numeroCaballo+"");
   		txtID.setText(numeroApuesta+"");
   		guardarArchivoEnComputadora(e,esVip,0);
       }
	} catch (ExcepcionNoExisteElUsuarioConId e2) {
	JOptionPane.showMessageDialog(null,e2.getMessage());
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
	
	
	
		
	}else {
			
			int tarjetaVip=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el numero del cupon"));
			UsuarioVip usuarioVip= main.darSimulador().buscarUsarioVip(tarjetaVip);
			try {
			
				if(usuarioVip==null) {
					try {
						throw new ExcepcionNoExisteElUsuarioConId("No existe el cupon" + tarjetaVip);

					} catch(ExcepcionNoExisteElUsuarioConId e3){
						JOptionPane.showMessageDialog(null,e3.getMessage());
						
					}finally {
						// TODO: handle finally clause
						String mensaje1="1.Asociate con nostros\n2.No gracias";
						int opcion=Integer.parseInt(JOptionPane.showInputDialog(null,mensaje1));					
						if(opcion==1) {
							int cantidadApuestasGanadas=main.darSimulador().buscarUsuariofor(cedula).getApuestasGanadas();
							if(cantidadApuestasGanadas==1) {
								try {
									throw  new ExcepcionNoTieneApuestasGanadas("No tienes mas de 10 apuestas ganadas");
								} catch (ExcepcionNoTieneApuestasGanadas e1) {
									// TODO Auto-generated catch block
									JOptionPane.showMessageDialog(null,e1.getMessage());
								}
							}else {
								SecureRandom random= new SecureRandom();
								int newTarjetaVip= 2399;
								Usuario usua= main.darSimulador().buscarUsuariofor(cedula);
								
								MenuController men= new MenuController();
								try {
									main.darSimulador().insertarUsuarioVip(usua.getNombre(),usua.getApellido(), usua.getApellido(), usua.getContraseña(), usua.getEdad(),1929299, usua.getDinero(), usua.getContraseña(), usua.getCorreoElectronico(), usua.getApuestasGanadas(), null, 2121);
								} catch (ExcepcionElUsuarioYaEstaRegistrado e1) {
									// TODO Auto-generated catch block
//									e1.printStackTrace();
									System.out.println(e1.getMessage());
								}
							
								guardarUsuariosVip();
							}
						}
					}

					
					
					
					
					
					
				}else {
					esVip=true;
					int numeroCaballo=Integer.parseInt(lblNumeroCaballo.getText());
			   		double cuotaCaballo=Double.parseDouble(lblCuotaApuesta.getText());
			   		double importe= cantidadApuesta;
			   		double pagoPotencial=cantidadApuesta*cuotaCaballo;
					SecureRandom ran= new SecureRandom();
					double numeroApuesta=(double) 1+ ran.nextInt(9);
					int tipoApuesta=Integer.parseInt(lblIpoApusta.getText());
			   		Apuesta apuestaNueva= new Apuesta(tipoApuesta,pagoPotencial,numeroApuesta+"",numeroCaballo);

					usuarioVip.agregarApuesta(apuestaNueva);
				   	
			   		lblImporteApostado.setText(importe+"");
			   		lblPagoPotencial.setText(pagoPotencial+"");
			   		txtNumeroCaballo.setText(numeroCaballo+"");
			   		txtID.setText(numeroApuesta+"");
			   		guardarArchivoEnComputadora( e,esVip,tarjetaVip);
			
				}
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
						
			
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
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
//	            throw new PersistenciaException( "Error al salvar: " + e.getMessage( ) );
	        } 
//	        catch (ExcepcionElUsuarioYaEstaRegistrado e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	// catch (ExcepcionElUsuarioYaEstaRegistrado e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}


	    }
		
	
	
	
	
	
	
	
	
	
	
	
	
	public void buscarCaballo(ActionEvent e1) {
		try {
			int numero=Integer.parseInt(txtNumeroCaballo.getText());
			Caballo caballoEncontrado= main.darSimulador().buscarCaballo(numero);
			if(caballoEncontrado==null) {
				throw new ExcepcionElCaballoNoExiste("El numero del caballo que dijitaste no existe");
			}else {
				
				txtAltura.setText(caballoEncontrado.getAltura()+"");
				txtCaballoCarrerasGanadas.setText(caballoEncontrado.getCarrerasGanadas()+"");
				txtCarrerasPerdidas.setText(caballoEncontrado.getCarrerasPerdidas()+"_D");
				txtCabNombre.setText(caballoEncontrado.getNombre());
				txtVelocidadMaxima.setText(caballoEncontrado.getVelocidadMaxima()+"");
				txtCaballoPeso.setText(caballoEncontrado.getPeso()+"");
				txtCaballoNum.setText(caballoEncontrado.getNumero()+"");
				
//				Thread.sleep(200);
				openBuscarCaballo(e1);
				
			}

		} catch (ExcepcionElCaballoNoExiste e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

	
	
	public void buscarJinete(ActionEvent e1) {
		
		try {
			
			int numero=Integer.parseInt(txtID.getText());
			Jinete buscado=main.darSimulador().buscarJinete(numero);
			if(buscado==null) {
				throw new ExcepcionElJineteNoExiste("No existe el Jinete");
			}else {
				
				txtPesoJinete.setText(buscado.getPeso()+"");
				txtAlturaJinetes.setText(buscado.getAltura()+"");
				txtCarrerasGandasJinetes.setText(buscado.getCantidadCarrerasGanadas()+"");
				txtNumeroJinete.setText(buscado.getNumero()+"");
				txtEdadJinete.setText(buscado.getEdad()+"");
				txtNombreJinete.setText(buscado.getNombre());
				
				openBuscarJinete(e1);
				
			}
			
		} catch (ExcepcionElJineteNoExiste e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public void guardarArchivoEnComputadora(ActionEvent e,boolean esVip,int tarjetVip) throws IOException {
	
		
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
					String numeroCaballo1=lblNumeroCaballo.getText();
					String tipoApuesta=lblIpoApusta.getText();
					bw.write(importe+";"+cedula+";"+numeroCaballo1+";"+esVip+";"+tipoApuesta+";"+tarjetVip);
					
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

	
	
	
	
	
	public void mostrarCaballos() {
		
		
	Jinete actual= main.darSimulador().getPrimerJinete();
	
	while(actual!=null) {
		Caballo actualcab= actual.getPrimerCaballo();
		
		while(actualcab!=null) {
			
			dataLista.add(actualcab.getNumero()+"");
			actualcab=actualcab.getSiguiente();
		}
		actual=actual.getSiguiente();
	}
		
	
	
	
	lista.setItems(dataLista);
	


	

	
	
	lista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

		@Override
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			// TODO Auto-generated method stub
			lblNumeroCaballo.setText(newValue);
			
		
			
		}
	
	});
	
	
	
	
		
	}
	
	
	
	
	
	
	
	
	public void generarCuota() {
		
		
		btnGanador.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int numeroCaballo=Integer.parseInt(lblNumeroCaballo.getText());
				double cuota=main.darSimulador().prueba(numeroCaballo);
				lblCuotaApuesta.setText(cuota+"");
				lblIpoApusta.setText("1");
				
			}
		});
		
		
//		btnGenerarApuesta.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
//		
//		
//		btnColocado.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//		
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
				Parent showBegginer = FXMLLoader.load(getClass().getResource("InfoJinete.fxml"));
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

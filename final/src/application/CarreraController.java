package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.swing.JOptionPane;

import Comparador.ComparadorVelocidad;
import Hilos.HiloCaballo;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import modelo.Caballo;
import modelo.Jinete;
import modelo.Usuario;
import modelo.UsuarioVip;

public class CarreraController {
	
	
	private Main main;
	
	@FXML
	private ImageView img1;
	@FXML
	private ImageView img2;
	@FXML
	private ImageView img3;
	@FXML
	private ImageView img4;
	@FXML
	private ImageView img5;
	@FXML
	private ImageView img6;
	@FXML
	private ImageView img7;
	@FXML
	private TranslateTransition trans;
	@FXML
	private TranslateTransition trans2;
	@FXML
	private TranslateTransition trans3;
	@FXML
	private TranslateTransition trans4;
	@FXML
	private TranslateTransition trans5;
	@FXML
	private TranslateTransition trans6;
	@FXML
	private TranslateTransition trans7;
	@FXML
	private Button  btnCargar;
	
	@FXML
	private ListView listaNombre;
	
	@FXML
	private ObservableList<String> dataListaNombre= FXCollections.observableArrayList();
	
	
	private Caballo[] caballos;
	
	
	private int arregloPosiciones[];
	public CarreraController() {
		main=new Main();
		listaNombre=new ListView();

		 trans= new TranslateTransition();
			trans2= new TranslateTransition();
			 trans3= new TranslateTransition();
			trans4= new TranslateTransition();
			 trans5= new TranslateTransition();
			 trans6= new TranslateTransition();
				
			 trans7= new TranslateTransition();
			 arregloPosiciones= new int[7];
			 caballos= new Caballo[7];
//		moverCaballo();
	}

	
	public void initialize() {
//		URL pokemon1= getClass().getResource("/imagenes/caballlo.gif");
//	    Image image = new Image(pokemon1.toString());
//	    img1.setImage(image);
//	    img2.setImage(image);
//		moverCaballo2() ;


	

		
	
		moverCaballo2() ;



	

		
	}
	
	public void asiganrImagenes() {
	

		
	}
	
	public void moverCaballo2() {

		Caballo caballo1= main.darSimulador().buscarCaballo(468);
		Caballo caballo2= main.darSimulador().buscarCaballo(475);
		Caballo caballo3= main.darSimulador().buscarCaballo(318);
		Caballo caballo4= main.darSimulador().buscarCaballo(295);
		Caballo caballo5= main.darSimulador().buscarCaballo(228);
		Caballo caballo6=main.darSimulador().buscarCaballo(320);
		Caballo caballo7= main.darSimulador().buscarCaballo(319);
		int velocidad1= (int) caballo1.getVelocidadMaxima();
		int velocidad2= (int) caballo2.getVelocidadMaxima();
		int velocidad3= (int) caballo3.getVelocidadMaxima();
		int velocidad4= (int) caballo4.getVelocidadMaxima();
		int velocidad5= (int) caballo5.getVelocidadMaxima();
		int velocidad6= (int) caballo6.getVelocidadMaxima();
		int velocidad7= (int) caballo7.getVelocidadMaxima();

//		img1= new ImageView(caballo1.getNumero()+"");
//		img2=new ImageView(caballo2.getNumero()+"");
//		img3= new ImageView(caballo3.getNumero()+"");
//		img4=new ImageView(caballo4.getNumero()+"");
//		img5=new ImageView(caballo5.getNumero()+"");
//		img6=new ImageView(caballo6.getNumero()+"");
//		img7=new ImageView(caballo7.getNumero()+"");
//		
		 SecureRandom random = new SecureRandom();
	      int dx1 = 5 + random.nextInt(velocidad1);
	      caballo1.setVelocidadMaxima(dx1);
	      int dx2= 5+ random.nextInt(velocidad2);
	      caballo2.setVelocidadMaxima(dx2);
	      int dx3= 5+ random.nextInt(velocidad3);
	      caballo3.setVelocidadMaxima(dx3);
	      int dx4=5+ random.nextInt(velocidad4);
	      caballo4.setVelocidadMaxima(dx4);
	      int dx5= 5+ random.nextInt(velocidad5);
	      caballo5.setVelocidadMaxima(velocidad1);
	      int dx6= 5+ random.nextInt(velocidad6);
	      caballo6.setVelocidadMaxima(velocidad6);
	      int dx7= 5+ random.nextInt(velocidad7);
	      
	     caballos[0]=caballo1;
	      caballos[1]=caballo2;
	      caballos[2]=caballo3;
	      caballos[3]=caballo4;
	      caballos[4]=caballo5;
	      caballos[5]=caballo6;
	      caballos[6]=caballo7;

	      


		trans.setDuration(Duration.seconds(dx1));
		trans2.setDuration(Duration.seconds(dx2));
		trans3.setDuration(Duration.seconds(dx3));
		trans4.setDuration(Duration.seconds(dx4));
		trans5.setDuration(Duration.seconds(dx5));
		trans6.setDuration(Duration.seconds(dx6));
		trans7.setDuration(Duration.seconds(dx7));

		trans.setNode(img1);
		trans2.setNode(img2);
		trans3.setNode(img3);
		trans4.setNode(img4);
		trans5.setNode(img5);
		trans6.setNode(img6);
		trans7.setNode(img7);
		
		trans.setToX(665);	
		trans.play();
		trans2.setToX(665);
		trans2.play();
		trans3.setToX(665);	
		trans3.play();
		trans4.setToX(665);
		trans4.play();
		trans5.setToX(665);
		trans5.play();
		trans6.setToX(665);
		trans6.play();
		trans7.setToX(665);
		trans7.play();
		
		
		
		
		
		ordernarPosiciones(caballos); 
		
	}
	

	

	
	public void ordernarPosiciones(Caballo[] caballos) {
		
		  Arrays.sort(caballos, new ComparadorVelocidad());
		
		for (int i = 0; i < caballos.length; i++) {
			System.out.println(caballos[i].getNumero());
			
		}
	}
	
	
	public void toShowListForName() {
		

	   for (int i = 0; i < caballos.length; i++) {
		dataListaNombre.add(i+1+"/"+caballos[i].getNumero()+"");
	}	
		

		
		listaNombre.setItems(dataListaNombre);
		
		
	}
	
	
	
	
	
	public void cargarJuegoDeMiComputadora(ActionEvent e) {
//		rectanglePokemon.setLayoutX(350.02);
		
		if(e.getSource()==btnCargar) {
			FileChooser fileChooser = new FileChooser();
			File file = fileChooser.showOpenDialog(main.darEstage());
			
			
			if(file!=null){
				FileReader fr = null;
				BufferedReader br = null;
				String texto = "";
				try {
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					
					
					while((texto = br.readLine()) != null){ //Se leen las lineas hasta el final del documento
						System.out.println(texto);
						String[] data= texto.split(";");
						double cantidadApostada= Double.parseDouble(data[0]);
						String cedula=data[1];
						int numerpCaballo=Integer.parseInt(data[2]);
						boolean esVip=Boolean.parseBoolean(data[3]);
						int tipoApuesta=Integer.parseInt(data[4]);
						int tarjetaVip=Integer.parseInt(data[5]);
						verificarApuesta(tipoApuesta, numerpCaballo, cedula, esVip, tarjetaVip, cantidadApostada);
					}
					
					br.close();
				
					
				} catch (Exception ex) {
//					textArea.appendText(e.toString());
				} finally {
					try {
						fr.close();
					} catch (Exception e2) {
//						textArea.appendText(e2.toString());
					}
				}
				
			}
			
			
			
		}
		
	}

	
	
	
	
	
	public void verificarApuesta(int tipoApuesta,int numero,String cedula,boolean esVip,int tarjetVip,double cantidadApostad) {
		int numeroCaballo=caballos[0].getNumero();
		int numeroCaballo2=	caballos[1].getNumero();
int numeroCaballo3=caballos[2].getNumero();

		if(tipoApuesta==1) {
		
		
			if(esVip==true) {
				UsuarioVip us= main.darSimulador().buscarUsarioVip(tarjetVip);

				if(numeroCaballo==numero) {
					JOptionPane.showMessageDialog(null,"Felicitaciones,Reclama tu dinero");
					
					us.setApuestasGanadas(us.getApuestasGanadas()+1);	
				}else {
					JOptionPane.showMessageDialog(null,"Perdiste la Apuesta, suerte para la proxima");
				}
				
			}else {
				Usuario us= main.darSimulador().buscarUsuariofor(cedula);
				
				if(numeroCaballo==numero) {
					JOptionPane.showMessageDialog(null,"Felicitaciones,Reclama tu dinero");
					
					us.setApuestasGanadas(us.getApuestasGanadas()+1);	
				}else {
					JOptionPane.showMessageDialog(null,"Perdiste la Apuesta, suerte para la proxima");
				}
				
			}
			
			
		
			
			
			
			
		}else if(tipoApuesta==2) {
			
			
	
			
			if(esVip==true) {
				UsuarioVip us= main.darSimulador().buscarUsarioVip(tarjetVip);

				if(numeroCaballo2==numero) {
					JOptionPane.showMessageDialog(null,"Felicitaciones,Reclama tu dinero");
					
					us.setApuestasGanadas(us.getApuestasGanadas()+1);	
				}else {
					JOptionPane.showMessageDialog(null,"Perdiste la Apuesta, suerte para la proxima");
				}
				
			}else {
				Usuario us= main.darSimulador().buscarUsuariofor(cedula);
				
				if(numeroCaballo2==numero) {
					JOptionPane.showMessageDialog(null,"Felicitaciones,Reclama tu dinero");
					
					us.setApuestasGanadas(us.getApuestasGanadas()+1);	
				}else {
					JOptionPane.showMessageDialog(null,"Perdiste la Apuesta, suerte para la proxima");
				}
				
			}
			
			
			
			
			
			
			
		}else {
			
				
			
				if(esVip==true) {
					UsuarioVip us= main.darSimulador().buscarUsarioVip(tarjetVip);

					if(numeroCaballo2==numero||numeroCaballo==numero||numeroCaballo3==numero) {
						JOptionPane.showMessageDialog(null,"Felicitaciones,Reclama tu dinero");
						
						us.setApuestasGanadas(us.getApuestasGanadas()+1);	
					}else {
						JOptionPane.showMessageDialog(null,"Perdiste la Apuesta, suerte para la proxima");
					}
					
				}else {
					Usuario us= main.darSimulador().buscarUsuariofor(cedula);
					
					if(numeroCaballo==numero||numeroCaballo2==numero||numeroCaballo3==numero) {
						JOptionPane.showMessageDialog(null,"Felicitaciones,Reclama tu dinero");
						
						us.setApuestasGanadas(us.getApuestasGanadas()+1);	
					}else {
						JOptionPane.showMessageDialog(null,"Perdiste la Apuesta, suerte para la proxima");
					}
					
				}
				
			
				
			
			
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void moverCaballo() {
		Jinete j11=main.darSimulador().buscarJinete(468);
		Jinete j2= main.darSimulador().buscarJinete(475);
		Caballo cab= main.darSimulador().buscarCaballo(318);
		Caballo cab2= main.darSimulador().buscarCaballo(295);

		if(cab==null) {
			System.out.println("Nulo" + 318);
		}
		
		if(cab2==null) {
			System.out.println("Nulo" + 295);
		}
//		j2.getPrimerCaballo().setImagen(img1);
//		j11.getPrimerCaballo().setImagen(img2);
//	System.out.println(j11.getNombre());
		HiloCaballo caballo1= new HiloCaballo(cab);
		HiloCaballo caballo2= new HiloCaballo(cab2);
		 Thread hilonuevo= new Thread(caballo1);
		  Thread hilonuevo2= new Thread(caballo2);
		  hilonuevo.start();
		  hilonuevo2.start();
		
		
	}
	
	
	
	

}

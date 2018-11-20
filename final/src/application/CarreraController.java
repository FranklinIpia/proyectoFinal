package application;

import java.net.URL;

import Hilos.HiloCaballo;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Caballo;
import modelo.Jinete;

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
	
	
	public CarreraController() {
		main=new Main();
//		moverCaballo();
	}

	public void initialize() {
//		URL pokemon1= getClass().getResource("/imagenes/caballlo.gif");
//	    Image image = new Image(pokemon1.toString());
//	    img1.setImage(image);
//	    img2.setImage(image);
		
	}
	
	public void moverCaballo() {
		Jinete j11=main.darSimulador().buscarJinete(468);
		Jinete j2= main.darSimulador().buscarJinete(475);
		Caballo cab= new Caballo(img1, "j", 2, 4, 23.9, 12,2, 1, 2.0,1);
//		j2.getPrimerCaballo().setImagen(img1);
//		j11.getPrimerCaballo().setImagen(img2);
	System.out.println(j11.getNombre());
		HiloCaballo caballo1= new HiloCaballo(j11.getPrimerCaballo());
		HiloCaballo caballo2= new HiloCaballo(j2.getPrimerCaballo());
		 Thread hilonuevo= new Thread(caballo1);
		  Thread hilonuevo2= new Thread(caballo2);
		  hilonuevo.start();
		  hilonuevo2.start();
		
		
	}
	
	
	
	

}

package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import modelo.Caballo;
import modelo.Jinete;

public class CuponDeApuestasController {

	private Main main;
	
	
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
	
	public void buscarJinete(int numero) {
		Jinete jinete=main.darSimulador().buscarJinete(numero);
		System.out.println("Numero del jiente encontrado"+ jinete.getNumero());
	}
	
	
//	public void archivoPokemones() {
//		
//		File file= new File("archivos/pokemones.txt");
//		try {
//			FileReader fileReader= new FileReader(file);
//			BufferedReader buffer= new BufferedReader(fileReader);
//			String line="";
//			
//			while((line = buffer.readLine()) != null){ //Se leen las lineas hasta el final del documento
//				System.out.println(line);
//				String[] data= line.split(";");
//				String nombrePokemon=data[0];
//				double posicion=Double.parseDouble(data[1]);
//				double radio=Double.parseDouble(data[2]);
//				boolean esAtrapado=Boolean.parseBoolean(data[3]);
//				
//				String imagen=data[4];
//				Pokemon poke= new Pokemon(nombrePokemon,posicion,radio,esAtrapado, imagen);
//				main.darEntrenamiento().darPokemones().add(poke);
////				main.darPokemones().add(poke);
//			}
//			buffer.close();
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		
//	}
	
	
	public void escribirJinetes() {
		
	}
	
	public void escribirCaballos() {
		
	}
	
	
	
	
	public void imprimirCaballos() {
		main.darSimulador().imprimirCaballos();
	}
	
	
	
	
	
	
	

}

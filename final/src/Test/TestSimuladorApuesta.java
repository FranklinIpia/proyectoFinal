package Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


import Excepciones.ExcepcionElUsuarioYaEstaRegistrado;
import javafx.scene.image.ImageView;
import modelo.Caballo;
import modelo.Jinete;
import modelo.SimuladorApuesta;
import modelo.Usuario;
import modelo.UsuarioVip;

class TestSimuladorApuesta {

	private SimuladorApuesta simulador;
	
	public void scenario1() {
		simulador=new SimuladorApuesta();
	}
	
	
	/////////////////////////////////////////////////////////////////
	////Test para los metodos de ordenamiento///////////////////////
	
	@Test
	public void testOrdenarUsuariosSeleccion() {
		scenario1();
		Usuario u1= new Usuario("Andrea", "Pirlo", "12345", "12345", 14, 1, 0, "issareme@hotmail.com", 0, null);
		Usuario u2= new Usuario("Carlos", "Rodriguez", "12345", "12345", 14, 1, 0, "issareme@hotmail.com", 0, null);
		Usuario u3= new Usuario("Dayan", "Falcao", "12345", "12345", 14, 1, 0, "issareme@hotmail.com", 0, null);
		Usuario u4= new Usuario("Esteban", "Mina", "12345", "12345", 14, 1, 0, "issareme@hotmail.com", 0, null);
Usuario[] usuariosOrdenados= new Usuario[4];
usuariosOrdenados[0]=u1;
usuariosOrdenados[1]=u2;
usuariosOrdenados[2]=u3;
usuariosOrdenados[3]=u4;

Usuario[] usuariosAOrdenar= new Usuario[4];
usuariosAOrdenar[1]=u4;
usuariosAOrdenar[3]=u3;
usuariosAOrdenar[0]=u2;
usuariosAOrdenar[2]=u1;


Usuario[] realidad=simulador.ordenarUsuariosSeleccion(usuariosAOrdenar);
assertArrayEquals(usuariosOrdenados, realidad);		
		
	}
	
	
	@Test 
	public void testOrdenarUsuariosBurbuja() {
		scenario1();
		Usuario u1= new Usuario("Andrea", "Pirlo", "12345", "12345", 14, 1, 0, "issareme@hotmail.com", 1, null);
		Usuario u2= new Usuario("Carlos", "Rodriguez", "12345", "12345", 14, 1, 0, "issareme@hotmail.com", 2, null);
		Usuario u3= new Usuario("Dayan", "Falcao", "12345", "12345", 14, 1, 0, "issareme@hotmail.com", 3, null);
		Usuario u4= new Usuario("Esteban", "Mina", "12345", "12345", 14, 1, 0, "issareme@hotmail.com", 4, null);
		Usuario[] usuariosOrdenados= new Usuario[4];
		usuariosOrdenados[0]=u1;
		usuariosOrdenados[1]=u2;
		usuariosOrdenados[2]=u3;
		usuariosOrdenados[3]=u4;
		
		Usuario[] usuariosAOrdenar= new Usuario[4];
		usuariosAOrdenar[1]=u4;
		usuariosAOrdenar[3]=u3;
		usuariosAOrdenar[0]=u2;
		usuariosAOrdenar[2]=u1;
		

		Usuario[] expectactiva= simulador.ordenarUsuariosBurbuja(usuariosAOrdenar);
		assertArrayEquals(expectactiva, usuariosOrdenados);
		
	}
	
	@Test
	public void testOrdenarUsuariosInserccion() {
		scenario1();
		Usuario u1= new Usuario("Andrea", "Pirlo", "12345", "12345", 12, 1, 0, "issareme@hotmail.com", 1, null);
		Usuario u2= new Usuario("Carlos", "Rodriguez", "12345", "12345", 18, 1, 0, "issareme@hotmail.com", 2, null);
		Usuario u3= new Usuario("Dayan", "Falcao", "12345", "12345", 11, 1, 0, "issareme@hotmail.com", 3, null);
		Usuario u4= new Usuario("Esteban", "Mina", "12345", "12345", 10, 1, 0, "issareme@hotmail.com", 4, null);
		
		Usuario[] usuariosOrdenados= new Usuario[4];
		usuariosOrdenados[0]=u4;
		usuariosOrdenados[1]=u3;
		usuariosOrdenados[2]=u1;
		usuariosOrdenados[3]=u2;
		
		Usuario[] usuariosAOrdenar= new Usuario[4];
		usuariosAOrdenar[1]=u3;
		usuariosAOrdenar[3]=u4;
		usuariosAOrdenar[0]=u2;
		usuariosAOrdenar[2]=u1;
		
		
		Usuario[] expectativa= simulador.ordenarUsuariosInserccion(usuariosAOrdenar);
		assertArrayEquals(expectativa, usuariosOrdenados);

		
	}	
	
	///////////////////////////////////////////////////////////////////////
	////////////////Test para los metodos de bsuqueda Binaria/////////////////7
	
	
	@Test
	public void testBuscarUsuarioId() {
		scenario1();
		Usuario u1= new Usuario("Andrea", "Pirlo", "1", "12345", 12, 1, 0, "issareme@hotmail.com", 1, null);
		Usuario u2= new Usuario("Carlos", "Rodriguez", "2", "12345", 18, 1, 0, "issareme@hotmail.com", 2, null);
		Usuario u3= new Usuario("Dayan", "Falcao", "3", "12345", 11, 1, 0, "issareme@hotmail.com", 3, null);
		Usuario u4= new Usuario("Esteban", "Mina", "4", "12345", 10, 1, 0, "issareme@hotmail.com", 4, null);
		Usuario[] usuariosOrdenados= new Usuario[4];
		usuariosOrdenados[0]=u4;
		usuariosOrdenados[1]=u3;
		usuariosOrdenados[2]=u2;
		usuariosOrdenados[3]=u1;
		String cedula="3";

		Usuario usuarioEncontrado= simulador.buscarUsuarioId(cedula,usuariosOrdenados);
		if(usuarioEncontrado==null) {
			System.out.println("Paila");
		}else {
			System.out.println(usuarioEncontrado.getCedula());
		}
		
		assertEquals(cedula, usuarioEncontrado.getCedula());
	}
	
	
	
	@Test
	public void testBuscarUsuarioNombre() {
		scenario1();
		
		
		Usuario u1= new Usuario("Andrea", "Pirlo", "12345", "12345", 14, 1, 0, "issareme@hotmail.com", 0, null);
		Usuario u2= new Usuario("Carlos", "Rodriguez", "12345", "12345", 14, 1, 0, "issareme@hotmail.com", 0, null);
		Usuario u3= new Usuario("Dayan", "Falcao", "12345", "12345", 14, 1, 0, "issareme@hotmail.com", 0, null);
		Usuario u4= new Usuario("Esteban", "Mina", "12345", "12345", 14, 1, 0, "issareme@hotmail.com", 0, null);
        Usuario[] usuariosOrdenados= new Usuario[4];
        usuariosOrdenados[0]=u4;
        usuariosOrdenados[1]=u2;
         usuariosOrdenados[2]=u3;
        usuariosOrdenados[3]=u1;
        
        String nombreBuscar="Dayan";
        Usuario usuarioEncontrado= simulador.buscarUsuarioNombre(nombreBuscar, usuariosOrdenados);
        assertEquals(nombreBuscar, usuarioEncontrado.getNombre());
        
		
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////
	////////////////////Test para los metodos Recursivos////////////////////////////7
	
	
	@Test
	public void testInsertarUsuarioVip() {
		scenario1();
		
		try {
			simulador.insertarUsuarioVip("Sebastian", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 12);
			simulador.insertarUsuarioVip("Juana", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 5);
			simulador.insertarUsuarioVip("Andrea", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 20);
			simulador.insertarUsuarioVip("Carla", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 0);

		} catch (ExcepcionElUsuarioYaEstaRegistrado e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		int numeroAgregados=4;
		assertEquals(numeroAgregados, simulador.darTotalUsuariosVip());

		
	}
	
	
	@Test
	public void testEliminarUsuarioVip() {
	scenario1();
		
		try {
			simulador.insertarUsuarioVip("Sebastian", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 12);
			simulador.insertarUsuarioVip("Andrea", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 5);
			simulador.insertarUsuarioVip("Carlita", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 20);
			simulador.insertarUsuarioVip("Esteban", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 0);

		} catch (ExcepcionElUsuarioYaEstaRegistrado e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		String nombreEliminar="Carlita";
	int pesoExpectativa=3;
		simulador.eliminarUsuarioVip(nombreEliminar);
		assertEquals(pesoExpectativa, simulador.darTotalUsuariosVip());
		
	}
	
	
	@Test
	public void testBuscarUsuarioVip() {
		scenario1();
		try {
			String nombre1="Sebastian";
			String apellido1="Rebolledo";
			String cedula="12345";
			String correo="seereme98@gmail.com";
			int trajetaVip=12;
			int tarjetaVip=15;
			String nombre2="Andrea";
			simulador.insertarUsuarioVip(nombre1, apellido1,"1", cedula, 20, 1, 20.00, cedula, correo, 12, null, trajetaVip);
			simulador.insertarUsuarioVip(nombre2, apellido1,"1", cedula, 20, 1, 20.00, cedula, correo, 12, null, tarjetaVip);
			

		} catch (ExcepcionElUsuarioYaEstaRegistrado e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		int  tarjetaBuscar=12;
		UsuarioVip encontrado=simulador.buscarUsarioVip(tarjetaBuscar);
	
		assertEquals(tarjetaBuscar, encontrado.getTarjetaVip());
	}
	
	@Test
	public void testDarPesoUsuariosVip() {
		
		
		scenario1();
		try {
			simulador.insertarUsuarioVip("Sebastian", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 12);
			simulador.insertarUsuarioVip("Andrea", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 15);
			simulador.insertarUsuarioVip("Carlita", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 4);
			simulador.insertarUsuarioVip("Esteban", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 18);

		} catch (ExcepcionElUsuarioYaEstaRegistrado e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		int  totalAgregados=4;
	
		assertEquals(totalAgregados, simulador.darTotalUsuariosVip());
		
		
	}
	
	
	
	
	@Test
	public void testInsertarJinete() {
		scenario1();
		Jinete j1= new Jinete("Alberto", 25, 70.5, 213, 12,5, 1.70);
		Jinete j2= new Jinete("Alberto", 42, 20.5, 213, 12,5, 1.70);
		Jinete j3= new Jinete("Alberto", 18, 20.5, 213, 12,5, 1.70);
		Jinete j4= new Jinete("Alberto", 89, 20.5, 213, 12,5, 1.70);
		simulador.insertarJinete(j1);
		simulador.insertarJinete(j2);
		simulador.insertarJinete(j3);
		simulador.insertarJinete(j4);
int cantidadJientes=4;
assertEquals(cantidadJientes, simulador.getCantidadJientes());
		
	}
	
	@Test
	public void testInsertarCaballo() {
		scenario1();
		ImageView img1 = null;
		Jinete j1= new Jinete("Alberto", 25, 70.5, 213, 12,5, 1.70);
		
		Caballo cab1= new Caballo(img1, "Zeus", 21, 12, 1.50,10, 12, 1, 1.69, 48.0);
		Caballo cab2= new Caballo(img1, "Zeus", 21, 12, 1.50,10, 12, 1, 1.69, 48.0);
		Caballo cab3= new Caballo(img1, "Zeus", 21, 12, 1.50,10, 12, 1, 1.69, 48.0);
		Caballo cab4= new Caballo(img1, "Zeus", 21, 12, 1.50,10, 12, 1, 1.69, 48.0);

		j1.insertarCaballo(cab1);
		j1.insertarCaballo(cab2);
		j1.insertarCaballo(cab3);
		j1.insertarCaballo(cab4);
		int totalCaballos=4;
		assertEquals(totalCaballos, j1.getTotalCaballos());
		
		

		
	}
	
	
	
	@Test
	public void testBuscarJinete() {
		scenario1();
		Jinete j1= new Jinete("Alberto", 25, 70.5, 213, 12,5, 1.70);
		Jinete j2= new Jinete("Alberto", 42, 20.5, 216, 12,5, 1.70);
		int numeroBuscar=216;
		simulador.insertarJinete(j1);
		simulador.insertarJinete(j2);
		int numeroEncontrado=simulador.buscarJinete(numeroBuscar).getNumero();
		assertEquals(numeroBuscar, numeroEncontrado);
		
		
		
	}
	
	@Test
	public void testBuscarCaballo() {
		
		scenario1();
		ImageView img1 = null;
		Jinete j1= new Jinete("Alberto", 25, 70.5, 213, 12,5, 1.70);
		Caballo cab1= new Caballo(img1, "Zeus", 21, 12, 1.50,10, 12, 1, 1.69, 48.0);
		Caballo cab2= new Caballo(img1, "Zeus", 25, 12, 1.50,10, 12, 1, 1.69, 48.0);
		simulador.insertarJinete(j1);
		simulador.insertarCaballoAJinete(j1, cab2);
		simulador.insertarCaballoAJinete(j1, cab1);
		int numeroAbuscar=25;
		int numeroEncontrado=simulador.buscarCaballo(numeroAbuscar).getNumero();
		assertEquals(numeroAbuscar, numeroEncontrado);
		
		
	}
	

}

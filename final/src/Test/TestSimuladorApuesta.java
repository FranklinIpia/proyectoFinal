package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import Comparador.ComparadorApuesta;
import Comparador.ComparadorNombre;
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
//Arrays.sort(usuariosAOrdenar, new ComparadorNombre());

//for(int i=0;i<usuariosAOrdenar.length;i++) {
//	System.out.println(usuariosAOrdenar[i].getNombre());
//}


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
		
//		Arrays.sort(usuariosAOrdenar, new ComparadorApuesta());
//
//		for(int i=0;i<usuariosAOrdenar.length;i++) {
//			System.out.println(usuariosAOrdenar[i].getNombre());
//		}
//		
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
		UsuarioVip u1= new UsuarioVip("Sebastian", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 12);
		UsuarioVip u2= new UsuarioVip("Sebastian", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 5);
		UsuarioVip u3= new UsuarioVip("Sebastian", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 20);
		UsuarioVip u4= new UsuarioVip("Sebastian", "Rebolledo","1", "12345", 20, 1, 20.00, "12345", "seereme98@gmail.com", 12, null, 0);

		
		
	}
	
	@Test
	public void testInsertarJinete() {
		
	}
	
	@Test
	public void testInsertarCaballo() {
		
	}
	
	@Test
	public void testEliminarUsuarioVip() {
		
	}
	
	@Test
	public void testBuscarUsuarioVip() {
		
	}
	
	@Test
	public void testBuscarJinete() {
		
	}
	
	@Test
	public void testBuscarCaballo() {
		
	}
	
	
	
	
	
	
	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}

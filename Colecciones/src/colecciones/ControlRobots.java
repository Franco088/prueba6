package colecciones;
import java.util.ArrayList;
import java.util.Random;
public class ControlRobots {
	static final int NUM_ROBOTS = 8;
	static final String PREF_COD = "RBT";
	static final int MIN = 1;
	static final int MAX = 100;
	static final int PORC_MEDIO = 50;
	
	public static void main(String[] args) {
ArrayList<Robot> listaRobots = new ArrayList<Robot>();
		
		cargarLista(listaRobots);
		
		// **** ordenamos la lista ****
		ordenarLista(listaRobots);
		
		// ** imprimimos la lista
		imprimirListaOrdenada(listaRobots);
		
		// ** imprimir robots con más del 50% de porcVida
		imprimirMas50(listaRobots);
		
		// ** imprimir los tres robots con más porcVida
		imprimir3MasPorcVida(listaRobots);

	}

	private static void imprimir3MasPorcVida(ArrayList<Robot> listaRobots) {
		System.out.println("\nRobots con más porcentaje de vida");
		for (int i = 1; i <= 3; i++) {
			System.out.println(listaRobots.get(listaRobots.size() - i));
		}
	}

	private static void imprimirMas50(ArrayList<Robot> listaRobots) {
		System.out.println("\nLista de robot con más del " 
				+ PORC_MEDIO + "% de porcentaje de vida");
		for (Robot robot : listaRobots) {
			if (robot.getPorcVida() > PORC_MEDIO) {
				System.out.println(robot);
			}
		}
	}

	private static void imprimirListaOrdenada(ArrayList<Robot> listaRobots) {
		System.out.println("\nLista de robot ordenada por porcentaje de vida");
		for (Robot robot : listaRobots) {
			System.out.println(robot);
		}
	}

	private static void ordenarLista(ArrayList<Robot> listaRobots) {
		Robot r = null;
		for (int i = 0; i < listaRobots.size()-1; i++) {
			for (int j = i+1; j < listaRobots.size(); j++) {
				
				if (listaRobots.get(i).getPorcVida() > 
										listaRobots.get(j).getPorcVida()) {
					r = listaRobots.get(i);
					listaRobots.set(i, listaRobots.get(j));
					listaRobots.set(j, r);
				}
			}
		}
	}

	private static void cargarLista(ArrayList<Robot> listaRobots) {
		Robot r = null;
		String codigo = "";
		int porcVida = 0;
		for (int i = 1; i <= NUM_ROBOTS ; i++) {
			codigo = PREF_COD + i; 
			porcVida = generarAleatorio(MIN, MAX);
			r = new Robot(codigo, porcVida);
			listaRobots.add(r);
		}
	}
	
	private static int generarAleatorio(int min, int max) {
		Random r = new Random();
		int n = r.nextInt(max - min + 1) + min; //[min, max]
		return n;

	

	}

}

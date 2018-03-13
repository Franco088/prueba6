package colecciones;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;
public class ControlRobots2 {

	static final int NUM_ROBOTS = 8;
	static final String PREF_COD = "RBT";
	static final int MIN = 1;
	static final int MAX = 100;
	static final int PORC_MEDIO = 50;
	public static void main(String[] args) {
TreeSet<Robot> conjRobots = new TreeSet<Robot>();
		
		cargarConjunto(conjRobots);
		
		imprimirConjunto(conjRobots);
		
		imprimirMas50(conjRobots);
		
		imprimir3MasPorcVida(conjRobots);

	}
	
	private static void imprimir3MasPorcVida(TreeSet<Robot> listaRobots) {
		System.out.println("\nRobots con más porcentaje de vida");
		int cont = 0;
		Iterator<Robot> it = listaRobots.descendingIterator();
		while (it.hasNext() && cont < 3) {
			System.out.println(it.next());
			cont++;
		}
	}

	private static void imprimirMas50(TreeSet<Robot> listaRobots) {
		System.out.println("\nLista de robot con más del " 
				+ PORC_MEDIO + "% de porcentaje de vida");
		for (Robot robot : listaRobots) {
			if (robot.getPorcVida() > PORC_MEDIO) {
				System.out.println(robot);
			}
		}
	}

	private static void imprimirConjunto(TreeSet<Robot> listaRobots) {
		System.out.println("\nLista de robot ordenada por porcentaje de vida");
		for (Robot robot : listaRobots) {
			System.out.println(robot);
		}
	}

	private static void cargarConjunto(TreeSet<Robot> listaRobots) {
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

package colecciones;

public class Robot {

	
	private String codigo;
	private int porcVida;
	
	public Robot(String codigo, int porcVida) {
		super();
		this.codigo = codigo;
		this.porcVida = porcVida;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getPorcVida() {
		return porcVida;
	}

	@Override
	public String toString() {
		return "Robot [codigo=" + codigo 
				+ ", porcentaje de vida =" + porcVida + "%]";
	}

	public int compareTo(Robot o) {
		return porcVida - o.getPorcVida();
	}	

	
	
}

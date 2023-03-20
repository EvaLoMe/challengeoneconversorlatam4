package challenge;

public class Moneda {

	private String nombre;
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	private double valor;
	
	public Moneda (String Nombre, double Valor) {
		nombre= Nombre;
		valor= Valor;
	}
}

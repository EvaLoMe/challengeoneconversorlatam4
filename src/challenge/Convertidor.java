package challenge;
import java.util.*;

public class Convertidor {

	//Necesitamos una lista de Monedas
	private ArrayList<Moneda> divisas;
	private String nombre;
	public Convertidor (String nombre) {
		this.nombre=nombre;
		divisas = new ArrayList<Moneda>();
		
	}
	
	public Convertidor (ArrayList<Moneda> Divisas) {
		divisas = Divisas;
		
	}
	
	public String getName() {
		return nombre;
	}
	public void agregarDivisa(String nombre, double valor) {
		divisas.add(new Moneda(nombre, valor));
		
		
	}
	public Moneda obtenerDivisa(String nombre) {
		Moneda aux=null;
		for(int i=0; i<divisas.size(); i++) {
			 aux=divisas.get(i);
			//System.out.println(aux.getNombre()+"<--");
			if(aux.getNombre().equals(nombre)) {
				break;
			}
		}
		return aux;
	}
	public int cantidadDivisas() {
		return divisas.size();
	}
	
	public double convertirADivisa(String base, String comparativa) {
		double resultado=0;
		Moneda baseM, comparativaM;
		baseM=obtenerDivisa(base);
		comparativaM=obtenerDivisa(comparativa);
		resultado=baseM.getValor()/comparativaM.getValor();
		return resultado;
	}
	
	public String getDivisa(int posicion) {
		return divisas.get(posicion).getNombre();
	}

	@Override
	public String toString() {
		String respuesta="";
		for(int i=0; i<divisas.size(); i++) {
			Moneda aux=divisas.get(i);
			//System.out.println(aux.getNombre()+"<--");
			respuesta=respuesta+aux.getNombre()+" "+aux.getValor()+ "\n";
		}
		return respuesta;
	}
	
}


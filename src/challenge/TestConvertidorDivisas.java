package challenge;

public class TestConvertidorDivisas {

	public static void main(String[] args) {
		// Al dìa 16 de Marzo de 2023
		Convertidor conversor = new Convertidor("");
		conversor.agregarDivisa("Peso", 1);
		conversor.agregarDivisa("Dólar", 18.78 );
		conversor.agregarDivisa("Euro", 19.93);
		conversor.agregarDivisa("Yen Japonés", 0.14);
		conversor.agregarDivisa("Libra esterlina", 22.73);
		conversor.agregarDivisa("Won Sul-Coreano", 0.014);
		System.out.println(conversor);
		System.out.println(conversor.convertirADivisa("Peso", "Dólar"));
		
	}
	

}

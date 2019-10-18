package app;

import bd.BD;
import vista.Vista;

public class Main {
	
	public static BD bd;
	public static Vista vista;

	public static void main(String[] args) {
		
		MostrarPantalla("Iniciando entorno grafico");
		vista = new Vista();
		bd = new BD();
		bd.Conectar();
	}
	
	private static void MostrarPantalla(String mensaje)
	{
		System.out.println("[Info](Nucleo): " + mensaje);
	}
	
	public static void CerrarAplicacion()
	{
		MostrarPantalla("Orden de cierre recivida");
		vista.CerrarVentanas();
		bd.CerrarConexion();
		MostrarPantalla("Matando proceso principal");
		System.exit(0);
	}

}

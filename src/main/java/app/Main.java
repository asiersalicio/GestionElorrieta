package app;

import bd.Conexion;
import vista.Vista;

public class Main {
	
	public static Conexion conexion;
	public static Vista vista;

	public static void main(String[] args) {
		
		MostrarPantalla("Iniciando entorno grafico");
		vista = new Vista();
		vista.MostrarIniciarSesion();
		MostrarPantalla("Iniciando conexcion de la base de datos");
		conexion = new Conexion();

	}
	
	private static void MostrarPantalla(String mensaje)
	{
		System.out.println("[Info](Nucleo): " + mensaje);
	}
	
	public static void CerrarAplicacion()
	{
		MostrarPantalla("Orden de cierre recivida");
		vista.CerrarVentanas();
		conexion.CerrarConexion();
		MostrarPantalla("Matando proceso principal");
		System.exit(0);
	}

}

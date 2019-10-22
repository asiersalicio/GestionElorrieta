package app;

import java.io.IOException;

import bd.BD;
import es.Es;
import vista.Vista;

public class Main {
	
	public static BD bd;
	public static Vista vista;
	public static Es es;

	public static void main(String[] args) throws IOException {
		MostrarPantalla("Iniciando modulo grafico");
		vista = new Vista();
		MostrarPantalla("Iniciando modulo E/S");
		es = new Es();
		MostrarPantalla("Iniciando modulo de datos");
		bd = new BD();
		bd.EstablecerDatos(es.interprete.CargarDatosInicioSesion());
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

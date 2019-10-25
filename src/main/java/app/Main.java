package app;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import bd.BD;
import es.Es;
import obj.CeldaTitulo;
import vista.Vista;
import vista.controladores.CEditorTablas;

public class Main {
	
	public static BD bd;
	public static Vista vista;
	public static Es es;

	public static void main(String[] args) throws IOException {
		Inicializar();
	}
	
	public static void Inicializar()
	{
		MostrarPantalla("Iniciando modulo grafico");
		vista = new Vista();
		MostrarPantalla("Iniciando modulo E/S");
		es = new Es();
		MostrarPantalla("Iniciando modulo de datos");
		bd = new BD();
		bd.EstablecerDatos(es.interprete.CargarDatosInicioSesion());
		
		bd.Conectar(); //Espera a que se conecte
		
		if(!bd.ComprobarVacio())
		{
			JOptionPane.showMessageDialog(null, "No existen tablas en la base de datos, es necesario importar datos.");
			ImportarDatos();
		}
		else
		{
			vista.MostrarMenu();
		}
		
		
	}
	
	private static void ImportarDatos()
	{
		vista.CrearEditorTablas();
		File puestos = es.archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("Archivo de puestos", "csv"));
		String[] titulosCeldas= {"Cod puesto","Nom Puesto"};
		vista.editorTablas.RellenarCeldas(es.interprete.LectorArchivos2D(puestos, ";"), puestos, titulosCeldas);
		vista.editorTablas.Mostrar();
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

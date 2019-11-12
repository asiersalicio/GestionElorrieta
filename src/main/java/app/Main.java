package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Dialogos.Consola;
import bd.BD;
import es.Es;
import obj.CeldaTitulo;
import vista.Vista;
import vista.controladores.CEditorTablas;

public class Main {
	
	public static BD bd;
	public static Vista vista;
	public static Es es;
	public static Consola consola;

	public static void main(String[] args) throws IOException {
		Inicializar();
	}
	
	public static void Inicializar()
	{
		consola=new Consola();		
		MostrarPantalla("Iniciando modulo grafico");
		vista = new Vista();
		MostrarPantalla("Iniciando modulo E/S");
		es = new Es();
		MostrarPantalla("Iniciando modulo de datos");
		bd = new BD();
		bd.EstablecerDatos(es.interprete.CargarDatosInicioSesion());
		bd.Conectar(); //Espera a que se conecte
		
		vista.MostrarMenu();

		ImportarDatos();
		
		
	}
	
	private static void ImportarDatos()
	{
		if(bd.ComprobarTablaExistente("PUESTOS")==true&&bd.ComprobarTablaExistente("DEPARTAMENTO")==true&&bd.ComprobarTablaExistente("EMPLEADO")==true)
		{
			if(!bd.ComprobarRelleno("PUESTOS"))
			{
				JOptionPane.showMessageDialog(null, "No existen datos en la tabla puestos, es necesario importar datos.");
				ImportarPuestos(0);
			}
			if(!bd.ComprobarRelleno("DEPARTAMENTO"))
			{
				JOptionPane.showMessageDialog(null, "No existen datos en la tabla departamentos, es necesario importar datos.");
				ImportarDepartamentos(0);
			}
			if(!bd.ComprobarRelleno("EMPLEADO"))
			{
				JOptionPane.showMessageDialog(null, "No existen datos en la tabla empleados, es necesario importar datos.");
				ImportarEmpleados(0);
			}
			ImportarPuestos(1);
			ImportarDepartamentos(1);
			ImportarEmpleados(1);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "La base de datos no contiene las tablas necesarias, crea dichas tablas para utilizar la aplicación");
			CerrarAplicacion();
		}
		
		
	}
	
	private static void ImportarPuestos(int i)
	{
		if(i==0)
		{
			vista.CrearEditorTablas();
			File puestos = es.archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("Archivo de puestos", "csv"));
			String[] titulosCeldas= {"Cod puesto","Nom Puesto"};
			ArrayList<ArrayList<String>> celdasPuestos = es.interprete.LectorArchivos2D(puestos, ";");
			if(celdasPuestos!=null)
			{
				vista.editorTablas.RellenarCeldas(celdasPuestos, puestos, titulosCeldas, "PUESTO");
				vista.editorTablas.Mostrar();
			}
			else
			{
				CerrarAplicacion();
			}
		}
		else if(i==1)
		{
			vista.CrearEditorTablas();
			File puestos = new File(".\\Puestos.csv");
			String[] titulosCeldas= {"Cod puesto","Nom Puesto"};
			ArrayList<ArrayList<String>> celdasPuestos = es.interprete.LectorArchivos2D(puestos, ";");
			if(celdasPuestos!=null)
			{
				vista.editorTablas.RellenarCeldas(celdasPuestos, puestos, titulosCeldas, "PUESTO");
				//vista.editorTablas.Mostrar();
				vista.editorTablas.BotonAceptarPulsado();
			}
			else
			{
				CerrarAplicacion();
			}
		}

	}
	
	private static void ImportarDepartamentos(int i)
	{
		if(i==0)
		{
			vista.CrearEditorTablas();
			File deptartamentos = es.archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("Archivo de departamentos", "csv"));
			String[] titulosCeldas= {"Cod departamento","Nom departamento","Edificio","Ubicación"};
			ArrayList<ArrayList<String>> celdasPuestos = es.interprete.LectorArchivos2D(deptartamentos, ";");
			if(celdasPuestos!=null)
			{
				vista.editorTablas.RellenarCeldas(celdasPuestos, deptartamentos, titulosCeldas, "DEPARTAMENTO");
				vista.editorTablas.Mostrar();
			}
			else
			{
				CerrarAplicacion();
			}
		}
		else if(i==1)
		{
			vista.CrearEditorTablas();
			File deptartamentos = new File(".\\Departamento.csv");
			String[] titulosCeldas= {"Cod departamento","Nom departamento","Edificio","Ubicación"};
			ArrayList<ArrayList<String>> celdasPuestos = es.interprete.LectorArchivos2D(deptartamentos, ";");
			if(celdasPuestos!=null)
			{
				vista.editorTablas.RellenarCeldas(celdasPuestos, deptartamentos, titulosCeldas, "DEPARTAMENTO");
				//vista.editorTablas.Mostrar();
				vista.editorTablas.BotonAceptarPulsado();
			}
			else
			{
				CerrarAplicacion();
			}
		}
		
	}
	
	private static void ImportarEmpleados(int i)
	{
		if(i==0)
		{
			vista.CrearEditorTablas();
			File deptartamentos = es.archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("Archivo de departamentos", "ini"));
			String[] titulosCeldas= {"Cod empleado","Nom departamento","Departametno","Sueldo", "Jefe", "Su Jefe", "Puesto"};
			ArrayList<ArrayList<String>> celdasPuestos = es.interprete.LectorArchivosINI(deptartamentos);
			if(celdasPuestos!=null)
			{
				vista.editorTablas.RellenarCeldas(celdasPuestos, deptartamentos, titulosCeldas, "EMPLEADO");
				vista.editorTablas.Mostrar();
			}
			else
			{
				CerrarAplicacion();
			}
		}
		else if(i==1)
		{
			vista.CrearEditorTablas();
			File deptartamentos = new File(".\\Empleado.ini");
			String[] titulosCeldas= {"Cod empleado","Nom departamento","Departametno","Sueldo", "Jefe", "Su Jefe", "Puesto"};
			ArrayList<ArrayList<String>> celdasPuestos = es.interprete.LectorArchivosINI(deptartamentos);
			if(celdasPuestos!=null)
			{
				vista.editorTablas.RellenarCeldas(celdasPuestos, deptartamentos, titulosCeldas, "EMPLEADO");
				//vista.editorTablas.Mostrar();
				vista.editorTablas.BotonAceptarPulsado();
			}
			else
			{
				CerrarAplicacion();
			}
		}
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

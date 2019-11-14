package es;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import app.Main;
import obj.Departamento;
import obj.Empleado;
import obj.Puesto;

public class Interprete extends Main {

	public Interprete()
	{
		
	}
	
	public String LectorTextoPlano(File archivo)
	{
		String resultado = "";
		try
        {
            String linea = "";
            BufferedReader lectorArchivos = new BufferedReader(new FileReader(archivo));
            while ((linea = lectorArchivos.readLine()) != null)
            {
                resultado=resultado + linea + "\n";
            }
            lectorArchivos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return resultado;
	}
	
	public String[] LectorArchivos1D(File archivo)
	{
		String[] resultado = new String[0];
		try
        {
            String linea = "";
            BufferedReader lectorArchivos = new BufferedReader(new FileReader(archivo));
            int contador=0;
            while ((linea = lectorArchivos.readLine()) != null)
            {
            	contador++;
            	resultado=Arrays.copyOf(resultado, contador);
            	resultado[contador-1] = linea;//.split(separador);
            }
            lectorArchivos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return resultado;
	}
	
	public ArrayList<ArrayList<String>> LectorArchivos2D(File archivo, String separador)
	{
		
		ArrayList<ArrayList<String>> tabla = new ArrayList<ArrayList<String>>();
		String linea;
		
		try
	        {
	            BufferedReader lectorArchivos = new BufferedReader(new FileReader(archivo));
	            int contador=0;
	            while ((linea = lectorArchivos.readLine()) != null)
	            {
	            	String[] list = linea.split(separador);
	            	tabla.add(new ArrayList<String>());
	            	for(int i=0;i<list.length;i++)
	            	{
	            		tabla.get(contador).add(list[i]);
	            	}
	            	contador++;
	            }
	            lectorArchivos.close();
	        }
	        catch (NullPointerException  e) {
	            return null;
	        }
			catch(IOException e2)
			{
				e2.printStackTrace();	
			}
			
		   return tabla;
	}
	
	public ArrayList<ArrayList<String>> LectorArchivosINI(File archivo)
	{
		
		ArrayList<ArrayList<String>> tabla = new ArrayList<ArrayList<String>>();
		String linea;
		
		try
        {
            BufferedReader lectorArchivos = new BufferedReader(new FileReader(archivo));
            int contador=-1;
            while ((linea = lectorArchivos.readLine()) != null)
            {
            	System.out.println(linea);
            	if(linea.charAt(0)=='[' && linea.charAt(linea.length()-1)==']')
            	{
            		tabla.add(new ArrayList<String>());
            		contador++;
            		tabla.get(contador).add(linea.substring(1, linea.length()-1));
            	}
            	else if(!(linea.charAt(0)=='#') && !(linea.charAt(0)==' ')) 
            	{
	            	String[] list = linea.split("=");
	            	tabla.get(contador).add(list[1]);
            	}
            	else
            	{
            		MostrarError("Formato de archivo ini incorrecto");
            	}
            	
            }
            lectorArchivos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
			
		   return tabla;
	}
	
	
	
	public File GuardarArrayListEnCSV(File archivo, ArrayList<ArrayList<String>> arrayList, String separador)
	{
		String resultado = "";
		int x,y;
		
		for(y=0;y<arrayList.size();y++)
		{
			for(x=0;x<arrayList.get(y).size();x++)
			{
				resultado=resultado + arrayList.get(y).get(x) + separador;
			}
			resultado=resultado+"\n";			
		}
		return es.archivos.GrabarTextoPlano(archivo, resultado);
	}
	
	public String[] CargarDatosInicioSesion() {
		File archivo = new File("./Sesion.dat");
		if(archivo.exists())
		{
			return LectorArchivos1D(archivo);
		}
		else
		{
			return new String[3];
		}
	}
	
	public void GuardarDatosInicioSesion() {
		File archivo = new File("./Sesion.dat");
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(archivo));
			writer.write(bd.server + "\n");
			writer.write(bd.user + "\n");
			writer.write(bd.port);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardarInformeHTML(File archivo, ArrayList<Departamento> departamentos, ArrayList<Empleado> empleados)
	{
		if(archivo!=null)
		{
		String htmlFinal="";
		String head = "";
		String body = "";
		String tablaDepartamentos = "";
		String tablaEmpleados = "";
		
		head = "<!DOCTYPE html><html><head><title>Informe</title>	<style>\r\n" + 
				"	table{\r\n" + 
				"		margin:auto;\r\n" + 
				"		padding:10px;\r\n" + 
				"		cellspacing:0px;\r\n" + 
				"		border:none;\r\n" + 
				"		border-collapse:collapse;\r\n" + 
				"		margin-bottom: 20px;\r\n" + 
				"		text-align: center;\r\n" + 
				"	}\r\n" + 
				"	tr:nth-child(odd){\r\n" + 
				"		background-color:lightblue;\r\n" + 
				"	}\r\n" + 
				"	tr:nth-child(even){\r\n" + 
				"		background-color:lightgreen;\r\n" + 
				"	}\r\n" + 
				"	td,th{\r\n" + 
				"		border: 2px solid black;\r\n" + 
				"	}\r\n" + 
				"	h1{		\r\n" + 
				"		text-align:center;\r\n" +  
				"	}\r\n" + 
				"\r\n" + 
				"	</style></head>";
		body = "<body><h1>Informe</h1><p>";
		
		if(departamentos.size()>0)
		{
			tablaDepartamentos=generarHTMLTablaDepart(departamentos);
		}
		if(empleados.size()>0)
		{
			tablaEmpleados=generarHTMLTablaEmple(empleados);
		}

		body+=tablaDepartamentos + tablaEmpleados;
		
		
		htmlFinal = head + body + "</body>";
		try {
		BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
		writer.write(htmlFinal);
		writer.close();
		}catch(IOException e) {e.printStackTrace();}
	}
	}
	
	private String generarHTMLTablaDepart(ArrayList<Departamento> departamentos)
	{
		try {
		String tablaDepartamentos;
		tablaDepartamentos="<table border='1'>";
		tablaDepartamentos+="<tr><th>Cod. Depart</th><th>Nombre</th><th>Edificio</th><th>Ubicación</th></tr>";
		for(int y=0;y<departamentos.size();y++)
		{
			Departamento depart = departamentos.get(y);
			tablaDepartamentos+="<tr><td>" + depart.getCodDepart() +  "</td><td>" + depart.getNombre() +  "</td><td>" + depart.getEdificio() +  "</td><td>" + depart.getUbicacion() +  "</td></tr>";
		}
		tablaDepartamentos+="</table>";
		return tablaDepartamentos;
		}
		catch (NullPointerException ex)
		{
			return "<p>No existen datos de departamentos</p>";
		}
		
	}
	
	private String generarHTMLTablaEmple(ArrayList<Empleado> empleados)
	{
		try {
		String tablaEmpleados;
		tablaEmpleados="<table border='1'>";
		tablaEmpleados+="<tr><th>Cod. Empleado</th><th>Nombre</th><th>Sueldo</th><th>Jefe</th><th>Su jefe</th><th>Puesto</th></tr>";
		for(int y=0;y<empleados.size();y++)
		{
			Empleado empleado = empleados.get(y);
			tablaEmpleados+="<tr><td>" + empleado.getCodEmple() +  "</td><td>" + empleado.getNombre() +  "</td><td>" + empleado.getSueldo() +  "</td><td>" + ceroNoUnoSi(empleado.getJefe()) +  "</td><td>" + obtenerCodNombreEmple(empleado.getSuJefe()) +  "</td><td>" + obtenerCodNombrePuesto(empleado.getPuesto()) +  "</td></tr>";
		}
		tablaEmpleados+="</table>";
		return tablaEmpleados;
		}
		catch(NullPointerException ex)
		{
			return "<p>No existen datos de empleados</p>";
		}
		
	}
	
	private String ceroNoUnoSi(int num)
	{
		if(num==1)
			return "Sí";
		else
			return "No";
	}
	
	private String obtenerCodNombreEmple(int num)
	{
		Empleado emple;
		emple=bd.llamadas.ObtenerEmpleado(num);
		if(emple!=null)
		{
			return "("+emple.getCodEmple() +") " + emple.getNombre();
		}
		else
		{
			return "(" + num + ") Desconocido";
		}
	}
	
	private String obtenerCodNombrePuesto(int num)
	{
		Puesto puesto;
		puesto=bd.llamadas.ObtenerPuesto(num);
		if(puesto!=null)
		{
			return "(" + puesto.getCodPuesto() + ") " + puesto.getNombre();
		}
		else
		{
			return "(" + num + ") Desconocido";
		}
	}
	
	
	
	private void MostrarConsola(String mensaje)
	{
		System.out.println("[Info](Interprete Archivos): " + mensaje);
	}
	
	private void MostrarError(String mensaje)
	{
		System.err.println("[Error](Interprete Archivos): " + mensaje);
	}
}

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
		String htmlFinal="";
		String head = "";
		String body = "";
		
		head = "<!DOCTYPE html><html><head><title>Informe</title></head>";
		body = "<body>aaaa</body></html>";
		htmlFinal = head + body;
		try {
		BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
		writer.write(htmlFinal);
		writer.close();
		}catch(IOException e) {e.printStackTrace();}
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

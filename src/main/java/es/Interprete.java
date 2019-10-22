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
	            		tabla.get(contador).add(i, list[i]);
	            	}
	            	contador++;
	            }
	            lectorArchivos.close();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
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
            int contador=0;
            while ((linea = lectorArchivos.readLine()) != null)
            {
            	if(!(linea.charAt(0)=='#') && !(linea.charAt(0)==' ')) 
            	{
	            	String[] list = linea.split("=");
	            	tabla.add(new ArrayList<String>());
	            	for(int i=0;i<list.length;i++)
	            	{
	            		tabla.get(contador).add(i, list[i]);
	            	}
	            	contador++;
            	}
            }
            lectorArchivos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
			
		   return tabla;
	}
	
	public boolean LeerArchivoConsolaPorExtension(File archivo)
	{
		if(archivo.getPath().endsWith(".txt"))
		{
			System.out.println("[INFO] txt detectado");
			System.out.println(LectorTextoPlano(archivo));
			return true;
		}
		else if (archivo.getPath().endsWith(".csv"))
		{
			System.out.println("[INFO] csv detectado");
			es.consola.ImprimirArray2D(LectorArchivos2D(archivo, ";"));
			return true;
		}
		else if (archivo.getPath().endsWith(".ini"))
		{
			System.out.println("[INFO] ini detectado");
			es.consola.ImprimirArray2D(LectorArchivosINI(archivo));
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*public boolean LeerArchivoGraficoPorExtension(File archivo)
	{
		if(archivo.getPath().endsWith(".txt"))
		{
			System.out.println("[INFO] .txt detectado");
			vista.editorTexto = new EditorTexto();
			vista.editorTexto.EstablecerTexto(LectorTextoPlano(archivo), archivo);
			vista.editorTexto.Mostrar();
			return true;
		}
		else if (archivo.getPath().endsWith(".csv"))
		{
			System.out.println("[INFO] .csv detectado");
			vista.editorTablas = new EditorTablas();
			vista.editorTablas.RellenarCeldas(es.interprete.LectorArchivos2D(archivo,";"), archivo);
			vista.editorTablas.Mostrar();
			return true;
		}
		else if (archivo.getPath().endsWith(".ini"))
		{
			System.out.println("[INFO] .ini detectado");
			vista.editorTablas = new EditorTablas();
			vista.editorTablas.RellenarCeldas(es.interprete.LectorArchivosINI(archivo), archivo);
			vista.editorTablas.Mostrar();
			return true;
		}
		else
		{
			return false;
		}
		return (Boolean) null;
	}*/
	
	
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
}

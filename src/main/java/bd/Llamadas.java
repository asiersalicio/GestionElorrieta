package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import app.Main;
import obj.Departamento;
import obj.Empleado;
import obj.ObjGenerico;
import obj.Puesto;

public class Llamadas extends Main {

	public Llamadas()
	{
		
	}
	
	public void Prueba()
	{
		
		String[] prueba={"1"};
		ResultSet resultado=bd.Llamada("select * from Empleado where cod_emple = ?;", prueba);
		try {
			while(resultado.next())
			{
				System.out.println(resultado.getString("nombre"));
			}
			} catch (SQLException e) {e.printStackTrace();}
		bd.CerrarConexion();

	}
	
	public boolean InsertarPuestos(ArrayList<Puesto> obj)
	{
		
		  String query = "insert into PUESTOS (COD_PUESTO, NOMBRE) values (?, ?);";
	      boolean error=false;
	      try {
	      for(int y=0;y<obj.size();y++)
	      {
	    	  
	    	  String[] setStrings = obj.get(y).toArray();;
	    	  	    	  
	    	  if(bd.LlamadaInsert(query, setStrings)!=0||error)
	    	  {
	    		  error=true;
	    		  break;
	    	  }
	      }
	      }catch (java.lang.IndexOutOfBoundsException ex) {
	    	  MostrarError("Formato de archivo incorrecto");
	    	  error=true;
	      }
	      if(error)
	      {
	    	  MostrarError("Formato de archivo incorrecto, compruebe si el tipo de dato es correcto");
	    	  return false;
	      }
	      else
	    	  return true;
	}
	
	private void MostrarConsola(String mensaje)
	{
		System.out.println("[Info](Llamadas BD): " + mensaje);
	}
	
	private void MostrarError(String mensaje)
	{
		System.err.println("[Error](Llamadas BD): " + mensaje);
	}

	public boolean InsertarDatos(ArrayList<ObjGenerico> obj, String tipoInsert) {
		boolean resul = false;
		Object tipo = obj.get(0);
		if(tipo instanceof Puesto)
		{
			ArrayList<Puesto> puesto = (ArrayList<Puesto>)(ArrayList<?>) (obj);
			resul = InsertarPuestos(puesto);
		}
		else if(tipo instanceof Departamento)
		{
			//resul = InsertarDepartamentos(obj);
		}
		else if(tipo instanceof Empleado)
		{
			//resul = InsertarEmpleado(obj);
		}
		
		try {
			if(resul)
			{
				bd.cn.commit();
			}
			else
			{
				bd.cn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resul;
	}

	private boolean InsertarEmpleado(ArrayList<ArrayList<String>> empleado) {
		String query = "insert into EMPLEADO (COD_EMPLE, NOMBRE, DEPARTAMENTO, SUELDO, JEFE, SU_JEFE, PUESTO) values (?, ?, ?, ?, ?, ?, ?);";
	      boolean error=false;
	      try {
	      for(int y=0;y<empleado.size();y++)
	      {
	    	  ArrayList<String> fila = empleado.get(y);
	    	  String[] setStrings = {fila.get(0),fila.get(1),fila.get(2),fila.get(3),fila.get(4),fila.get(5),fila.get(6)};
	    	  	    	  
	    	  if(bd.LlamadaInsert(query, setStrings)!=0||error)
	    	  {
	    		  error=true;
	    		  break;
	    	  }
	      }
	      }catch (java.lang.IndexOutOfBoundsException ex) {
	    	  MostrarError("Formato de archivo incorrecto");
	    	  error=true;
	      }
	      if(error)
	      {
	    	  MostrarError("Formato de archivo incorrecto, compruebe si el tipo de dato es correcto");
	    	  return false;
	      }
	      else
	    	  return true;
	}

	private boolean InsertarDepartamentos(ArrayList<ArrayList<String>> departamento) {
		String query = "insert into DEPARTAMENTO (COD_DEPART, NOMBRE, EDIFICIO, UBICACION) values (?, ?, ?, ?);";
	      boolean error=false;
	      try {
	      for(int y=0;y<departamento.size();y++)
	      {
	    	  ArrayList<String> fila = departamento.get(y);
	    	  String[] setStrings = {fila.get(0),fila.get(1),fila.get(2),fila.get(3)};
	    	  	    	  
	    	  if(bd.LlamadaInsert(query, setStrings)!=0||error)
	    	  {
	    		  error=true;
	    		  break;
	    	  }
	      }
	      }catch (java.lang.IndexOutOfBoundsException ex) {
	    	  MostrarError("Formato de archivo incorrecto");
	    	  error=true;
	      }
	      if(error)
	      {
	    	  MostrarError("Formato de archivo incorrecto, compruebe si el tipo de dato es correcto");
	    	  try {
				bd.cn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	  return false;
	      }
	      else
	      {
	    	try {
				bd.cn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	  return true;
	      }
	    	  
	}
	
	
	
}

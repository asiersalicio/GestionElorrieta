package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import app.Main;

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
	
	public boolean InsertarPuestosTextoPlano(ArrayList<ArrayList<String>> puestos)
	{
		
		// the mysql insert statement
	      String query = "insert into PUESTOS (COD_PUESTO, NOMBRE) values (?, ?);";
	      boolean error=false;
	      try {
	      for(int y=0;y<puestos.size();y++)
	      {
	    	  System.out.println(puestos.get(y).get(0) + " " + puestos.get(y).get(1));
	    	  String[] setStrings = {puestos.get(y).get(0),puestos.get(y).get(1)};
	    	  	    	  
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
	
	
	
}

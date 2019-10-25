package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public void InsertarPuestosTextoPlano(ArrayList<ArrayList<String>> puestos)
	{
		
		// the mysql insert statement
	      String query = "insert into PUESTOS (COD_PUESTO, NOMBRE) values (?, ?);";

	      for(int y=0;y<puestos.size();y++)
	      {
	    	  String[] setStrings = {puestos.get(y).get(0),puestos.get(y).get(1)};
	    	  bd.LlamadaInsert(query, setStrings);
	      }
	      
		
	}
	
	
	
	
}

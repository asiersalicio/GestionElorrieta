package bd;

import java.sql.ResultSet;
import java.sql.SQLException;

import app.Main;

public class Selects extends Main {

	public Selects()
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
	
	
}

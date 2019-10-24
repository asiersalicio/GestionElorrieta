package bd;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

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
	
	public void ComprobarVacio()
	{

		String[] prueba = {};
		try {
		ResultSet resultado = bd.Llamada("select * from empleado;", prueba);
		
			if (resultado.next()) {
				System.out.println("Existe");
			}
		} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
			System.out.println("No existe");;
		} catch (SQLException e) {
			System.out.println("No existe");
		}
		bd.CerrarConexion();

	}
	
	
}

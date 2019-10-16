package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public Connection cn;
	
	public Conexion()
	{
		
	}
	
	public void Conectar(String server, String user, String pass)
	{
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		  //Connection cn = DriverManager.getConnection("jdbc:mysql://servidor_bd:puerto/nombre_bd", "usuario", "contraseña");
		    String dirbd = "jdbc:mysql://" + server +":3306/Elorrieta";
		    MostrarConsola("Intentando conectar a la base de datos: " + dirbd);
		    cn = DriverManager.getConnection(dirbd, user, pass);
		    MostrarConsola("¡Conexión exitosa!");
		} catch (ClassNotFoundException ex) {
		    MostrarError("No se encontro el Driver MySQL para JDBC.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			MostrarError("No se puede conectar a la base de datos CodErr: " + e.getErrorCode());
		}
	}
	
	
	private void MostrarConsola(String mensaje)
	{
		System.out.println("[Info](Conexión BD): " + mensaje);
	}
	
	private void MostrarError(String mensaje)
	{
		System.err.println("[Error](Conexión BD): " + mensaje);
	}

	public void CerrarConexion() {
		try {
			MostrarConsola("Cerrando la conexion");
			cn.close();
		} catch (SQLException e) {
			MostrarError("No se puede cerrar la conexion a la base de datos CodErr: " + e.getErrorCode());
		}		
	}
}

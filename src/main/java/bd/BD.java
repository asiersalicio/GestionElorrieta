package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import app.Main;

public class BD {

	public Connection cn;
	
	private String server;
	private String user;
	private String pass;
	private String port;
	
	
	public BD()
	{
		
	}
	
	public void EstablecerDatos(String server, String user, String pass, String port) {
		this.server=server;
		this.user=user;
		this.pass=pass;
		this.port=port;
	}
	
	public int Conectar()
	{
		if(server==null || user==null || pass==null || port==null)
		{
			Main.vista.MostrarIniciarSesion();
		}
		else
		{
			try {
			    Class.forName("com.mysql.jdbc.Driver");
			  //Connection cn = DriverManager.getConnection("jdbc:mysql://servidor_bd:puerto/nombre_bd", "usuario", "contrase�a");
			    String dirbd = "jdbc:mysql://" + server +":"+ port + "/Elorrieta";
			    MostrarConsola("Intentando conectar a la base de datos: " + dirbd);
			    cn = DriverManager.getConnection(dirbd, user, pass);
			    MostrarConsola("¡Conexión exitosa!");
			    return 0;
			} catch (ClassNotFoundException ex) {
			    MostrarError("No se encontro el Driver MySQL para JDBC.");
			    return 2;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				MostrarError("No se puede conectar a la base de datos CodErr: (" + e.getErrorCode() + ") " + e.getMessage());
				if(e.getErrorCode()==0)
					return 3;
				else
					return 1;
			}
		}
		return -1;
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
		} catch (NullPointerException e) {
			MostrarConsola("La conexión ya estaba cerrada");
		}
	}
	
}

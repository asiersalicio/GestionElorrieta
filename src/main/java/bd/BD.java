package bd;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.Main;

public class BD extends Main {

	public Connection cn;
	public Llamadas llamadas;
	
	public String server;
	public String user;
	private String pass;
	public String port;
	
	public BD()
	{
		llamadas = new Llamadas();
	}
	
	public void EstablecerDatos(String server, String user, String pass, String port) {
		this.server=server;
		this.user=user;
		this.pass=pass;
		this.port=port;
	}
	
	public void EstablecerDatos(String[] datosInicioSesion) {
		try{
			EstablecerDatos(datosInicioSesion[0], datosInicioSesion[1], null, datosInicioSesion[2]);
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
			MostrarError("Formato de archivo de 'Datos.dat' incorrecto, ignorando archivo");
			EstablecerDatos(null, null, null, null);
		}
	}
	
	public int Conectar()
	{
		if(server==null || user==null || pass==null || port==null)
		{
			vista.MostrarIniciarSesion();
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
			    es.interprete.GuardarDatosInicioSesion();
			    return 0;
			} catch (ClassNotFoundException ex) {
			    MostrarError("No se encontro el Driver MySQL para JDBC.");
			    return 2;
			} catch (SQLException e) {
				MostrarError("No se puede conectar a la base de datos CodErr: (" + e.getErrorCode() + ") " + e.getMessage());
				if(e.getErrorCode()==0)
					return 3;
				else
					return 1;
			}
		}
		return -1;
	}
		
	public ResultSet Llamada(String query, String[] setStrings)
	{
		ResultSet rs = null;
		try {
			Conectar();
			PreparedStatement pstatment = cn.prepareStatement(query);
			for(int i=0;i<setStrings.length;i++)
			{
				pstatment.setString(i+1, setStrings[i]);
			}
		    rs = pstatment.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int LlamadaInsert(String query, String[] setStrings)
	{
		int rs = 0;
		try {
			Conectar();
			PreparedStatement pstatment = cn.prepareStatement(query);
			for(int i=0;i<setStrings.length;i++)
			{
				pstatment.setString(i+1, setStrings[i]);
			}
		    rs = pstatment.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
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
	
	public boolean ComprobarVacio()
	{
		ResultSet tables = null;
		DatabaseMetaData dbm = null;
		try {
			dbm = cn.getMetaData();
			tables = dbm.getTables(null, null, "aaaaDEPARTAMENTO", null);
			if (tables.next()) {
				return true;
			}
			else {
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	
	
}

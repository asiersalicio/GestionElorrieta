package vista;

import app.Main;
import vista.controladores.CIniciarSesion;

public class Vista extends Main {
	
	public CIniciarSesion iniciarSesion;
	
	public Vista()
	{
		
	}
	
	public void MostrarIniciarSesion()
	{
		MostrarMensaje("Iniciando ventana iniciar sesión");
		iniciarSesion = new CIniciarSesion();
		iniciarSesion.Mostrar();
	}
	
	private void MostrarMensaje(String mensaje)
	{
		System.out.println("[Info](Vista): " + mensaje);
	}
	
	public void CerrarVentanas()
	{
		MostrarMensaje("Cerrando ventanas");
		iniciarSesion.ventana.dispose();
		iniciarSesion=null;
	}

}

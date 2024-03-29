package vista;

import app.Main;
import vista.controladores.CIniciarSesion;
import vista.controladores.CMenu;

public class Vista extends Main {
	
	public CIniciarSesion iniciarSesion;
	public CMenu menu;
	
	public Vista()
	{
		
	}
	
	public void MostrarIniciarSesion()
	{
		MostrarMensaje("Iniciando ventana iniciar sesi�n");
		iniciarSesion = new CIniciarSesion();
		iniciarSesion.Mostrar();
	}
	
	public void MostrarMenu()
	{
		MostrarMensaje("Iniciando ventana iniciar sesi�n");
		menu = new CMenu();
		menu.Mostrar();
	}
	
	private void MostrarMensaje(String mensaje)
	{
		System.out.println("[Info](Vista): " + mensaje);
	}
	
	public void CerrarVentanas()
	{
		MostrarMensaje("Cerrando ventanas");
		iniciarSesion=null;
		menu=null;
	}

}

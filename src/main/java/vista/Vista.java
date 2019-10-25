package vista;

import app.Main;
import vista.controladores.CEditorTablas;
import vista.controladores.CIniciarSesion;
import vista.controladores.CMenu;

public class Vista extends Main {
	
	public CIniciarSesion iniciarSesion;
	public CMenu menu;
	public CEditorTablas editorTablas;
	
	public Vista()
	{
		
	}
	
	public void MostrarIniciarSesion()
	{
		MostrarMensaje("Iniciando ventana iniciar sesión");
		iniciarSesion = new CIniciarSesion();
		iniciarSesion.Mostrar();
	}
	
	public void MostrarMenu()
	{
		MostrarMensaje("Iniciando ventana iniciar sesión");
		menu = new CMenu();
		menu.Mostrar();
	}
	
	public void CrearEditorTablas()
	{
		MostrarMensaje("Iniciando editor tablas");
		editorTablas = new CEditorTablas();
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

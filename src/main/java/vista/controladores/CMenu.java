package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import app.Main;
import vista.graficos.GMenu;
import vista.graficos.GMenuDepartamentos;
import vista.graficos.GMenuEmpleados;
import vista.graficos.GMenuInformes;
import vista.graficos.GMenuPrincipal;

public class CMenu extends GMenu {


	public CMenu()
	{
		AnadirPestanas();
		AnadirListeners();
	}
	
	private void AnadirPestanas() {
		new CMenuPrincipal(tabbedPane);
		new CMenuDepartamentos(tabbedPane);
		new CMenuEmpleados(tabbedPane);
		new CMenuInformes(tabbedPane);
	}

	private void AnadirListeners() {
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MostrarMensaje("Cerrando aplicaci�n");
				CerrarAplicacion();
				
			}
		});	
		
		ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	MostrarMensaje("Cerrando aplicaci�n");
				CerrarAplicacion();
            }
        });
	}

	public void Mostrar() {
		ventana.setVisible(true);
		
	}
	
	public void MostrarMensaje(String mensaje)
	{
		System.out.println("[Info](Menu) " + mensaje);
	}

}

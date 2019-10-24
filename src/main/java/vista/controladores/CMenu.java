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
import vista.graficos.GPestana;

public class CMenu extends GMenu {

	public ArrayList<GPestana> pestanas = new ArrayList<GPestana>();
	
	public CMenu()
	{
		AnadirPestanas();
		AnadirListeners();
	}
	
	private void AnadirPestanas() {
		pestanas.add(new CMenuPrincipal(tabbedPane));
		pestanas.add(new CMenuDepartamentos(tabbedPane));
		pestanas.add(new CMenuEmpleados(tabbedPane));
		pestanas.add(new CMenuInformes(tabbedPane));
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

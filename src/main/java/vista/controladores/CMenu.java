package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import app.Main;
import vista.graficos.GMenu;

public class CMenu extends GMenu {

	public CMenu()
	{
		AnadirListeners();
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

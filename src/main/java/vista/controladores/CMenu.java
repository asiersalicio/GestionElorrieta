package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import obj.Reloj;
import vista.graficos.GMenu;
import vista.graficos.GPestana;

public class CMenu extends GMenu {

	public ArrayList<GPestana> pestanas = new ArrayList<GPestana>();
	
	public CMenu()
	{
		AnadirPestanas();
		AnadirListeners();
		IniciarReloj();
	}
	
	private void IniciarReloj() {
		Reloj reloj = new Reloj(lblReloj);
		reloj.start();
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
		
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				pestanas.get(tabbedPane.getSelectedIndex()).AbrirPestana();
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

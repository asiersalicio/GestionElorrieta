package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

import vista.graficos.GMenuPrincipal;

public class CMenuPrincipal extends GMenuPrincipal {

	public CMenuPrincipal(JTabbedPane tabbedPane) {
		super(tabbedPane);
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bd.ComprobarVacio();
				
			}
		});
	}

}

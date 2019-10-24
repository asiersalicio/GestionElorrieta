package vista.graficos;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

public class GMenuPrincipal extends GPestana {
	
	public JButton boton;

	public GMenuPrincipal(JTabbedPane tabbedPane) {
		super(tabbedPane, "Principal", null);
		boton = new JButton("Comprobar si existe tablas");
		panel.add(boton);
	}
	
}

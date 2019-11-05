package vista.graficos;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import vista.Vista;

public class GPestana extends Vista {

	protected JTabbedPane tabbedPane;
	protected String nombre;
	protected ImageIcon icono;
	protected JPanel panel;
	
	public GPestana(JTabbedPane tabbedPane, String nombre, ImageIcon icono)
	{
		this.tabbedPane=tabbedPane;
		this.nombre=nombre;
		this.icono=icono;
		panel = new JPanel();
		tabbedPane.addTab(nombre, icono, panel, null);
	}
	
	public void AbrirPestana()
	{
		
	}
}

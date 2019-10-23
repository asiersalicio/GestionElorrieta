package vista.graficos;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GMenuEmpleados extends GPestana {


	public JPanel panel;

	public GMenuEmpleados(JTabbedPane tabbedPane)
	{
		super(tabbedPane, "Empleados", new ImageIcon(GMenu.class.getResource("/res/empleados.jpg")));
	}
	
}

package vista.graficos;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GMenuDepartamentos extends GPestana {

	public JPanel panel;
	
	public GMenuDepartamentos(JTabbedPane tabbedpane)
	{
		super(tabbedpane, "Departamentos", new ImageIcon(GMenu.class.getResource("/res/escritorio.jpg")));
	}
	
}

package vista.graficos;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import app.Main;

public class GMenuDepartamentos extends Main {

	public JPanel panel;
	
	public GMenuDepartamentos(JTabbedPane tabbedpane)
	{
		panel = new JPanel();
		ImageIcon escritorio = new ImageIcon(GMenu.class.getResource("/res/escritorio.jpg"));
		tabbedpane.addTab("Departamentos", escritorio, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
	}
	
}

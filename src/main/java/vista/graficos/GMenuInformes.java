package vista.graficos;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GMenuInformes extends GPestana {

	
	public GMenuInformes(JTabbedPane tabbedPane) {
		super(tabbedPane, "Informes", new ImageIcon(GMenu.class.getResource("/res/informes.jpg")));
	}
	
}

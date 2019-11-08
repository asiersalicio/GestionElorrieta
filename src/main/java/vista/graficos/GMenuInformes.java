package vista.graficos;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class GMenuInformes extends GPestana {

	
	public GMenuInformes(JTabbedPane tabbedPane) {
		super(tabbedPane, "Informes", new ImageIcon(GMenu.class.getResource("/res/informes.jpg")));
		JPanel panel = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
	}
	
}

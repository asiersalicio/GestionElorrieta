package vista.graficos;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class GMenuInformes extends GPestana {

	
	public GMenuInformes(JTabbedPane tabbedPane) {
		super(tabbedPane, "Informes", new ImageIcon(GMenu.class.getResource("/res/informes.jpg")));
		//JPanel panel = new JPanel();
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				es.interprete.guardarInformeHTML(new File(".\\Informe.html"), bd.llamadas.obtenerDepartamentos(), bd.llamadas.obtenerEmpleados());
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(160)
					.addComponent(btnNewButton)
					.addContainerGap(201, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(92)
					.addComponent(btnNewButton)
					.addContainerGap(185, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}

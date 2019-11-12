package vista.graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;

public class GMenuInformes extends GPestana {

	public JButton btnGenerarInforme;
	public JCheckBox chckbxEmpleados;
	public JCheckBox chckbxDepartamentos;
	
	public GMenuInformes(JTabbedPane tabbedPane) {
		super(tabbedPane, "Informes", new ImageIcon(GMenu.class.getResource("/res/informes.jpg")));
		//JPanel panel = new JPanel();
		
		btnGenerarInforme = new JButton("Generar Informe");
		
		
		chckbxEmpleados = new JCheckBox("Empleados");
		
		chckbxDepartamentos = new JCheckBox("Departamentos");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(540, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxDepartamentos)
						.addComponent(chckbxEmpleados)
						.addComponent(btnGenerarInforme))
					.addGap(32))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(354, Short.MAX_VALUE)
					.addComponent(chckbxDepartamentos)
					.addGap(18)
					.addComponent(chckbxEmpleados)
					.addGap(18)
					.addComponent(btnGenerarInforme)
					.addGap(28))
		);
		panel.setLayout(gl_panel);
	}
}

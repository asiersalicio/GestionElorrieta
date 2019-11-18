package vista.graficos;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;

public class GMenuInformes extends GPestana {

	public JButton btnGenerarInforme;
	public JCheckBox chckbxEmpleados;
	public JCheckBox chckbxDepartamentos;
	
	public GMenuInformes(JTabbedPane tabbedPane) {
		super(tabbedPane, "Informes", new ImageIcon(GMenu.class.getResource("/res/informes.jpg")));
		//JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		btnGenerarInforme = new JButton("Generar Informe");
		
		
		chckbxEmpleados = new JCheckBox("Empleados");
		chckbxEmpleados.setBackground(new Color(255, 255, 255));
		
		chckbxDepartamentos = new JCheckBox("Departamentos");
		chckbxDepartamentos.setBackground(new Color(255, 255, 255));
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

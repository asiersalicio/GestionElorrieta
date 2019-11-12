package vista.graficos;

import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GMenuPrincipal extends GPestana {
	
	public JButton boton, btnIrDepartamentos, btnIrEmpleados, btnAcercaDe, btnIrInformes;
	public JLabel lblUser;

	public GMenuPrincipal(JTabbedPane tabbedPane) {
		super(tabbedPane, "Principal", null);
		//JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(GMenuPrincipal.class.getResource("/res/Logo.jpg")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
					.addComponent(lblLogo)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLogo))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setBounds(10, 11, 369, 87);
		panel_1.add(lblBienvenido);
		
		JLabel lblTeHasConectado = new JLabel("Te has conectado con el usuario: ");
		lblTeHasConectado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTeHasConectado.setBounds(10, 109, 186, 27);
		panel_1.add(lblTeHasConectado);
		
		JLabel lblUser = new JLabel("");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUser.setBounds(193, 109, 186, 27);
		panel_1.add(lblUser);
		
		btnIrDepartamentos = new JButton("Ir a Departamentos");
		btnIrDepartamentos.setBounds(10, 183, 148, 87);
		panel_1.add(btnIrDepartamentos);
		
		btnIrEmpleados = new JButton("Ir a Empleados");
		btnIrEmpleados.setBounds(231, 183, 148, 87);
		panel_1.add(btnIrEmpleados);
		
		btnAcercaDe = new JButton("Acerca de...");
		btnAcercaDe.setBounds(10, 11, 93, 32);
		panel_1.add(btnAcercaDe);
		
		btnIrInformes = new JButton("Ir a Informes");
		btnIrInformes.setBounds(10, 281, 148, 87);
		panel_1.add(btnIrInformes);
		panel.setLayout(gl_panel);
	}
}

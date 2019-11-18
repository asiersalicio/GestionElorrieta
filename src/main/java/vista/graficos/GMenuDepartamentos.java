package vista.graficos;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;

public class GMenuDepartamentos extends GPestana {
	public JTextField fieldEdificio, fieldNomDepart, fieldCodDepart;
	public JComboBox comboUbicacion;
	public JLabel lblCodDepart, lblNomDepart, lblUbicacion, lblEdificio;
	public JButton btnAnterior, btnSiguiente;
	public JButton btnCrearDepartamento;


	
	public GMenuDepartamentos(JTabbedPane tabbedpane)
	{
		super(tabbedpane, "Departamentos", new ImageIcon(GMenu.class.getResource("/res/escritorio.jpg")));
		//JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1 = new JLabel("Hubicación");
		String[] datos = {"Elorrieta", "Errekamari"};
		
		JButton btnVolver = new JButton("Volver");
		
		JButton btnRegistrar = new JButton("Registrar");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		btnCrearDepartamento = new JButton("Crear Departamento");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
					.addComponent(btnCrearDepartamento, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(73)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(84)
							.addComponent(btnCrearDepartamento, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		panel_1.setLayout(null);
		comboUbicacion = new JComboBox(datos);
		comboUbicacion.setEditable(true);
		comboUbicacion.setBounds(217, 115, 76, 20);
		panel_1.add(comboUbicacion);
		
		fieldEdificio = new JTextField();
		fieldEdificio.setEditable(false);
		fieldEdificio.setBounds(207, 84, 86, 20);
		panel_1.add(fieldEdificio);
		fieldEdificio.setColumns(10);
		
		fieldNomDepart = new JTextField();
		fieldNomDepart.setEditable(false);
		fieldNomDepart.setBounds(207, 54, 86, 20);
		panel_1.add(fieldNomDepart);
		fieldNomDepart.setColumns(10);
		
		fieldCodDepart = new JTextField();
		fieldCodDepart.setEditable(false);
		fieldCodDepart.setBounds(207, 23, 86, 20);
		panel_1.add(fieldCodDepart);
		fieldCodDepart.setColumns(10);
		
		lblCodDepart = new JLabel("C\u00F3digo departamento");
		lblCodDepart.setBounds(30, 26, 125, 14);
		panel_1.add(lblCodDepart);
		
		lblNomDepart = new JLabel("Nombre del departamento");
		lblNomDepart.setBounds(30, 59, 167, 14);
		panel_1.add(lblNomDepart);
		
		lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setBounds(30, 118, 167, 14);
		panel_1.add(lblUbicacion);
		
		lblEdificio = new JLabel("Edificio");
		lblEdificio.setBounds(30, 90, 167, 14);
		panel_1.add(lblEdificio);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(66, 155, 89, 23);
		panel_1.add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(160, 155, 89, 23);
		panel_1.add(btnSiguiente);
		panel.setLayout(gl_panel);
		
	}
}

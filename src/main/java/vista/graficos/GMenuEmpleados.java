package vista.graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class GMenuEmpleados extends GPestana {
	public JTextField textField;
	public JButton nuevo;
	public JComboBox comboBox ;
	public JButton buscar ;
	public JPanel menuEmple;
	public JTextField fieldDepartamento, fieldNombre, fieldCodEmple;
	public JLabel lblCodDepart, lblNomDepart, lblUbicacion, lblEdificio;
	public JButton btnAnterior, btnSiguiente;
	public JTextField fieldSueldo;
	public JLabel dsf;
	public JTextField esJefe;
	public JLabel lblNewLabel;
	public JTextField fieldSuJefe;
	public JLabel lblNewLabel_1;
	public JTextField fieldPuesto;



	public GMenuEmpleados(JTabbedPane tabbedPane)
	{
		super(tabbedPane, "Empleados", new ImageIcon(GMenu.class.getResource("/res/empleados.jpg")));
		//JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		 
		  menuEmple = new JPanel();
		  menuEmple.setBackground(new Color(255, 255, 255));
		 GroupLayout gl_panel = new GroupLayout(panel);
		 gl_panel.setHorizontalGroup(
		 	gl_panel.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_panel.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(menuEmple, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE)
		 			.addContainerGap(142, Short.MAX_VALUE))
		 );
		 gl_panel.setVerticalGroup(
		 	gl_panel.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_panel.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(menuEmple, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
		 			.addContainerGap(43, Short.MAX_VALUE))
		 );
		 menuEmple.setLayout(null);
		 
		  nuevo = new JButton("Nuevo Empleado");
		 nuevo.setBounds(132, 11, 146, 23);
		 menuEmple.add(nuevo);
		 
		  comboBox = new JComboBox();
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3digo", "Nombre"}));
		 comboBox.setBounds(37, 63, 64, 20);
		 menuEmple.add(comboBox);
		 
		 textField = new JTextField();
		 textField.setBounds(132, 63, 146, 20);
		 menuEmple.add(textField);
		 textField.setColumns(10);
		 
		  buscar = new JButton("Buscar");
		 buscar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	}
		 });
		 buscar.setBounds(288, 62, 89, 23);
		 menuEmple.add(buscar);
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setBackground(new Color(255, 255, 255));
		 panel_1.setBounds(47, 94, 511, 333);
		 menuEmple.add(panel_1);
		 panel.setLayout(gl_panel);
		 panel_1.setLayout(null);
			
			fieldDepartamento = new JTextField();
			fieldDepartamento.setEditable(false);
			fieldDepartamento.setBounds(207, 84, 160, 20);
			panel_1.add(fieldDepartamento);
			fieldDepartamento.setColumns(10);
			
			fieldNombre = new JTextField();
			fieldNombre.setEditable(false);
			fieldNombre.setBounds(207, 54, 160, 20);
			panel_1.add(fieldNombre);
			fieldNombre.setColumns(10);
			
			fieldCodEmple = new JTextField();
			fieldCodEmple.setEditable(false);
			fieldCodEmple.setBounds(207, 23, 160, 20);
			panel_1.add(fieldCodEmple);
			fieldCodEmple.setColumns(10);
			
			lblCodDepart = new JLabel("C\u00F3digo empreado");
			lblCodDepart.setBounds(30, 26, 125, 14);
			panel_1.add(lblCodDepart);
			
			lblNomDepart = new JLabel("Nombre del empleado");
			lblNomDepart.setBounds(30, 59, 167, 14);
			panel_1.add(lblNomDepart);
			
			lblUbicacion = new JLabel("Sueldo");
			lblUbicacion.setBounds(30, 118, 167, 14);
			panel_1.add(lblUbicacion);
			
			lblEdificio = new JLabel("Departamento");
			lblEdificio.setBounds(30, 90, 167, 14);
			panel_1.add(lblEdificio);
			
			btnAnterior = new JButton("Anterior");
			btnAnterior.setBounds(94, 265, 89, 23);
			panel_1.add(btnAnterior);
			
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setBounds(193, 265, 89, 23);
			panel_1.add(btnSiguiente);
			
			fieldSueldo = new JTextField();
			fieldSueldo.setEditable(false);
			fieldSueldo.setBounds(207, 115, 86, 20);
			panel_1.add(fieldSueldo);
			fieldSueldo.setColumns(10);
			
			dsf = new JLabel("Es Jefe");
			dsf.setBounds(30, 155, 46, 14);
			panel_1.add(dsf);
			
			esJefe = new JTextField();
			esJefe.setEditable(false);
			esJefe.setBounds(207, 152, 86, 20);
			panel_1.add(esJefe);
			esJefe.setColumns(10);
			
			lblNewLabel = new JLabel("Su jefe");
			lblNewLabel.setBounds(30, 186, 46, 14);
			panel_1.add(lblNewLabel);
			
			fieldSuJefe = new JTextField();
			fieldSuJefe.setEditable(false);
			fieldSuJefe.setBounds(207, 183, 86, 20);
			panel_1.add(fieldSuJefe);
			fieldSuJefe.setColumns(10);
			
			lblNewLabel_1 = new JLabel("Puesto");
			lblNewLabel_1.setBounds(30, 221, 46, 14);
			panel_1.add(lblNewLabel_1);
			
			fieldPuesto = new JTextField();
			fieldPuesto.setEditable(false);
			fieldPuesto.setBounds(207, 221, 86, 20);
			panel_1.add(fieldPuesto);
			fieldPuesto.setColumns(10);
			panel.setLayout(gl_panel);
		
	}
}

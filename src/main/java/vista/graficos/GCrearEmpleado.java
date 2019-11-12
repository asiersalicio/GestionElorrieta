
package vista.graficos;

import java.awt.Window.Type;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import app.Main;
import java.awt.Color;
import java.awt.Font;

public class GCrearEmpleado extends Main{

	public JDialog frame;
	public JTextField fieldNombEmple;
	public JButton btnAceptar;
	public JSpinner spnCodDepart;
	public JComboBox<String> comboDepart;
	public JLabel lblError;
	public JTextField fieldSueldo;
	public JLabel lblSuJefe;
	public JComboBox comboSuJefe, comboJefe;
	public JLabel lblPuesto;
	public JComboBox comboPuesto;
	
	public GCrearEmpleado()
	{
		frame = new JDialog();
		frame.setSize(300, 340);
		frame.setTitle("Crear nuevo departamento");
		frame.setType(Type.UTILITY);
		frame.setModal(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(10, 272, 89, 23);
		frame.getContentPane().add(btnAceptar);
		
		JLabel lblCodEmple = new JLabel("C\u00F3digo Empleado");
		lblCodEmple.setBounds(34, 15, 120, 14);
		frame.getContentPane().add(lblCodEmple);
		
		JLabel lblNomEmple = new JLabel("Nombre Empleado");
		lblNomEmple.setBounds(34, 50, 120, 14);
		frame.getContentPane().add(lblNomEmple);
		
		fieldNombEmple = new JTextField();
		fieldNombEmple.setBounds(175, 45, 100, 24);
		frame.getContentPane().add(fieldNombEmple);
		fieldNombEmple.setColumns(10);
		
		spnCodDepart = new JSpinner();
		spnCodDepart.setEnabled(false);
		spnCodDepart.setBounds(175, 11, 100, 23);
		frame.getContentPane().add(spnCodDepart);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(34, 84, 120, 14);
		frame.getContentPane().add(lblDepartamento);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(34, 118, 120, 14);
		frame.getContentPane().add(lblSueldo);
		
		comboDepart = new JComboBox();
		comboDepart.setToolTipText("");
		/*
		comboDepart.addItem(new Item(1, "a"));
		comboDepart.addItem(new Item(2, "b"));
		comboDepart.addItem(new Item(3, "c"));
		comboDepart.setMaximumRowCount(3);
		*/
		comboDepart.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboDepart.setBounds(175, 80, 100, 23);
		frame.getContentPane().add(comboDepart);
		
		lblError = new JLabel("Error");
		lblError.setVisible(false);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblError.setForeground(Color.RED);
		lblError.setBounds(109, 276, 170, 14);
		frame.getContentPane().add(lblError);
		
		fieldSueldo = new JTextField();
		fieldSueldo.setColumns(10);
		fieldSueldo.setBounds(175, 115, 100, 24);
		frame.getContentPane().add(fieldSueldo);
		
		JLabel lblJefe = new JLabel("Es jefe");
		lblJefe.setBounds(34, 154, 120, 14);
		frame.getContentPane().add(lblJefe);
		
		comboJefe = new JComboBox();
		comboJefe.setModel(new DefaultComboBoxModel(new String[] {"0", "1"}));
		comboJefe.setToolTipText("");
		comboJefe.setBounds(175, 150, 100, 23);
		frame.getContentPane().add(comboJefe);
		
		lblSuJefe = new JLabel("Su jefe");
		lblSuJefe.setBounds(34, 196, 120, 14);
		frame.getContentPane().add(lblSuJefe);
		
		comboSuJefe = new JComboBox();
		comboSuJefe.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboSuJefe.setToolTipText("");
		comboSuJefe.setBounds(175, 193, 100, 23);
		frame.getContentPane().add(comboSuJefe);
		
		lblPuesto = new JLabel("Puesto");
		lblPuesto.setBounds(34, 235, 120, 14);
		frame.getContentPane().add(lblPuesto);
		
		comboPuesto = new JComboBox();
		comboPuesto.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboPuesto.setToolTipText("");
		comboPuesto.setBounds(175, 232, 100, 23);
		frame.getContentPane().add(comboPuesto);
	}
}

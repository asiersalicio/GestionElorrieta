package vista.graficos;

import javax.swing.JDialog;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GCrearDepartamento {

	public JDialog frame;
	private JTextField fieldDepart;
	
	public GCrearDepartamento()
	{
		frame = new JDialog();
		frame.setSize(300, 230);
		frame.setTitle("Crear nuevo departamento");
		frame.setType(Type.UTILITY);
		frame.setModal(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(10, 157, 89, 23);
		frame.getContentPane().add(btnAceptar);
		
		JLabel lblCodDepart = new JLabel("C\u00F3digo Departamento");
		lblCodDepart.setBounds(34, 15, 120, 14);
		frame.getContentPane().add(lblCodDepart);
		
		JLabel lblNomDepart = new JLabel("Nombre Departamento");
		lblNomDepart.setBounds(34, 50, 120, 14);
		frame.getContentPane().add(lblNomDepart);
		
		fieldDepart = new JTextField();
		fieldDepart.setBounds(175, 45, 100, 24);
		frame.getContentPane().add(fieldDepart);
		fieldDepart.setColumns(10);
		
		JSpinner spnCodDepart = new JSpinner();
		spnCodDepart.setEnabled(false);
		spnCodDepart.setBounds(175, 11, 100, 23);
		frame.getContentPane().add(spnCodDepart);
		
		JLabel lblEdificio = new JLabel("Edificio");
		lblEdificio.setBounds(34, 84, 120, 14);
		frame.getContentPane().add(lblEdificio);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setBounds(34, 118, 120, 14);
		frame.getContentPane().add(lblUbicacion);
		
		JComboBox comboEdifcio = new JComboBox();
		comboEdifcio.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboEdifcio.setBounds(175, 80, 100, 23);
		frame.getContentPane().add(comboEdifcio);
		
		JComboBox comboUbicacion = new JComboBox();
		comboUbicacion.setModel(new DefaultComboBoxModel(new String[] {"Elorrieta", "Errekamari"}));
		comboUbicacion.setBounds(175, 114, 100, 23);
		frame.getContentPane().add(comboUbicacion);
	}
}

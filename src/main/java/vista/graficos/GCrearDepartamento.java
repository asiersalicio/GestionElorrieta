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

public class GCrearDepartamento extends Main{

	public JDialog frame;
	public JTextField fieldNombDepart;
	public JButton btnAceptar;
	public JSpinner spnCodDepart;
	public JComboBox<String> comboEdifcio;
	public JComboBox<String> comboUbicacion;
	public JLabel lblError;
	
	public GCrearDepartamento()
	{
		frame = new JDialog();
		frame.setSize(300, 230);
		frame.setTitle("Crear nuevo departamento");
		frame.setType(Type.UTILITY);
		frame.setModal(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(10, 157, 89, 23);
		frame.getContentPane().add(btnAceptar);
		
		JLabel lblCodDepart = new JLabel("C\u00F3digo Departamento");
		lblCodDepart.setBounds(34, 15, 120, 14);
		frame.getContentPane().add(lblCodDepart);
		
		JLabel lblNomDepart = new JLabel("Nombre Departamento");
		lblNomDepart.setBounds(34, 50, 120, 14);
		frame.getContentPane().add(lblNomDepart);
		
		fieldNombDepart = new JTextField();
		fieldNombDepart.setBounds(175, 45, 100, 24);
		frame.getContentPane().add(fieldNombDepart);
		fieldNombDepart.setColumns(10);
		
		spnCodDepart = new JSpinner();
		spnCodDepart.setEnabled(false);
		spnCodDepart.setBounds(175, 11, 100, 23);
		frame.getContentPane().add(spnCodDepart);
		
		JLabel lblEdificio = new JLabel("Edificio");
		lblEdificio.setBounds(34, 84, 120, 14);
		frame.getContentPane().add(lblEdificio);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setBounds(34, 118, 120, 14);
		frame.getContentPane().add(lblUbicacion);
		
		comboEdifcio = new JComboBox();
		comboEdifcio.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboEdifcio.setBounds(175, 80, 100, 23);
		frame.getContentPane().add(comboEdifcio);
		
		comboUbicacion = new JComboBox();
		comboUbicacion.setModel(new DefaultComboBoxModel(new String[] {"Elorrieta", "Errekamari"}));
		comboUbicacion.setBounds(175, 114, 100, 23);
		frame.getContentPane().add(comboUbicacion);
		
		lblError = new JLabel("Error");
		lblError.setVisible(false);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblError.setForeground(Color.RED);
		lblError.setBounds(105, 161, 170, 14);
		frame.getContentPane().add(lblError);
	}
}

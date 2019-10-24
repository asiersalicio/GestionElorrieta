package vista.graficos;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GMenuDepartamentos extends GPestana {


	
	public GMenuDepartamentos(JTabbedPane tabbedpane)
	{
		super(tabbedpane, "Departamentos", new ImageIcon(GMenu.class.getResource("/res/escritorio.jpg")));
		
		
		JLabel lblNombreDelDepartamento = new JLabel("Nombre del departamento");
		
		JTextField textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Edificio");
		
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Hubicación");
		JList list = new JList();
		String[] datos = {"Elorrieta", "Errekamari"};
		JComboBox comboBox = new JComboBox(datos);
		
		JButton btnVolver = new JButton("Volver");
		
		JButton btnRegistrar = new JButton("Registrar");
		
		panel.add(lblNombreDelDepartamento);
		panel.add(textField);
		panel.add(textField_1);
		panel.add(lblNewLabel);
		panel.add(list);
		panel.add(comboBox);
		
	}
	
}

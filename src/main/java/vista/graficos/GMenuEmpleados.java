package vista.graficos;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class GMenuEmpleados extends GPestana {



	public GMenuEmpleados(JTabbedPane tabbedPane)
	{
		super(tabbedPane, "Empleados", new ImageIcon(GMenu.class.getResource("/res/empleados.jpg")));
		
		JButton btnNuevoEmpleado = new JButton("Nuevo empleado");
		panel.add(btnNuevoEmpleado);
			
		JTextField textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblBuscar = new JLabel("Buscar");
		panel.add(lblBuscar);
	}
	
}

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

public class GMenuEmpleados extends GPestana {
	public JTextField textField;
	public JButton nuevo;
	public JComboBox comboBox ;
	public JButton buscar ;
	public JTextPane textPane ;
	



	public GMenuEmpleados(JTabbedPane tabbedPane)
	{
		super(tabbedPane, "Empleados", new ImageIcon(GMenu.class.getResource("/res/empleados.jpg")));
		 JPanel panel = new JPanel();
		 
		 JPanel panel_1 = new JPanel();
		 GroupLayout gl_panel = new GroupLayout(panel);
		 gl_panel.setHorizontalGroup(
		 	gl_panel.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_panel.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
		 			.addContainerGap(89, Short.MAX_VALUE))
		 );
		 gl_panel.setVerticalGroup(
		 	gl_panel.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_panel.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
		 			.addContainerGap(103, Short.MAX_VALUE))
		 );
		 panel_1.setLayout(null);
		 
		  nuevo = new JButton("Nuevo Empleado");
		 nuevo.setBounds(132, 11, 146, 23);
		 panel_1.add(nuevo);
		 
		  comboBox = new JComboBox();
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"C\u00F3digo", "Nombre"}));
		 comboBox.setBounds(37, 63, 64, 20);
		 panel_1.add(comboBox);
		 
		 textField = new JTextField();
		 textField.setBounds(132, 63, 146, 20);
		 panel_1.add(textField);
		 textField.setColumns(10);
		 
		  buscar = new JButton("Buscar");
		 buscar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	}
		 });
		 buscar.setBounds(288, 62, 89, 23);
		 panel_1.add(buscar);
		 
		  textPane = new JTextPane();
		 textPane.setBounds(65, 109, 292, 110);
		 panel_1.add(textPane);
		 panel.setLayout(gl_panel);
		
	}
}

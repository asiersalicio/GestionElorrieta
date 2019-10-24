package vista.graficos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vista.Vista;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class GMenu extends Vista {
	
	public JDialog ventana;
	public JPanel panel_1,panel_3,panel_4;
	public JTabbedPane tabbedPane;
	public JButton btnNewButton;
	
	public GMenu()
	{
		ventana = new JDialog();
		ventana.setTitle("Menu principal");
		ventana.setModal(true);
		ventana.setSize(867, 509);
		ventana.setLocationRelativeTo(null);
		
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		ventana.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		
		panel_1 = new JPanel();
		ventana.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("Cerrar Sesion y Salir");
		panel_1.add(btnNewButton);
		
	}
}

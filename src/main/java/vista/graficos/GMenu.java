package vista.graficos;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import vista.Vista;
import java.awt.Color;

public class GMenu extends Vista {
	
	public JFrame ventana;
	public JPanel panel_1,panel_3,panel_4;
	public JTabbedPane tabbedPane;
	public JButton btnNewButton;
	public JLabel lblReloj;
	
	public GMenu()
	{
		ventana = new JFrame();
		ventana.setBackground(new Color(255, 255, 255));
		ventana.setTitle("Menu principal");
		ventana.setSize(867, 509);
		ventana.setLocationRelativeTo(null);
		
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBackground(new Color(255, 255, 255));
		ventana.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		ventana.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("Cerrar Sesion y Salir");
		panel_1.add(btnNewButton);
		
		lblReloj = new JLabel("");
		panel_1.add(lblReloj);
		
	}
}

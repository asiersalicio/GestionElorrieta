package vista.graficos;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GAcercaDe {

	public GAcercaDe()
	{
		JDialog frame = new JDialog();
		frame.setSize(400, 400);
		frame.setTitle("About");
		frame.setResizable(false);
		frame.setModal(true);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Elorrieta 1.0");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(81, 172, 231, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAnAbsurdDevelopment = new JLabel("An absurd development group");
		lblAnAbsurdDevelopment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnAbsurdDevelopment.setBounds(41, 324, 304, 21);
		frame.getContentPane().add(lblAnAbsurdDevelopment);
		frame.setVisible(true);
	}
}

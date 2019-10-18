package vista.graficos;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vista.Vista;
import java.awt.Color;
import javax.swing.ImageIcon;

public class GIniciarSesion extends Vista {
	
	public JDialog ventana;
	public JLabel lblServidor;
	public JLabel lblUsuario;
	public JTextField userField;
	public JLabel lblContrasea;
	public JPasswordField passwordField;
	public JTextField serverField;
	public JButton btnIniciar;
	public JTextField puertoField;
	public JLabel lblError;
	
	public GIniciarSesion()
	{
		ventana = new JDialog();
		ventana.setTitle("Iniciar sesión en Hezkuntza");
		ventana.setModal(true);
		ventana.setSize(370, 370);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.getContentPane().setLayout(null);
		
		JLabel lblIniciarSesion = new JLabel("Iniciar sesi\u00F3n");
		lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblIniciarSesion.setBounds(10, 11, 215, 43);
		ventana.getContentPane().add(lblIniciarSesion);
		
		serverField = new JTextField();
		serverField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		serverField.setToolTipText("Usuario");
		serverField.setBounds(91, 106, 136, 25);
		ventana.getContentPane().add(serverField);
		serverField.setColumns(10);
		
		lblServidor = new JLabel("Servidor");
		lblServidor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblServidor.setBounds(91, 75, 215, 25);
		ventana.getContentPane().add(lblServidor);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(91, 142, 215, 25);
		ventana.getContentPane().add(lblUsuario);
		
		userField = new JTextField();
		userField.setToolTipText("Usuario");
		userField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userField.setColumns(10);
		userField.setBounds(91, 173, 186, 25);
		ventana.getContentPane().add(userField);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(91, 209, 215, 25);
		ventana.getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Contrase\u00F1a");
		passwordField.setBounds(91, 241, 186, 25);
		ventana.getContentPane().add(passwordField);
		
		btnIniciar = new JButton("Iniciar sesi\u00F3n");
		btnIniciar.setEnabled(false);
		btnIniciar.setBounds(241, 303, 116, 23);
		ventana.getContentPane().add(btnIniciar);
		
		puertoField = new JTextField();
		puertoField.setText("3306");
		puertoField.setToolTipText("Puerto");
		puertoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		puertoField.setColumns(10);
		puertoField.setBounds(228, 106, 49, 25);
		ventana.getContentPane().add(puertoField);
		
		lblError = new JLabel("Error");
		lblError.setVisible(false);
		lblError.setForeground(Color.RED);
		lblError.setBounds(10, 276, 265, 15);
		ventana.getContentPane().add(lblError);
	}
}

package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import app.Main;
import vista.graficos.GIniciarSesion;

public class CIniciarSesion extends GIniciarSesion{
	
	boolean posibleIniciar=false;
	
	public CIniciarSesion()
	{
		AnadirListeners();
	}
	
	private void AnadirListeners()
	{
	    passwordField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IniciarSesion();
			}
		});
	    
	    
	    userField.getDocument().addDocumentListener(new DocumentListener() {
			
	    	@Override
			public void removeUpdate(DocumentEvent e) {
				if(userField.getDocument().getLength()<1)
					HabilitarIniciar(false);
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				HabilitarIniciar(true);
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		});
	    
	    serverField.getDocument().addDocumentListener(new DocumentListener() {
			
	    	@Override
			public void removeUpdate(DocumentEvent e) {
				if(serverField.getDocument().getLength()<1)
					HabilitarIniciar(false);
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				HabilitarIniciar(true);
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		});
	    
	    passwordField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				if(passwordField.getDocument().getLength()<1)
					HabilitarIniciar(false);
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				HabilitarIniciar(true);
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		});
	    
	    
	    btnIniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				IniciarSesion();
				
			}
		});
	    
	    ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	MostrarMensaje("Cerrando aplicaci�n");
				CerrarAplicacion();
            }
        });
	    
	 
	    
	}
	
	public void Mostrar()
	{
		ventana.setVisible(true);
	}
	
	public void MostrarMensaje(String mensaje)
	{
		System.out.println("[Info](Iniciar sesion) " + mensaje);
	}
	
	public void IniciarSesion()
	{
		if(posibleIniciar)
		{
			bd.EstablecerDatos(serverField.getText(),userField.getText(), new String(passwordField.getPassword()), puertoField.getText());
			switch(bd.Conectar())
			{
			case 0: 
				ventana.dispose();
				Main.bd.Prueba();
				break;
			case 1: 
				lblError.setText("Usuario o contraseña incorrecta");
				lblError.setVisible(true);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Error fatal!!!! ESO POR NO HACER LOS TESTS!!!!");
				break;
			case 3:
				lblError.setText("Servidor no encontrado");
				lblError.setVisible(true);
				break;
			}

		}
	}
	
	public void HabilitarIniciar(boolean camposValidados)
	{
		if(camposValidados)
		{
			if(userField.getDocument().getLength()>1 && serverField.getDocument().getLength()>1 && passwordField.getDocument().getLength() >1)
			{
				btnIniciar.setEnabled(true);
				posibleIniciar=true;
			}	
		}
		else
		{
			btnIniciar.setEnabled(false);
			posibleIniciar=false;
		}
	}

}

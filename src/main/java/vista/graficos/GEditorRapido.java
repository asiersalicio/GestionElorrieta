package vista.graficos;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import app.Main;

public class GEditorRapido extends Main {
	protected JDialog frame;
	protected JTextArea textArea;
	protected JButton btnAceptar;
	protected JButton btnCancelar;
	protected String textoADevolver;
	
	public GEditorRapido(JDialog framePadre, String texto)
	{
		Dibujar(framePadre, texto);
		textoADevolver=texto;
		CrearListeners();
	}
	

	private void Dibujar(JDialog framePadre, String texto)
	{
		frame = new JDialog(framePadre, Dialog.ModalityType.DOCUMENT_MODAL);
		frame.setTitle("EditorRapido");
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		
		textArea = new JTextArea(texto);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		btnAceptar = new JButton("Aceptar");
		
		panel.add(btnAceptar, BorderLayout.WEST);
		
		btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar, BorderLayout.EAST);
	}
	
	private void CrearListeners() {
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textoADevolver=textArea.getText();
				frame.dispose();
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});

	}
	
	public JDialog getFrame() {
		return frame;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	
	public String getTexto()
	{
		return textoADevolver;
	}
}

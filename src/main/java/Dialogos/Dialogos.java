package Dialogos;

import java.awt.Color;

import javax.swing.JDialog;

import vista.graficos.GEditorRapido;

public class Dialogos {

	public static String EditorRapido(JDialog framePadre, boolean activo, String texto) {
		GEditorRapido editorRapido = new GEditorRapido(framePadre, texto);		
		editorRapido.getTextArea().setEnabled(activo);
		editorRapido.getTextArea().setDisabledTextColor(Color.black);
		editorRapido.getBtnAceptar().setVisible(activo);
		editorRapido.getFrame().setVisible(true);
		return editorRapido.getTexto();
	}	
	

}

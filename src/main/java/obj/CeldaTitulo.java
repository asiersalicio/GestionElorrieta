package obj;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CeldaTitulo extends Celda {

	public String nomCampo;
	public JLabel lblCol;
	
	public CeldaTitulo(JPanel panelDatos, int colX, int colY,String nomCampo) {
		super(panelDatos, colX, colY, false);
		this.nomCampo=nomCampo;
		
		panel.setBackground(Color.WHITE);
		lblCol = new JLabel(nomCampo);
		lblCol.setBounds(5, 30, 279, 14);
		panel.add(lblCol);
	}

}

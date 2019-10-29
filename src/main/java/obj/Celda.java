package obj;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import app.Main;

public class Celda extends Main {

	public JPanel panel;
	protected int colX;
	protected int colY;
	protected boolean esEditable = true;
	protected boolean activada = false;
	
	public Celda(JPanel panelDatos, int colX, int colY, boolean esEditable)
	{
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		this.colX=colX;
		this.colY=colY;
		this.esEditable=esEditable;
		
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(colX*60, colY*60, 60, 60);
		panelDatos.add(panel);
		panel.setLayout(null);
		
		
	}
	
	public void ActualizarPos(int x, int y, int ancho, int largo) {
		panel.setBounds(colX*ancho-(x*ancho), colY*largo-(y*largo), ancho, largo);
	}
	
	public void ModoEdicion(boolean activar)
	{
		activada=activar;
		if(esEditable)
			if(activar)
			{
				panel.setBackground(Color.WHITE);
				panel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			}
			else
			{
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
	}
	
}

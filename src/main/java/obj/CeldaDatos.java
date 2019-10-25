package obj;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Dialogos.Dialogos;

public class CeldaDatos extends Celda {
	public String nomCelda;
	protected JDialog framePadre;
	protected JLabel lblCol;
	
	public CeldaDatos(JDialog frame, JPanel panelDatos, int colX, int colY, String nomCelda)
	{
		super(panelDatos,colX,colY, true);
		this.nomCelda=nomCelda;
		this.framePadre=frame;
		
		lblCol = new JLabel(nomCelda);
		lblCol.setBounds(5, 30, 279, 14);
		panel.add(lblCol);
		
		CrearListeners();
	}
	
	private void CrearListeners()
	{
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EstablecerTexto(Dialogos.EditorRapido(framePadre, activada, nomCelda));
			}
		});
	}
	
	public void EstablecerTexto(String texto)
	{
		if(nomCelda!=texto)
		{
			nomCelda=texto;
			lblCol.setText(texto);
			vista.editorTablas.cambios=true;
		}
			
	}
}

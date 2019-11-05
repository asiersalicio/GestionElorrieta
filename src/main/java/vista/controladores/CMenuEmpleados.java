package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

import vista.graficos.GMenuDepartamentos;
import vista.graficos.GMenuEmpleados;

public class CMenuEmpleados extends GMenuEmpleados {

		
		
	
	public CMenuEmpleados(JTabbedPane tabbedPane) {
		super(tabbedPane);
		AnadirListeners();
		
		
	}

	private void AnadirListeners() {
		nuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});	
		buscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String valorCombo = comboBox.getSelectedItem().toString();
				String ValorBuscar = textField.getText().toString();
				textPane.setText(valorCombo +" "+ ValorBuscar);
				
				
			}
		});	
	}
	
		
		public void MostrarMensaje(String mensaje)
		{
			System.out.println("[Info](Menu) " + mensaje);
		}
}
	

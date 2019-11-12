package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

import vista.graficos.GAcercaDe;
import vista.graficos.GMenuPrincipal;

public class CMenuPrincipal extends GMenuPrincipal {

	public CMenuPrincipal(JTabbedPane tabbedPane) {
		super(tabbedPane);
		AnadirListeners();
	}

	private void AnadirListeners() {
		btnIrDepartamentos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vista.menu.tabbedPane.setSelectedIndex(1);
			}
		});
		
		btnIrEmpleados.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vista.menu.tabbedPane.setSelectedIndex(2);
			}
		});
		
		btnIrInformes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vista.menu.tabbedPane.setSelectedIndex(3);
			}
		});
		
		btnAcercaDe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new GAcercaDe();
			}
		});
		
	}
	
	

}

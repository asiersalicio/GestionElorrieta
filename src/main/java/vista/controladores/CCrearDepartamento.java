package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import obj.Departamento;
import vista.graficos.GCrearDepartamento;

public class CCrearDepartamento extends GCrearDepartamento {

	public CCrearDepartamento()
	{
		crearListeners();
		frame.setVisible(true);
	}
	
	private void crearListeners()
	{
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				botonAceptar();
			}
		});
	}
	
	private void botonAceptar()
	{
		if(ComprobarCampos())
		{
			Departamento depart = new Departamento(0, Integer.parseInt(comboEdifcio.getSelectedItem().toString()), fieldNombDepart.getText(), comboUbicacion.getSelectedItem().toString());
			ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
			departamentos.add(depart);
			if(bd.llamadas.InsertarDepartamentos(departamentos))
				frame.dispose();
		}
		
	}

	private boolean ComprobarCampos() {
		if(!fieldNombDepart.getText().isEmpty())
			return true;
		else
		{
			lblError.setText("Rellene el 'Nombre'");
			lblError.setVisible(true);
			return false;
		}
			
	}
}

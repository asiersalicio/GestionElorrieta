package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import obj.Empleado;
import vista.graficos.GCrearEmpleado;

public class CCrearEmpleado extends GCrearEmpleado {

	public CCrearEmpleado()
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
			//int codEmple, String nombre, int sueldo, int departamento,int jefe, int suJefe, int puesto
			Empleado empleado = new Empleado(0, fieldNombEmple.getText(), Integer.parseInt(fieldSueldo.getText()),  Integer.parseInt(comboDepart.getSelectedItem().toString()), Integer.parseInt(comboJefe.getSelectedItem().toString()), Integer.parseInt(comboSuJefe.getSelectedItem().toString()), Integer.parseInt(comboPuesto.getSelectedItem().toString()));
			ArrayList<Empleado> empleados = new ArrayList<Empleado>();
			empleados.add(empleado);
			if(bd.llamadas.InsertarEmpleado2(empleados))
				frame.dispose();
		}
		
	}

	private boolean ComprobarCampos() {
		if(!fieldNombEmple.getText().isEmpty() && !fieldSueldo.getText().isEmpty())
			return true;
		else
		{
			lblError.setText("Rellene el 'Nombre'");
			lblError.setVisible(true);
			return false;
		}
			
	}
}

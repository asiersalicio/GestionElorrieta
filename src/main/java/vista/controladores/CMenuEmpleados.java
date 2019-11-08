package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

import bd.Llamadas;
import obj.Empleado;
import vista.graficos.GMenuDepartamentos;
import vista.graficos.GMenuEmpleados;

public class CMenuEmpleados extends GMenuEmpleados {

		
		
	
	public CMenuEmpleados(JTabbedPane tabbedPane) {
		super(tabbedPane);
		AnadirListeners();

		
	}
	
	@Override
	public void AbrirPestana()
	{
		System.out.println("rvyuf");
	}

	private void AnadirListeners() {
		nuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});	
		buscar.addActionListener(new ActionListener() {
			Llamadas llamada= new Llamadas();
			ArrayList <Empleado> empleados = new ArrayList<Empleado>();
			@Override
			public void actionPerformed(ActionEvent e) {
				String valorCombo = comboBox.getSelectedItem().toString();
				String valorBuscar = textField.getText().toString();
				try {
					empleados=llamada.ObtenerEmpleados(valorCombo, valorBuscar);
					textPane.setText(empleados.toString());
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				//textPane.setText(valorCombo +" "+ ValorBuscar);
				
				
			}
		});	
	}

		
		public void MostrarMensaje(String mensaje)
		{
			System.out.println("[Info](Menu) " + mensaje);
		}
}
	

package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTabbedPane;

import bd.Llamadas;
import obj.Empleado;
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
		nuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CCrearEmpleado crearEmpleado = new CCrearEmpleado();
				
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
					
					//textPane.setText(empleados.toString());
					fieldCodEmple.setText(String.valueOf(empleados.get(0).getCodEmple()));
					fieldNombre.setText(empleados.get(0).getNombre());
					fieldSueldo.setText(String.valueOf(empleados.get(0).getSueldo()));
					esJefe.setText(String.valueOf(empleados.get(0).getJefe()));
					fieldSuJefe.setText(String.valueOf(empleados.get(0).getSuJefe()));
					fieldPuesto.setText(String.valueOf(empleados.get(0).getPuesto()));
					fieldDepartamento.setText(String.valueOf(empleados.get(0).getDepartamento()));
					for(int i=0;i< empleados.size()-1;i++) {
						
						
					}
					System.out.println(empleados.get(0).getCodEmple()
							+"\n"+empleados.get(0).getNombre()+"\n"+empleados.get(0).getSueldo());
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
	

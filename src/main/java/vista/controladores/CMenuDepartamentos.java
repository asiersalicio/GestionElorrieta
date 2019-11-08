package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

import obj.Departamento;
import vista.graficos.GMenuDepartamentos;

public class CMenuDepartamentos extends GMenuDepartamentos{

	private int departamentoActual=1;
	
	public CMenuDepartamentos(JTabbedPane tabbedpane) {
		super(tabbedpane);
		AnadirListeners();
	}
	
	@Override
	public void AbrirPestana()
	{
		CargarDepartamento(1);
	}

	private void AnadirListeners()
	{
		btnSiguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				departamentoActual=departamentoActual+1;
				if(CargarDepartamento(departamentoActual))
				{
					
				}
				else
				{
					departamentoActual=departamentoActual-1;
				}
			}
		});
		
		btnAnterior.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				departamentoActual=departamentoActual-1;
				if(CargarDepartamento(departamentoActual))
				{
					
				}
				else
				{
					departamentoActual=departamentoActual+1;
				}
				
			}
		});
		
		btnCrearDepartamento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CCrearDepartamento crearDepartamento = new CCrearDepartamento();
				
			}
		});
	}
	
	private boolean CargarDepartamento(int i) {
		Departamento depart = bd.llamadas.CargarDepartamento(i);
		if(depart!=null)
		{
			EstablecerDepartamentoVisual(depart);
			return true;
		}
		else
			return false;
	}
	
	private void EstablecerDepartamentoVisual(Departamento departamento)
	{
		fieldCodDepart.setText(Integer.toString(departamento.getCodDepart()));
		fieldNomDepart.setText(departamento.getNombre());
		fieldEdificio.setText(Integer.toString(departamento.getEdificio()));
	}

}

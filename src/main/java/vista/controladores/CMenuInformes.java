package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;

import obj.Departamento;
import obj.Empleado;
import vista.graficos.GMenuInformes;

public class CMenuInformes extends GMenuInformes {

	public CMenuInformes(JTabbedPane tabbedPane) {
		super(tabbedPane);
		AnadirListeners();
	}

	private void AnadirListeners() {
		
		btnGenerarInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GenerarInforme();
				
			}

		});
		
	}
		
		
	private void GenerarInforme() {
		ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		if (chckbxDepartamentos.isSelected()) {
			departamentos = bd.llamadas.obtenerDepartamentos();
		}
		if (chckbxEmpleados.isSelected()) {
			empleados = bd.llamadas.obtenerEmpleados();
		}
		es.interprete.guardarInformeHTML(es.archivos.DialgoGuardarSinFiltro(new JFileChooser()), departamentos, empleados);
	}
}

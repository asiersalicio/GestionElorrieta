package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import obj.Celda;
import obj.CeldaDatos;
import obj.CeldaTitulo;
import obj.Departamento;
import obj.Empleado;
import obj.Puesto;
import vista.graficos.GEditorTablas;

public class CEditorTablas extends GEditorTablas {

	public boolean cambios = false;
	private File archivo=null;
	public boolean ratonEncima=false;
	private String nombreTabla;
	
	public CEditorTablas()
	{
		AnadirListeners();
	}
	
	private void AnadirListeners() {
		
		sliderHorizontal.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				anchoCeldas=sliderHorizontal.getValue();
				ActualizarPosCeldas();
			}
		});
		sliderVertical.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				altoCeldas=sliderVertical.getValue();
				ActualizarPosCeldas();
			}
		});
		scrollHorizontal.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				ActualizarPosCeldas();
			}
		});
		scrollVertical.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				ActualizarPosCeldas();
			}
		});
//		btnNuevo.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				NuevoArchivo();
//				cambios=false;
//			}
//		});	
		
		btnEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ActivarModoEdcionCeldas(btnEdicion.isSelected());
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BotonAceptarPulsado();
			}
		});
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        CerrarAplicacion();
		    }
		});
		
//		btnGuardar.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				GuardarArchivo();				
//			}
//		});
		
//		frame.addWindowListener(new java.awt.event.WindowAdapter() {
//		    @Override
//		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//		        if(cambios) {
//		        	int respuesta = JOptionPane.showConfirmDialog(frame, "No ha guardado los cambios, ¿Desea guardarlos?", "No ha guardado los cambios", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
//		        	if (respuesta==JOptionPane.YES_OPTION){
//				        if(GuardarArchivo())
//				        {
//				        	frame.dispose();
//				        }
//				        
//				    }
//		        	else if(respuesta==JOptionPane.NO_OPTION)
//		        	{
//		        		frame.dispose();
//		        	}		    	
//		        }
//		        else
//		        {
//		        	frame.dispose();
//		        }
//		    }
//		});
	}
	
	private void BotonAceptarPulsado()
	{
		ArrayList<ArrayList<String>> celdas = LeerCeldas();
		consola.ImprimirArray2D(celdas);
		boolean error=false;
		switch(nombreTabla)
		{
			case "DEPARTAMENTO":
				if(bd.llamadas.InsertarDepartamentos(ConvertirCeldasADepartamentos()))
					frame.dispose();
				else
					error=true;
			break;
			case "PUESTO":
				if(bd.llamadas.InsertarPuestos(ConvertirCeldasAPuestos()))
					frame.dispose();
				else
					error=true;
			break;
			case "EMPLEADO":
				if(bd.llamadas.InsertarEmpleado(ConvertirCeldasAEmpleados()))
					frame.dispose();
				else
					error=true;
			break;
		}
		
		if(error)
		{
			JOptionPane.showMessageDialog(null, "Formato de archivo incorrecto, compruebe si el tipo de dato es correcto");
		}
		
		
		bd.CerrarConexion();
	}

	private ArrayList<Empleado> ConvertirCeldasAEmpleados() {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		ArrayList<ArrayList<String>> celdas = LeerCeldas();
		for(int i = 0;i<celdas.size();i++)
		{
			Empleado empleado = new Empleado(Integer.parseInt(celdas.get(i).get(0)), Integer.parseInt(celdas.get(i).get(2)),Integer.parseInt(celdas.get(i).get(3)), Integer.parseInt(celdas.get(i).get(4)), Integer.parseInt(celdas.get(i).get(5)), celdas.get(i).get(1), celdas.get(i).get(6));
			empleados.add(empleado);
		}
		return empleados;
	}

	private ArrayList<Departamento> ConvertirCeldasADepartamentos() {
		ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
		ArrayList<ArrayList<String>> celdas = LeerCeldas();
		for(int i = 0;i<celdas.size();i++)
		{
			Departamento departamento = new Departamento(Integer.parseInt(celdas.get(i).get(0)), Integer.parseInt(celdas.get(i).get(2)), celdas.get(i).get(1), celdas.get(i).get(3));
			departamentos.add(departamento);
		}
		return departamentos;
	}

	private ArrayList<Puesto> ConvertirCeldasAPuestos() {
		ArrayList<Puesto> puestos = new ArrayList<Puesto>();
		ArrayList<ArrayList<String>> celdas = LeerCeldas();
		for(int i = 0;i<celdas.size();i++)
		{
			Puesto puesto = new Puesto(Integer.parseInt(celdas.get(i).get(0)), celdas.get(i).get(1));
			puestos.add(puesto);
		}
		return puestos;
	}
	

	public void Mostrar()
	{
		ventanaVisible=true;
		frame.setVisible(true);
	}
	
	public void RellenarCeldas(ArrayList<ArrayList<String>> arrayList, File archivo, String[] celdasTitulos, String nombreTabla)
	{
		this.nombreTabla=nombreTabla;
		frame.setTitle(archivo.getName());
		celdas = new ArrayList<ArrayList<Celda>>();
		scrollVertical.setMaximum(arrayList.size());
		frame.setTitle(archivo.getName());
		int x,y;
		celdas.add(0, new ArrayList<Celda>());
		for(x=0;x<celdasTitulos.length;x++)
		{
			celdas.get(0).add(x, new CeldaTitulo(panelDatos, x, 0, celdasTitulos[x]));	
		}
		for(y=1;y<arrayList.size();y++)
		{
			celdas.add(y, new ArrayList<Celda>());
			for(x=0;x<arrayList.get(y).size();x++)
			{
				celdas.get(y).add(x, new CeldaDatos(frame, panelDatos, x, y, arrayList.get(y).get(x)));
			}
			//celdas.get(y).add(x+1, new CeldaAnadir(panelDatos, x+1, y));
		}
	}
	
	private void ActualizarPosCeldas()
	{
		if(ventanaVisible)
		{
			for(int y=0;y<celdas.size();y++)
			{
				try 
				{
					for(int x=0;x<celdas.get(y).size();x++)
					{					
						celdas.get(y).get(x).ActualizarPos(scrollHorizontal.getValue(), scrollVertical.getValue(), anchoCeldas, altoCeldas);
					}
				}
				catch(NullPointerException ex) {}
			}
		}
	}
	
	private void ActivarModoEdcionCeldas(boolean ModoEdcion)
	{
		if(ventanaVisible)
		{
			for(int y=0;y<celdas.size();y++)
			{
				try 
				{
					for(int x=0;x<celdas.get(y).size();x++)
					{					
						celdas.get(y).get(x).ModoEdicion(ModoEdcion);;
					}
				}
				catch(NullPointerException ex) {}
			}
		}
	}
	
//	private void NuevoArchivo()
//	{
//		archivo=null;
//		frame.setTitle("Nuevo documento de texto plano");
//	}
	
	private ArrayList<ArrayList<String>> LeerCeldas()
	{
		ArrayList<ArrayList<String>> textoAGuardar = new ArrayList<ArrayList<String>>();
		for(int y=0;y<celdas.size();y++)
		{
			textoAGuardar.add(y, new ArrayList<String>());
			for(int x=0;x<celdas.get(y).size();x++)
			{					
				Celda celda = celdas.get(y).get(x);
				if(celda instanceof CeldaDatos)
				{
					textoAGuardar.get(y).add(x,((CeldaDatos) celda).nomCelda);
				}
				else
				{
					textoAGuardar.get(y).add(x,"");
				}
			}
		}
		textoAGuardar.remove(0);
		return textoAGuardar;
	}
		
//	private boolean GuardarArchivo()
//	{
//		archivo=es.interprete.GuardarArrayListEnCSV(archivo, textoAGuardar, ";");
//		if(archivo!=null)
//			{
//				frame.setTitle(archivo.getName());
//				return true;
//			}
//		else
//		{
//			return false;
//		}
//	}
}

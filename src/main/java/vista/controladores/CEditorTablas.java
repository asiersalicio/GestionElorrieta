package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import obj.Celda;
import obj.CeldaDatos;
import obj.CeldaTitulo;
import obj.Puesto;
import vista.graficos.GEditorTablas;

public class CEditorTablas extends GEditorTablas {

	public boolean cambios = false;
	private File archivo=null;
	public boolean ratonEncima=false;
	private String tipoInsert;
	private String[] celdasTitulos;
	
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
				//BotonAceptarPulsado();
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
	
//	private void BotonAceptarPulsado()
//	{
//		ArrayList<ArrayList<String>> celdas = LeerCeldas();
//		consola.ImprimirArray2D(celdas);
//		if(bd.llamadas.InsertarDatos(celdas, tipoInsert))
//		{
//			frame.dispose();
//			bd.CerrarConexion();
//		}
//		else
//		{
//			bd.CerrarConexion();
//			JOptionPane.showMessageDialog(null, "Formato de archivo incorrecto, compruebe si el tipo de dato es correcto");
//			BorrarCeldas();
//			File archivo = es.archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("Archivo de departamentos", "csv"));
//			ArrayList<ArrayList<String>> celdas1 = es.interprete.LectorArchivos2D(archivo, ";");
//			RellenarCeldas(celdas1, archivo, celdasTitulos, tipoInsert);
//		}
//		
//	}

	public void Mostrar()
	{
		ventanaVisible=true;
		frame.setVisible(true);
	}
	
	public void RellenarCeldas(ArrayList<Puesto> puestos, File archivo, String[] celdasTitulos, String tipoInsert)
	{
		this.tipoInsert=tipoInsert;
		this.celdasTitulos=celdasTitulos;
		frame.setTitle(archivo.getName());
		celdas = new ArrayList<ArrayList<Celda>>();
		scrollVertical.setMaximum(puestos.size());
		frame.setTitle(archivo.getName());
		int x,y;
		celdas.add(0, new ArrayList<Celda>());
		for(x=0;x<celdasTitulos.length;x++)
		{
			celdas.get(0).add(x, new CeldaTitulo(panelDatos, x, 0, celdasTitulos[x]));	
		}
		for(y=1;y<puestos.size();y++)
		{
			celdas.add(y, new ArrayList<Celda>());
			String[] arrayRellenar = puestos.get(y).toArray();
			for(x=0;x<arrayRellenar.length;x++)
			{
				celdas.get(y).add(x, new CeldaDatos(frame, panelDatos, x, y, arrayRellenar[x]));
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
	
	private void BorrarCeldas()
	{
		if(ventanaVisible)
		{
			for(int y=0;y<celdas.size();y++)
			{
				try 
				{
					for(int x=0;x<celdas.get(y).size();x++)
					{					
						celdas.get(y).get(x).panel.setVisible(false);
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

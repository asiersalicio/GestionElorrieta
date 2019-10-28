package vista.graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import app.Main;
import obj.Celda;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GEditorTablas extends Main {

	protected JDialog frame;
	protected JPanel panelPrincipal;
	protected JPanel panelInferior;
	protected JPanel panelContenedor;
	public JPanel panelDatos;
	protected JScrollBar scrollHorizontal;
	protected JScrollBar scrollVertical;
	protected ArrayList<ArrayList<Celda>> celdas;
	protected int anchoCeldas = 60;
	protected int altoCeldas = 60;
	protected boolean ventanaVisible=false;
	protected JSlider sliderHorizontal, sliderVertical;
	protected JButton btnGuardar, btnAceptar;
	protected JToggleButton btnEdicion;
	
	public GEditorTablas()
	{		
		frame = new JDialog();
		frame.setModal(true);
		frame.setSize(500, 500);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		panelInferior = new JPanel();
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		
		sliderHorizontal = new JSlider();
		sliderHorizontal.setValue(60);
		sliderHorizontal.setMaximum(200);
		sliderHorizontal.setMinimum(25);
		
		sliderVertical = new JSlider();
		sliderVertical.setValue(60);
		sliderVertical.setMaximum(200);
		sliderVertical.setMinimum(25);
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelInferior.add(sliderVertical);
		panelInferior.add(sliderHorizontal);
		
		panelContenedor = new JPanel();
		panelPrincipal.add(panelContenedor, BorderLayout.CENTER);
		panelContenedor.setLayout(new BorderLayout(0, 0));
		
		panelDatos = new JPanel();
		panelDatos.setBackground(Color.WHITE);
		panelContenedor.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(null);

		
		scrollHorizontal = new JScrollBar();
		scrollHorizontal.setOrientation(JScrollBar.HORIZONTAL);
		panelContenedor.add(scrollHorizontal, BorderLayout.SOUTH);
		
		
		scrollVertical = new JScrollBar();
		panelContenedor.add(scrollVertical, BorderLayout.EAST);
		
		JToolBar toolBar = new JToolBar();
		panelContenedor.add(toolBar, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		toolBar.add(panel);
		
		btnGuardar = new JButton("Guardar");
		panel.add(btnGuardar);
		
		btnEdicion = new JToggleButton("Modo edicion");
		
		panel.add(btnEdicion);
		
		btnAceptar = new JButton("Aceptar");
		
		panel.add(btnAceptar);
	}
}


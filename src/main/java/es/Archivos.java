package es;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Archivos {

	public Archivos() {
	}

	public File ElegirArchivo(JFileChooser fileChooser, FileNameExtensionFilter filtro) {
		System.out.println("Abriendo selector de archivos");
		fileChooser.setFileFilter(filtro);
		int returnVal = fileChooser.showOpenDialog(null);
		File file = null;;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			System.out.println("La ruta del archivo seleccionado es " + file.getPath());
			for(int i=0;i<filtro.getExtensions().length;i++)
			{
				if(file.getPath().toLowerCase().endsWith(filtro.getExtensions()[i]))
				{
					System.out.println("Archivo seleccionado de tipo correcto");
					return file;
				}
			}
			System.out.println("No ha seleccionado el tipo de archivo correcto");
			return ElegirArchivo(new JFileChooser(), filtro);
			
		} else {
			System.out.println("Seleccion de archivo cancelada");
			return null;
		}
	}
	
	public File DialgoGuardarSinFiltro(JFileChooser fileChooser) {
		System.out.println("Abriendo dialogo para guardar");
		int returnVal = fileChooser.showSaveDialog(null);
		File file = null;;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			System.out.println("La ruta del archivo seleccionado es " + file.getPath());
			if(file.exists())
			{
				int dialogButton = JOptionPane.YES_NO_OPTION;
			    dialogButton = JOptionPane.showConfirmDialog (null, "¿El archivo seleccionado ya existe, desea reemplazar dicho archivo?","¿Desea sobreescribir el archivo?",dialogButton);
			    if (dialogButton == JOptionPane.NO_OPTION)
			    {
			    	return DialgoGuardarSinFiltro(new JFileChooser());
			    }
			}
			
		} else {
			System.out.println("Seleccion de archivo cancelada");
			return null;
		}
		return file;
	}
	
	public File GrabarTextoPlano(File archivo, String texto)
	{
		try {
			FileWriter fw = null;	
		if(archivo!=null)
		{
			fw = new FileWriter(archivo.getAbsolutePath()); 
		}
		else
		{
			archivo=DialgoGuardarSinFiltro(new JFileChooser());
		}
		if(archivo!=null)
		{
			fw = new FileWriter(archivo);
			fw.write(texto);
			fw.close(); 
		}
	}catch(IOException ex) {}
		return archivo;
	}
	
	

	

}



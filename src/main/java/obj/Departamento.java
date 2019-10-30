package obj;

import java.util.ArrayList;

public class Departamento extends ObjGenerico {

	private int codDepart;
	private String nombre;
	private int edificio;
	private String ubicacion;
	
	public Departamento(int codDepart, String nombre, int edificio, String ubicacion) {
		this.codDepart = codDepart;
		this.nombre = nombre;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
	}
	
	public int getCodDepart() {
		return codDepart;
	}
	public void setCodDepart(int codDepart) {
		this.codDepart = codDepart;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdificio() {
		return edificio;
	}
	public void setEdificio(int edificio) {
		this.edificio = edificio;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public String[] toArrayList()
	{
		String[] devolver = {Integer.toString(codDepart),Integer.toString(codDepart),nombre,Integer.toString(edificio),ubicacion};
		return devolver;
	}
	
}

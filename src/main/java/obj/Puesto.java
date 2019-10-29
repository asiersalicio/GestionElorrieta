package obj;

import java.util.ArrayList;

public class Puesto extends ObjGenerico {

	private int codPuesto;
	private String nombre;
	
	
	
	public Puesto(int codPuesto, String nombre) {
		this.codPuesto = codPuesto;
		this.nombre = nombre;
	}
	
	public int getCodPuesto() {
		return codPuesto;
	}
	public void setCodPuesto(int codPuesto) {
		this.codPuesto = codPuesto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String[] toArray()
	{
		String[] devolver = {Integer.toString(codPuesto), nombre};
		return devolver;
	}
	
	
}

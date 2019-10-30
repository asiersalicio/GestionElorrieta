package obj;

import java.util.ArrayList;

public class Empleado extends ObjGenerico {

	private int codEmple;
	private String nombre;
	private int departamento;
	private int sueldo;
	private int jefe;
	private int suJefe;
	private int puesto;
	
	public Empleado(int codEmple, String nombre, int departamento, int sueldo, int jefe, int suJefe, int puesto) {
		this.codEmple = codEmple;
		this.nombre = nombre;
		this.departamento = departamento;
		this.sueldo = sueldo;
		this.jefe = jefe;
		this.suJefe = suJefe;
		this.puesto = puesto;
	}
	
	
	public int getCodEmple() {
		return codEmple;
	}
	public void setCodEmple(int codEmple) {
		this.codEmple = codEmple;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDepartamento() {
		return departamento;
	}
	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	public int getJefe() {
		return jefe;
	}
	public void setJefe(int jefe) {
		this.jefe = jefe;
	}
	public int getSuJefe() {
		return suJefe;
	}
	public void setSuJefe(int suJefe) {
		this.suJefe = suJefe;
	}
	public int getPuesto() {
		return puesto;
	}
	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}
	
	public String[] toArray()
	{
		String[] devolver = {Integer.toString(codEmple),nombre,Integer.toString(departamento),Integer.toString(sueldo),Integer.toString(jefe),Integer.toString(suJefe),Integer.toString(puesto)};
		return devolver;
	}
	
}

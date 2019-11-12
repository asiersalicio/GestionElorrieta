package obj;

public class Empleado {

	private int codEmple, departamento, sueldo, jefe, suJefe, puesto;
	private String nombre;
	
	public int getCodEmple() {
		return codEmple;
	}
	public void setCodEmple(int codEmple) {
		this.codEmple = codEmple;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Empleado(int codEmple, int departamento, int sueldo, int jefe, int suJefe, String nombre, int puesto) {
		super();
		this.codEmple = codEmple;
		this.departamento = departamento;
		this.sueldo = sueldo;
		this.jefe = jefe;
		this.suJefe = suJefe;
		this.nombre = nombre;
		this.puesto = puesto;
	}
	public Empleado(int codEmple, String nombre, int sueldo, int departamento,int jefe, int suJefe, int puesto ) {
		
		this.codEmple = codEmple;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.departamento = departamento;
		this.jefe = jefe;
		this.suJefe = suJefe;
		this.puesto = puesto;
	}
	
	public String toString(Empleado emple) {
		
		String frase="NOMBRE"+this.nombre;
		return nombre;
		
		
	}
	
	
	
	
	
}

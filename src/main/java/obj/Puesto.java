package obj;

public class Puesto {

	private int codPuesto;
	private String nombre;
	
	
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
	
	public Puesto(int codPuesto, String nombre) {
		super();
		this.codPuesto = codPuesto;
		this.nombre = nombre;
	}
	
	
	
	
}

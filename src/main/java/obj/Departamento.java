package obj;

public class Departamento {

	private int codDepart, edificio;
	private String nombre, ubicacion;
	
	public int getCodDepart() {
		return codDepart;
	}
	public void setCodDepart(int codDepart) {
		this.codDepart = codDepart;
	}
	public int getEdificio() {
		return edificio;
	}
	public void setEdificio(int edificio) {
		this.edificio = edificio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Departamento(int codDepart, int edificio, String nombre, String ubicacion) {
		super();
		this.codDepart = codDepart;
		this.edificio = edificio;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}
	
	
	
}

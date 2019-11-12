package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.Main;
import obj.Departamento;
import obj.Empleado;
import obj.Puesto;

public class Llamadas extends Main {

	public Llamadas()
	{
		
	}
	
	
	public boolean InsertarPuestos(ArrayList<Puesto> arrayList)
	{
	      String query = "insert into PUESTOS (COD_PUESTO, NOMBRE) values (?, ?);";
	      boolean error=false;
	      try {
	      for(int y=0;y<arrayList.size();y++)
	      {
	    	  Puesto puesto = arrayList.get(y);
	    	  String[] setStrings = {Integer.toString(puesto.getCodPuesto()),puesto.getNombre()};
	    	  	    	  
	    	  if(bd.LlamadaInsert(query, setStrings)!=0||error)
	    	  {
	    		  error=true;
	    		  break;
	    	  }
	      }
	      }catch (java.lang.IndexOutOfBoundsException ex) {
	    	  MostrarError("Formato de archivo incorrecto");
	    	  error=true;
	      }
	      if(error)
	      {
	    	  MostrarError("Formato de archivo incorrecto, compruebe si el tipo de dato es correcto");
	    	  return false;
	      }
	      else
	    	  return true;
	}
	
	private void MostrarConsola(String mensaje)
	{
		System.out.println("[Info](Llamadas BD): " + mensaje);
	}
	
	private void MostrarError(String mensaje)
	{
		System.err.println("[Error](Llamadas BD): " + mensaje);
	}

	public boolean InsertarDepartamentos(ArrayList<Departamento> arrayList) {
		String query = "insert into DEPARTAMENTO (COD_DEPART, NOMBRE, EDIFICIO, UBICACION) values (?, ?, ?, ?);";
	      boolean error=false;
	      try {
	      for(int y=0;y<arrayList.size();y++)
	      {
	    	  Departamento puesto = arrayList.get(y);
	    	  String[] setStrings = {Integer.toString(puesto.getCodDepart()), puesto.getNombre(), Integer.toString(puesto.getEdificio()), puesto.getUbicacion()};
	    	  	    	  
	    	  if(bd.LlamadaInsert(query, setStrings)!=0||error)
	    	  {
	    		  error=true;
	    		  break;
	    	  }
	      }
	      }catch (java.lang.IndexOutOfBoundsException ex) {
	    	  MostrarError("Formato de archivo incorrecto");
	    	  error=true;
	      }
	      if(error)
	      {
	    	  MostrarError("Formato de archivo incorrecto, compruebe si el tipo de dato es correcto");
	    	  return false;
	      }
	      else
	    	  return true;
	}

	public boolean InsertarEmpleado(ArrayList<Empleado> arrayList) {
		String query = "insert into EMPLEADO (COD_EMPLE, NOMBRE, DEPARTAMENTO, SUELDO, JEFE, SU_JEFE, PUESTO) values (?, ?, ?, ?, ?, ?, ?);";
	      boolean error=false;
	      try {
	      for(int y=0;y<arrayList.size();y++)
	      {
	    	  Empleado puesto = arrayList.get(y);
	    	  String[] setStrings = {Integer.toString(puesto.getCodEmple()), puesto.getNombre(), Integer.toString(puesto.getDepartamento()), Integer.toString(puesto.getSueldo()), Integer.toString(puesto.getJefe()), Integer.toString(puesto.getSuJefe()),  Integer.toString(puesto.getPuesto())};
	    	  	    	  
	    	  if(bd.LlamadaInsert(query, setStrings)!=0||error)
	    	  {
	    		  error=true;
	    		  break;
	    	  }
	      }
	      }catch (java.lang.IndexOutOfBoundsException ex) {
	    	  MostrarError("Formato de archivo incorrecto");
	    	  error=true;
	      }
	      if(error)
	      {
	    	  MostrarError("Formato de archivo incorrecto, compruebe si el tipo de dato es correcto");
	    	  return false;
	      }
	      else
	    	  return true;
	}
	
	public Departamento CargarDepartamento( int codDepart)
	{
		String query = "SELECT * FROM DEPARTAMENTO WHERE COD_DEPART = ?";
		String[] setStrings = {Integer.toString(codDepart)};
		ResultSet result=bd.Llamada(query, setStrings);	
		try {
			if(result.next())
			{
				return new Departamento(result.getInt("COD_DEPART"), result.getInt("EDIFICIO"), result.getString("NOMBRE"), result.getString("UBICACION"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Empleado> ObtenerEmpleados( String buscar, String campo) throws SQLException
	{
		 ArrayList <Empleado> empleados = new ArrayList<Empleado>();
		 Empleado emple;
		if (buscar.equals("Código")) {
			System.out.println(campo);
	      String query = "select * from EMPLEADO where COD_EMPLE = ?;";
	      String[] setStrings = {(campo)};
	      ResultSet result=bd.Llamada(query, setStrings);
	     
	      while (result.next()) {

	    	  //System.out.println(result.getInt(0)+result.getInt(1));
	    	  //COD_EMPLE, NOMBRE, DEPARTAMENTO, SUELDO, JEFE, SU_JEFE, PUESTO
	    	
	    	  System.out.println(result.getInt("COD_EMPLE")+result.getString("NOMBRE").toUpperCase()+result.getString("DEPARTAMENTO")+result.getInt("SUELDO")+result.getInt("JEFE"));
	    	  emple= new Empleado(result.getInt("COD_EMPLE"),result.getString("NOMBRE"),result.getInt("SUELDO"),result.getInt("DEPARTAMENTO"),result.getInt("JEFE"),result.getInt("SU_JEFE"),result.getInt("PUESTO"));
	    	  empleados.add(emple);
	      }
		
		}else {
			 String query = "select * from EMPLEADO where UPPER(NOMBRE) = UPPER(?);";
		      String[] setStrings = {(campo)};
		      ResultSet result=bd.Llamada(query, setStrings);
		      while (result.next()) {
		    	  System.out.println(result.getInt("COD_EMPLE")+result.getString("NOMBRE")+result.getString("DEPARTAMENTO")+result.getInt("SUELDO")+result.getInt("JEFE"));
		    	  //emple= new Empleado(result.getInt("COD_EMPLE")+result.getInt("SUELDO")+result.getInt("JEFE")+result.getInt("SU_JEFE")+result.getInt("PUESTO")+result.getString("NOMBRE")+result.getString("DEPARTAMENTO"));
		    	  emple= new Empleado(result.getInt("COD_EMPLE"),result.getString("NOMBRE"),result.getInt("SUELDO"),result.getInt("DEPARTAMENTO"),result.getInt("JEFE"),result.getInt("SU_JEFE"),result.getInt("PUESTO"));
		    	  empleados.add(emple);
		      }
		}
			
		return empleados;
	      
	      
	     
		}

	
	public Empleado ObtenerEmpleado(int codigo)
	{
		Empleado emple;
		
		String query = "select * from EMPLEADO where COD_EMPLE = ?;";
		String[] setStrings = {(Integer.toString(codigo))};
		ResultSet result=bd.Llamada(query, setStrings);
		try {
			if(result.next())
				emple= new Empleado(result.getInt("COD_EMPLE"), result.getString("NOMBRE"), result.getInt("SUELDO"), result.getInt("DEPARTAMENTO"), result.getInt("JEFE"), result.getInt("SU_JEFE"), result.getInt("PUESTO"));
			else
				return null;
		} catch (SQLException e) {
			return null;
		}
		return emple;
	}
	
	public Puesto ObtenerPuesto(int codigo) {
		Puesto puesto;
		
		String query = "select * from PUESTOS where COD_PUESTO = ?;";
		String[] setStrings = {(Integer.toString(codigo))};
		ResultSet result=bd.Llamada(query, setStrings);
		try {
			if(result.next())
				puesto=new Puesto(result.getInt("COD_PUESTO"), result.getString("NOMBRE"));
			else
				return null;
		} catch (SQLException e) {
			return null;
		}
		return puesto;
	}
	
	public ArrayList<Departamento> obtenerDepartamentos()
	{
		String query = "SELECT * FROM DEPARTAMENTO";
		String[] setStrings = {};
		ResultSet result=bd.Llamada(query, setStrings);	
		ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
		try {
			while(result.next())
			{
				departamentos.add(new Departamento(result.getInt("COD_DEPART"), result.getInt("EDIFICIO"), result.getString("NOMBRE"), result.getString("UBICACION")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departamentos;
	}
	
	public ArrayList<Empleado> obtenerEmpleados()
	{
		String query = "SELECT * FROM EMPLEADO";
		String[] setStrings = {};
		ResultSet result=bd.Llamada(query, setStrings);	
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		try {
			while(result.next())
			{
				empleados.add(new Empleado(result.getInt("COD_EMPLE"), result.getInt("DEPARTAMENTO"), result.getInt("SUELDO"), result.getInt("JEFE"), result.getInt("SU_JEFE"), result.getString("NOMBRE"), result.getInt("PUESTO")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleados;
	}


	
	
}

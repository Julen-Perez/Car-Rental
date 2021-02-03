package proyecto_IS2;

import java.sql.Date;


public class Cliente {
 private String nombre;
 private String apellidos;
 private String dni;

public Cliente(String nombre, String apellidos, String dni, int id) {
	
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.dni = dni;

}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}

}

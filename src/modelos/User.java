package modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
	
	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	
	
	public User(String email, String contrasena) {
		this.email = email;
		this.contrasena = contrasena;
	}
	
	public User(String nombre, String apellido, String email, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return email;
	}

	public void setCorreo(String email) {
		this.email = email;
	}


	public String getContrasena() {
		return contrasena;
	}
	
	
	
	public String toString() {
		return "Nombre: " + nombre +
					"\nApelldo: " + apellido +
					"\nEmail: " + email +
					"\nContraseña: " + contrasena;
	}
	
	public String toCsv() {
		return nombre + "," +
					apellido + "," +
		           	email + "," +
		           	contrasena;
	}
	
	public static User fromCsv(String userData)
	{
		String data[] = userData.split(",");
		
		String name = data[0];
		String apellido = data[1];
		String email = data[2];
		String contrasena = data[3];

		return new User(name, apellido, email, contrasena);
	}
	
	
}

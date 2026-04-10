package controllers;

import java.awt.Window;

import javax.swing.SwingUtilities;

import exceptions.InvalidUserException;
import views.FormularioRegistro;
import views.Login;
import views.VentanaPrincipal;

public class LoginController {
	
	private Login login = new Login();
	public LoginController(Login login) {
		this.login=login;
		login.getButtonIniciar().addActionListener(e -> evaluarCredenciales());
		login.getRegistrarse().addActionListener(e -> {	
			
			new RegistroController();			
		});
	}
	private void resetearCredenciales() {
		login.getMensajeCorreo().setText(" ");
		login.getMensajeContraseña().setText(" ");
	}
	
	private void evaluarCredenciales() {
		resetearCredenciales();
		boolean error=false;
		Window window=login.getWindow();
		try {
			evaluarCorreo();
		}catch(InvalidUserException ex){
			login.getMensajeCorreo().setText(ex.getMessage());
			error=true;
		}
		try {
			evaluarContrasena();
		}catch(InvalidUserException ex){
			login.getMensajeContraseña().setText(ex.getMessage());
			error=true;
		}
		if(error==false) {
			new VentanaPrincipal();
			window.dispose();
		}
		
	}
	private void evaluarCorreo() throws InvalidUserException {
		if(login.getUsuario().getText().equals("")) {
			throw new InvalidUserException("* Correo obligatorio *");
		}
		if(!login.getUsuario().getText().equals("")&&!login.getUsuario().getText().equals("papita@gmail.com")) {
			throw new InvalidUserException("* Correo erroneo *");
		}
		
	}
	private void evaluarContrasena() throws InvalidUserException {
		if(String.valueOf(login.getContraseña().getPassword()).equals("") ){
			throw new InvalidUserException("* Contraseña obligatorio *");
		}
	}
}


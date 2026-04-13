package controllers;

import java.awt.Window;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
		addDocumentListeners();
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
	public void addDocumentListeners() {
		login.getUsuario().getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					evaluarCorreoRT();
				}catch(InvalidUserException ex){
					login.getMensajeCorreo().setText(ex.getMessage());
					
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					evaluarCorreoRT();
				}catch(InvalidUserException ex){
					login.getMensajeCorreo().setText(ex.getMessage());
					
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					evaluarCorreoRT();
				}catch(InvalidUserException ex){
					login.getMensajeCorreo().setText(ex.getMessage());
					
				}
			}
		});
		
		login.getContraseña().getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					evaluarContrasena();
				}catch(InvalidUserException ex){
					login.getMensajeContraseña().setText(ex.getMessage());
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					evaluarContrasena();
				}catch(InvalidUserException ex){
					login.getMensajeContraseña().setText(ex.getMessage());
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					evaluarContrasena();
				}catch(InvalidUserException ex){
					login.getMensajeContraseña().setText(ex.getMessage());
				}
			}
		});
		
	}
	private void evaluarCorreo() throws InvalidUserException {
		if(login.getUsuario().getText().equals("")) {
			throw new InvalidUserException("* Correo obligatorio *");
		}
		if(!login.getUsuario().getText().equals("")&&!login.getUsuario().getText().equals("papita@gmail.com")) {
			throw new InvalidUserException("* Correo erroneo *");
		}
		
	}
	private void evaluarCorreoRT() throws InvalidUserException {
		resetearCredenciales();
		if(login.getUsuario().getText().equals("")) {
			throw new InvalidUserException("* Correo obligatorio *");
		}
		if(!login.getUsuario().getText().equals("")&&!login.getUsuario().getText().contains("@")) {
			throw new InvalidUserException("\"Debe tener domimio\"");
		}
		
	}
	private void evaluarContrasena() throws InvalidUserException {
		resetearCredenciales();
		if(String.valueOf(login.getContraseña().getPassword()).equals("") ){
			throw new InvalidUserException("* Contraseña obligatoria *");
		}
	}
}


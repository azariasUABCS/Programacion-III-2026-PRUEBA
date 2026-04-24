package controllers;

import java.awt.Window;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import exceptions.InvalidUserException;
import modelos.User;
import respository.UserRepository;
import views.FormularioRegistro;
import views.Login;
import views.VentanaPrincipal;

public class LoginController {
	
	private Login login = new Login();
	public LoginController(Login login) {
		this.login=login;
		
		addActionListeners();
		addDocumentListeners();
	}
	private void resetearCredenciales() {
		login.getMensajeCorreo().setText(" ");
		login.getMensajeContraseña().setText(" ");
	}
	
	private void addActionListeners() {
		
		login.getButtonIniciar().addActionListener(e -> {
			try {
				evaluarCredenciales();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		login.getRegistrarse().addActionListener(e -> {	
			new RegistroController();			
		});
	}
	
	private void evaluarCredenciales() throws IOException {
		resetearCredenciales();
		boolean error=false;
		Window window=login.getWindow();
		try {
			evaluarCorreo();
		}catch(InvalidUserException ex){
			login.getMensajeCorreo().setText("* Credenciales erroneas *");
			error=true;
		}
		try {
			evaluarContrasena();
		}catch(InvalidUserException ex){
			login.getMensajeCorreo().setText("* Credenciales erroneas *");
			error=true;
		}
		if(error==false) {
			new VentanaPrincipalController(new VentanaPrincipal());
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
		if(login.getUsuario().getText().trim().equals("")) {
			throw new InvalidUserException("* Correo obligatorio *");
		}
		else if(!existeCuenta(login.getUsuario().getText().trim(), login.getContraseña().getText().trim())) // PAPITA CAMBIE ESTO PARA VERIFICAR. Codigo original: !login.getUsuario().getText().trim().equals("")&&!login.getUsuario().getText().equals("papita@gmail.com")
		{
			throw new InvalidUserException("* Correo erroneo *");
		}
		
	}
	private void evaluarCorreoRT() throws InvalidUserException {
		resetearCredenciales();
		if(login.getUsuario().getText().equals("") || login.getUsuario().getText().equals("Correo Electrónico")) {
			throw new InvalidUserException("* Correo obligatorio *");
		}
		if(!login.getUsuario().getText().equals("")&&!login.getUsuario().getText().contains("@")) {
			throw new InvalidUserException("\"Debe tener domimio\"");
		}
		
	}
	private void evaluarContrasena() throws InvalidUserException {
		resetearCredenciales();
		if(String.valueOf(login.getContraseña().getPassword()).equals("") || String.valueOf(login.getContraseña().getPassword()).equals("Contraseña")){
			throw new InvalidUserException("* Contraseña obligatoria *");
		}
	}
	
	
	// Regresa true si el correo y contrasena que ingreso el usuario se encuentra el usuario en el archivo scr/files/users.csv
	private boolean existeCuenta(String correo, String contrasena)
	{
		UserRepository repository = new UserRepository();
		try 
		{
			List<User> users = repository.getUsers(); 
			
			for(User user : users) 
			{
				if(user.getCorreo().equals(correo) && user.getContrasena().equals(contrasena))
				{
					System.out.println("Ingresado por Usuario: " + correo + " / " + contrasena);
					System.out.println("Usuario Registrado en Sistem: " + user.getCorreo() + " / " + user.getContrasena() + "\n");
					return true; 
				}
			}
		} 
		catch (IOException ex) 
		{
			
		}
		
		return false;
	}
}


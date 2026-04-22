package controllers;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import modelos.User;
import utils.Colores;
import views.FormularioRegistro;
import views.Ventana;


public class RegistroController {

	private FormularioRegistro formularioRegsitro;
	
	public RegistroController()
	{
		formularioRegsitro = new FormularioRegistro();
		formularioRegsitro.registrar.addActionListener(e -> validacionDeRegistro());
		
		addWindowListener();
		
        asignarKeyListener(formularioRegsitro.nombres);
        asignarKeyListener(formularioRegsitro.apellidos); 
        
		asignarValidacion(formularioRegsitro.nombres); 
        asignarValidacion(formularioRegsitro.apellidos);
        asignarValidacion(formularioRegsitro.correo);
        asignarValidacion(formularioRegsitro.contraseña);
	}
	
	private void addWindowListener()
	{
			formularioRegsitro.getWindow().addWindowListener(new WindowListener() {
				
				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
					((JFrame) formularioRegsitro.getWindow()).getContentPane().setBackground(Color.GRAY);
					
				}

				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					((JFrame) formularioRegsitro.getWindow()).getContentPane().setBackground(Colores.BACKGROUND);
				}
				
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowClosed(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
	}
			
	
// Validaciones de Formulario Registro
    
	private void validacionDeRegistro()
    {
    	formularioRegsitro.resetearErrorLabels();

		boolean valid = true;

		if (!validarNombre()) { valid = false; }
		if (!validarApellido()) { valid = false; }
		if (!validarCorreo()) { valid = false; }
		if (!validarConstasena()) { valid = false; }
		
		if (valid) 
		{
			String nombre = formularioRegsitro.getNombre();
			String apellido = formularioRegsitro.getApellido();
			String correo = formularioRegsitro.getCorreo();
			String contrasena = formularioRegsitro.getContraseña();
			
			formularioRegsitro.registerUser(new User(nombre, apellido, correo, contrasena));
			new Ventana();
			formularioRegsitro.getWindow().dispose();
		}
		
    }
	
	public boolean validarNombre() 
    {
    	String nombre = formularioRegsitro.nombres.getText().trim();
    	
    	if (nombre.isEmpty() || nombre.equals("Nombre")) 
    	{
    		formularioRegsitro.lblErrorNombre.setText("El nombre es obligatorio");
			return false;
		} else {
			formularioRegsitro.lblErrorNombre.setText("");
		}

		return true;
    }
	
    public boolean validarApellido()
    {
    	String apellido = formularioRegsitro.apellidos.getText().trim();
    	
    	if (apellido.isEmpty() || apellido.equals("Apellido")) 
    	{
    		formularioRegsitro.lblErrorApellido.setText("El apellido es obligatorio");
			return false;
		} else {
			formularioRegsitro.lblErrorApellido.setText("");
		}

		return true;
    }
    
    public boolean validarCorreo()
    {
    	String correo = formularioRegsitro.correo.getText().trim();
    	
    	if (correo.isEmpty() || correo.equals("correo@ejemplo.com")) 
    	{
    		formularioRegsitro.lblErrorCorreo.setText("El email es obligatorio");
			return false;
		}
    	
    	if (correo.length() < 5) 
    	{
    		formularioRegsitro.lblErrorCorreo.setText("Email inválido! Es muy corto.");
    	    return false;
    	}

		if (!correo.contains("@")) 
		{
			formularioRegsitro.lblErrorCorreo.setText("Email inválido! Le falta @");
			return false;
		}
		
		if (!correo.contains(".com")) 
		{
			formularioRegsitro.lblErrorCorreo.setText("Email inválido! Le falta un '.com'");
			return false;
		}
		
		// Validación adicional para dominio
		String[] parts = correo.split("@");
		if (parts.length != 2 || !parts[1].contains(".")) {
			formularioRegsitro.lblErrorCorreo.setText("Email inválido! Formato incorrecto");
			return false;
		}
		
		formularioRegsitro.lblErrorCorreo.setText("");
		return true;
    }
    
    public boolean validarConstasena()
    {
    	String contrasena = formularioRegsitro.contraseña.getText();
    	
    	if (contrasena.isEmpty() || contrasena.equals("Contraseña")) 
    	{
    		formularioRegsitro.lblErrorContrasena.setText("La contraseña es obligatoria");
			return false;
		}
    	
    	if (contrasena.length() < 5) 
    	{
    		formularioRegsitro.lblErrorContrasena.setText("La contraseña es muy corta, mínimo 5 caracteres");
    	    return false;
    	}
    	
    	if (!contrasena.matches(".*[!$?_*].*")) // Regex que checa que por lo menos hay uno de estos char
    	{
    		formularioRegsitro.lblErrorContrasena.setText("Necesita un caracter especial (! $ ? _ *)");
    	    return false;
    	}
    	
    	if (contrasena.matches(".*\\s.*")) // Regex que checa si hay espacios entre texto
    	{
    		formularioRegsitro.lblErrorContrasena.setText("La contraseña no puede tener espacios");
    	    return false;
    	}

    	formularioRegsitro.lblErrorContrasena.setText("");
		return true;
    }
    
    private void asignarValidacion(JTextField JtextField)
    {
    	
    	switch(JtextField.getName().toString())
    	{
    		case "nombres":
    			JtextField.getDocument().addDocumentListener(new DocumentListener() {
    				
    				@Override
    				public void removeUpdate(DocumentEvent e) {
    					validarNombre();
    				}
    				
    				@Override
    				public void insertUpdate(DocumentEvent e) {
    					validarNombre();
    				}
    				
    				@Override
    				public void changedUpdate(DocumentEvent e) {
    					validarNombre();
    				}
    			});
    			break;
    			
    		case "apellidos":
    			JtextField.getDocument().addDocumentListener(new DocumentListener() {
    					
    					@Override
    					public void removeUpdate(DocumentEvent e) {
    						validarApellido();
    					}
    					
    					@Override
    					public void insertUpdate(DocumentEvent e) {
    						validarApellido();
    					}
    					
    					@Override
    					public void changedUpdate(DocumentEvent e) {
    						validarApellido();
    					}
    				});
    			break;
    			
    		case "correo":
    			 JtextField.getDocument().addDocumentListener(new DocumentListener() {
    					
    					@Override
    					public void removeUpdate(DocumentEvent e) {
    						validarCorreo();
    					}
    					
    					@Override
    					public void insertUpdate(DocumentEvent e) {
    						validarCorreo();
    					}
    					
    					@Override
    					public void changedUpdate(DocumentEvent e) {
    						validarCorreo();
    					}
    				});
    			break;
    			
    		case "contraseña":
    			formularioRegsitro.contraseña.getDocument().addDocumentListener(new DocumentListener() {
    				
    				@Override
    				public void removeUpdate(DocumentEvent e) {
    					validarConstasena();
    				}
    				
    				@Override
    				public void insertUpdate(DocumentEvent e) {
    					validarConstasena();
    				}
    				
    				@Override
    				public void changedUpdate(DocumentEvent e) {
    					validarConstasena();
    				}
    			});
    			break;
    	}
    }
    
    private void asignarKeyListener(JTextField JtextField)
    {
    	JtextField.addKeyListener(new KeyAdapter() 
         {
         	public void keyTyped(KeyEvent e)
         	{
         		// Solo para nombres y apellidos, no para correo y contraseña
         		if (JtextField.getName().equals("nombres") || JtextField.getName().equals("apellidos")) {
         			if(!Character.isSpaceChar(e.getKeyChar()))
         			{
         				if(Character.isDigit(e.getKeyChar()) || !Character.isAlphabetic(e.getKeyChar()))
         				{
         					e.consume();
         				}
         			}
         		}
         		
         		if(JtextField.getText().length() >= 20)
         		{
         			e.consume();
         		}
         	}
 		});
    }
    
}
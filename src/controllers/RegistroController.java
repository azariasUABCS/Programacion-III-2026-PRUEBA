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

import utils.Colores;
import views.FormularioRegistro;


public class RegistroController {

	private FormularioRegistro formularioRegsitro;
	
	public RegistroController()
	{
		formularioRegsitro = new FormularioRegistro();
		formularioRegsitro.registrar.addActionListener(e -> validacionDeRegistro());
		
		addWindowListener();
		
        asignarKeyListener(formularioRegsitro.nombres); // Es la nueva funcion que agregue.
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
					((JFrame) formularioRegsitro.getWindow()).getContentPane().setBackground(Colores.BLACKBERRY_CREAM);
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
		if (!validarCorreo()) { valid = false; }
		if (!validarConstasena()) { valid = false; } 
		if (!validarApellido())	{ valid = false; }
		
		if (valid) 
		{
			formularioRegsitro.callJOptionPane();
			
			// Use el dispose que habias puesto en addActionListener
			formularioRegsitro.getWindow().dispose();
		}
		
    }
	
	public boolean validarNombre()
    {
    	if (formularioRegsitro.nombres.getText().trim().isEmpty()) 
    	{
    		formularioRegsitro.lblErrorNombre.setText("El nombre es obligatorio");
			return false;
		}else {
			formularioRegsitro.lblErrorNombre.setText(" ");
		}

		return true;
    }
	
    public boolean validarApellido()
    {
    	if (formularioRegsitro.apellidos.getText().trim().isEmpty()) 
    	{
    		formularioRegsitro.lblErrorApellido.setText("El apellido es obligatorio");
			return false;
		}else {
			formularioRegsitro.lblErrorApellido.setText(" ");
		}

		return true;
    }
    
    public boolean validarCorreo()
    {
    	if (formularioRegsitro.correo.getText().trim().isEmpty()) 
    	{
    		formularioRegsitro.lblErrorCorreo.setText("El email es obligatorio");
			return false;
		}else {
			formularioRegsitro.lblErrorCorreo.setText(" ");
		}
    	
    	if (formularioRegsitro.correo.getText().trim().length() < 3) 
    	{
    		formularioRegsitro.lblErrorContrasena.setText("Email inválido! Es muy corta.");
    	    return false;
    	}else {
    		formularioRegsitro.lblErrorContrasena.setText(" ");
		}

		if (!formularioRegsitro.correo.getText().contains("@")) 
		{
			formularioRegsitro.lblErrorCorreo.setText("Email inválido! Le falta @");
			return false;
		}else {
			formularioRegsitro.lblErrorCorreo.setText(" ");
		}

		return true;
    }
    
    public boolean validarConstasena()
    {
    	if (formularioRegsitro.contraseña.getText().trim().isEmpty()) 
    	{
    		formularioRegsitro.lblErrorContrasena.setText("La contraseña es obligatorio");
			return false;
		}else {
			formularioRegsitro.lblErrorContrasena.setText(" ");
		}
    	
    	if (formularioRegsitro.contraseña.getText().trim().length() < 5) 
    	{
    		formularioRegsitro.lblErrorContrasena.setText("La contraseña es muy corta, minimo 5 characteres");
    	    return false;
    	}else {
    		formularioRegsitro.lblErrorContrasena.setText(" ");
		}
    	
    	if (!formularioRegsitro.contraseña.getText().matches(".*[!$?_*].*")) // Regex que checa que por lo menos hay uno de estos char
    	{
    		formularioRegsitro.lblErrorContrasena.setText("Necesita un caracter especial (! $ ? _ *)");
    	    return false;
    	}else {
    		formularioRegsitro.lblErrorContrasena.setText(" ");
		}
    	
    	if (formularioRegsitro.contraseña.getText().trim().matches(".*\\s.*")) // Regex que checa si hay espacios entre texto
    	{
    		formularioRegsitro.lblErrorContrasena.setText("La contraseña no puede tener espacios");
    	    return false;
    	}else {
    		formularioRegsitro.lblErrorContrasena.setText(" ");
		}

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
    					// TODO Auto-generated method stub
    					validarNombre();
    				}
    				
    				@Override
    				public void insertUpdate(DocumentEvent e) {
    					// TODO Auto-generated method stub
    					validarNombre();
    				}
    				
    				@Override
    				public void changedUpdate(DocumentEvent e) {
    					// TODO Auto-generated method stub
    					validarNombre();
    				}
    			});
    			break;
    			
    		case "apellidos":
    			JtextField.getDocument().addDocumentListener(new DocumentListener() {
    					
    					@Override
    					public void removeUpdate(DocumentEvent e) {
    						// TODO Auto-generated method stub
    						validarApellido();
    					}
    					
    					@Override
    					public void insertUpdate(DocumentEvent e) {
    						// TODO Auto-generated method stub
    						validarApellido();
    					}
    					
    					@Override
    					public void changedUpdate(DocumentEvent e) {
    						// TODO Auto-generated method stub
    						validarApellido();
    					}
    				});
    			break;
    			
    		case "correo":
    			 JtextField.getDocument().addDocumentListener(new DocumentListener() {
    					
    					@Override
    					public void removeUpdate(DocumentEvent e) {
    						// TODO Auto-generated method stub
    						validarCorreo();
    					}
    					
    					@Override
    					public void insertUpdate(DocumentEvent e) {
    						// TODO Auto-generated method stub
    						validarCorreo();
    					}
    					
    					@Override
    					public void changedUpdate(DocumentEvent e) {
    						// TODO Auto-generated method stub
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
    					// TODO Auto-generated method stub
    					validarConstasena();
    				}
    				
    				@Override
    				public void changedUpdate(DocumentEvent e) {
    					// TODO Auto-generated method stub
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
         		
         		if(!Character.isSpaceChar(e.getKeyChar()))
         		{
         			if(Character.isDigit(e.getKeyChar()) || !Character.isAlphabetic(e.getKeyChar()))
         			{
         				e.consume();
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

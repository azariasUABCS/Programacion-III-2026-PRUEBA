package controllers;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import modelos.User;
import respository.UserRepository;
import utils.Colores;
import views.UserFormDialog;
import views.Ventana;

public class UserDialogController {

	private UserFormDialog userFromDialog;
	
	public UserDialogController(UserFormDialog userFromDialog) // Agregar nuevo user?
	{
		this.userFromDialog = userFromDialog;
		
		userFromDialog.btnGuardar.addActionListener(e -> {
			try {
				validacionDeRegistro();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		});
		
		addWindowListener();
		
        asignarKeyListener(userFromDialog.txtNombre);
        asignarKeyListener(userFromDialog.txtApellido); 
        
		asignarValidacion(userFromDialog.txtNombre); 
        asignarValidacion(userFromDialog.txtApellido);
        asignarValidacion(userFromDialog.txtCorreo);
        
	}
	
	public UserDialogController(UserFormDialog userFromDialog, User user) // Para actulizar user?
	{
		this.userFromDialog = userFromDialog;
		this.userFromDialog.setUser(user);
		userFromDialog.btnGuardar.addActionListener(e -> {
			try {
				validacionDeActualizacion();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		addWindowListener();
		
        asignarKeyListener(userFromDialog.txtNombre);
        asignarKeyListener(userFromDialog.txtApellido); 
        
		asignarValidacion(userFromDialog.txtNombre); 
        asignarValidacion(userFromDialog.txtApellido);
        asignarValidacion(userFromDialog.txtCorreo);
        this.userFromDialog.txtApellido.setText(this.userFromDialog.getUser().getApellido());
        this.userFromDialog.txtNombre.setText(user.getNombre());
        this.userFromDialog.txtCorreo.setText(user.getCorreo());
        this.userFromDialog.txtContraseña.setText(user.getContrasena());
        this.userFromDialog.btnGuardar.setText("Editar");
	}
	
	
	private void addWindowListener()
	{
				userFromDialog.getWindow().addWindowListener(new WindowListener() {
				
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
					((JDialog) userFromDialog.getWindow()).getContentPane().setBackground(Color.GRAY);
					
				}

				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					((JDialog) userFromDialog.getWindow()).getContentPane().setBackground(Colores.BACKGROUND);
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
				
				userFromDialog.btnCancelar.addActionListener(e -> handleClose());
				
				userFromDialog.addWindowListener(new WindowAdapter() 
				{
					@Override
					public void windowClosing(WindowEvent e) 
					{
						handleClose();
					}
				});
		
	}
	
	private void handleClose() {
		int option = userFromDialog.confirmExit();
		System.out.println(option);

		if (option == JOptionPane.YES_OPTION) {
			userFromDialog.getWindow().dispose();
		}
	}

	private void validacionDeActualizacion() throws IOException
    {
		boolean valid = true;

		if (!validarNombre()) { valid = false; }
		if (!validarApellido()) { valid = false; }
		if (!validarCorreo()) { valid = false; }
		if (!validarContraseña()) { valid = false; }

		
		if (valid) 
		{
			userFromDialog.getUser().setNombre(userFromDialog.txtNombre.getText());
			userFromDialog.getUser().setApellido(userFromDialog.txtApellido.getText());
			userFromDialog.getUser().setCorreo(userFromDialog.txtCorreo.getText());
			
			String nuevaContesena = new String(userFromDialog.getTxtContraseña().getPassword());
			userFromDialog.getUser().setContrasena(nuevaContesena);
			
			userFromDialog.setGuardado(true);
			
			
			userFromDialog.getWindow().dispose();
		}
		
    }
	private void validacionDeRegistro() throws IOException
    {
		boolean valid = true;

		if (!validarNombre()) { valid = false; }
		if (!validarApellido()) { valid = false; }
		if (!validarCorreo()) { valid = false; }
		if (!validarContraseña()) { valid = false; }

		
		if (valid) 
		{
			userFromDialog.setUser(new User("a", "a", "a", "a"));
			userFromDialog.getUser().setNombre(userFromDialog.txtNombre.getText());
			userFromDialog.getUser().setApellido(userFromDialog.txtApellido.getText());
			userFromDialog.getUser().setCorreo(userFromDialog.txtCorreo.getText());
			
			String nuevaContesena = new String(userFromDialog.getTxtContraseña().getPassword());
			userFromDialog.getUser().setContrasena(nuevaContesena);
			userFromDialog.setGuardado(true);
			
			//userFromDialog.agregarUser(nombre, apellido, correo, contraseña);
			userFromDialog.getWindow().dispose();
		}
		
    }
	
	public boolean validarNombre() 
    {
    	if (userFromDialog.txtNombre.getText().trim().isEmpty()) 
    	{
    		userFromDialog.txtErrNombre.setText("El nombre es obligatorio");
			return false;
		}else {
			userFromDialog.txtErrNombre.setText(" ");
		}

		return true;
    }
	
	public boolean validarContraseña() 
    {
		String contraseña = new String(userFromDialog.getTxtContraseña().getPassword());
    	if (contraseña.isEmpty()) 
    	{
    		userFromDialog.getTxtErrContraseña().setText("La contraseña es obligatorio");
			return false;
		}else if (!contraseña.matches(".*[!$?_*].*")) 
    	{
    		userFromDialog.getTxtErrContraseña().setText("Necesita un caracter especial (! $ ? _ *)");
			return false;
		}else if (contraseña.matches(".*\\s.*")) 
    	{
    		userFromDialog.getTxtErrContraseña().setText("No debe tener espacios");
			return false;
		}else{
			userFromDialog.getTxtErrContraseña().setText(" ");
		}

		return true;
    }
	
    public boolean validarApellido()
    {
    	if (userFromDialog.txtApellido.getText().trim().isEmpty()) 
    	{
    		userFromDialog.txtErrApellido.setText("El apellido es obligatorio");
			return false;
		}else {
			userFromDialog.txtErrApellido.setText(" ");
		}

		return true;
    }
    
    public boolean validarCorreo()
    {
    	if (userFromDialog.txtCorreo.getText().trim().isEmpty()) 
    	{
    		userFromDialog.txtErrCorreo.setText("El email es obligatorio");
			return false;
		}else {
			userFromDialog.txtErrCorreo.setText(" ");
		}
    	
    	if (userFromDialog.txtCorreo.getText().trim().length() < 3) 
    	{
    		userFromDialog.txtErrCorreo.setText("Email inválido! Es muy corta.");
    	    return false;
    	}else {
    		userFromDialog.txtErrCorreo.setText(" ");
		}

		if (!userFromDialog.txtCorreo.getText().contains("@")) 
		{
			userFromDialog.txtErrCorreo.setText("Email inválido! Le falta @");
			return false;
		}else 
		{
			userFromDialog.txtErrCorreo.setText(" ");
		}
		
		if (!userFromDialog.txtCorreo.getText().contains(".com")) 
		{
			userFromDialog.txtErrCorreo.setText("Email inválido! Le falta .com");
			return false;
		}else 
		{
			userFromDialog.txtErrCorreo.setText(" ");
		}

		return true;
    }
    
    
    private void asignarValidacion(JTextField JtextField)
    {
    	
    	switch(JtextField.getText())
    	{
    		case "txtNombre":
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
    			
    		case "txtApellido":
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
    			
    		case "txtCorreo":
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

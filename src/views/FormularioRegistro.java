package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import utils.Colores;

public class FormularioRegistro extends JFrame{
    
	// Puro Fonts, ya depues hare otra clase de Fonts
    public Font fuente;
    private Font fontError = new Font("Times New Roman", Font.ITALIC, 11);
    private Font fontTexto = new Font("Times New Roman", Font.BOLD, 15);
    private Font fontTextoCampo = new Font("Times New Roman", Font.BOLD, 15);
    private Font fontBoton = new Font("Times New Roman", Font.BOLD, 15);
    private Font fontTitulo = new Font("Times New Roman", Font.BOLD, 35);
    
    
    // Fields de Texto para Usuario
    JTextField nombres;
    JTextField apellidos;
    JTextField correo;
    JTextField contraseña;
    
    
    // Labels de Error
    private JLabel lblErrorNombre;
    private JLabel lblErrorApellido;
    private JLabel lblErrorCorreo;
    private JLabel lblErrorContrasena;
    
    
    
    public FormularioRegistro()
    {
        setSize(350, 550);
        setLayout(null);
        setResizable(false);
        setTitle("Registro");
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(Colores.BLACKBERRY_CREAM);
        
        
        PanelPersonalizable fondo = new PanelPersonalizable();
        fondo.setBounds(30, 50, 280, 420);
        fondo.setBackground(Colores.MIDNIGHT_VIOLET);
        
        PanelPersonalizable fondo2 = new PanelPersonalizable();
        fondo2.setBounds(35, 55, 280, 420);
        fondo2.setBackground(new Color(44, 0, 47));
        

        JPanel panelComponentes = new JPanel();
        panelComponentes.setLayout(new BoxLayout(panelComponentes, BoxLayout.Y_AXIS));
        panelComponentes.setBounds(0, 50, 340, 440);
        panelComponentes.setOpaque(false);
        panelComponentes.setBorder(new EmptyBorder(20, 40, 20, 40));
        
        // Para centrar todos los componentes
        panelComponentes.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        JLabel saludo = new JLabel("Registrate");
        saludo.setOpaque(false);
        saludo.setFont(fontTitulo);
        saludo.setForeground(Color.WHITE);
        saludo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panelComponentes.add(saludo);
        panelComponentes.add(Box.createRigidArea(new Dimension(0,20)));

        lblErrorNombre = crearErrorLabel();
        lblErrorApellido = crearErrorLabel();
        lblErrorCorreo = crearErrorLabel();
        lblErrorContrasena = crearErrorLabel();
        
        
        // Panel para las indicaciones de nombres
        JLabel indicaciones = new JLabel("Nombre          Apellidos");
        indicaciones.setForeground(Colores.WHITE);
        indicaciones.setFont(fontTexto);
        indicaciones.setAlignmentX(Component.CENTER_ALIGNMENT); // Otra vez centrar
        panelComponentes.add(indicaciones);

        
        // Panel para los campos de nombres y apellidos
        JPanel panelNombres = new JPanel();
        panelNombres.setLayout(new BoxLayout(panelNombres, BoxLayout.X_AXIS));
        panelNombres.setOpaque(false);
        panelNombres.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panelNombres.setMaximumSize(new Dimension(260, 60));
        panelNombres.setPreferredSize(new Dimension(260, 60));
        
        nombres = crearTextField("nombres");
        asignarValidacion(nombres); // Es la nueva funcion que agregue.
        
        
        
        apellidos = crearTextField("apellidos");
        asignarValidacion(apellidos);
        
        
        panelNombres.add(nombres);
        panelNombres.add(Box.createRigidArea(new Dimension(5, 0)));
        panelNombres.add(apellidos);
        panelComponentes.add(panelNombres);
        
        
        
        // Panel de errores de nombres
        JPanel panelErroresNombres = new JPanel();
        panelErroresNombres.setLayout(new BoxLayout(panelErroresNombres, BoxLayout.X_AXIS));
        panelErroresNombres.setOpaque(false);
        panelErroresNombres.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panelErroresNombres.setMaximumSize(new Dimension(260, 20));
        
        configurarErrorLabel(lblErrorNombre, 125, 20);
        configurarErrorLabel(lblErrorApellido, 125, 20);
        
        panelErroresNombres.add(lblErrorNombre);
        panelErroresNombres.add(Box.createRigidArea(new Dimension(10, 0)));
        panelErroresNombres.add(lblErrorApellido);
        
        panelComponentes.add(panelErroresNombres);
        panelComponentes.add(Box.createRigidArea(new Dimension(0,10)));

        
        // Campo de Correo
        JLabel indicacionCorreo = new JLabel("Correo");
        indicacionCorreo.setFont(fontTexto);
        indicacionCorreo.setForeground(Colores.WHITE);
        indicacionCorreo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelComponentes.add(indicacionCorreo);
        
        correo = crearTextField("correo");
        asignarValidacion(correo);

        
        panelComponentes.add(correo);
        
        configurarErrorLabel(lblErrorCorreo, 260, 20);
        lblErrorCorreo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelComponentes.add(lblErrorCorreo);
        
        panelComponentes.add(Box.createRigidArea(new Dimension(0,10)));

        
        // Campo de Contraseña
        JLabel indicacionContraseña = new JLabel("Contraseña");
        indicacionContraseña.setFont(fontTexto);
        indicacionContraseña.setForeground(Colores.WHITE);
        indicacionContraseña.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelComponentes.add(indicacionContraseña);
        
        contraseña = crearTextField("contraseña");
        asignarValidacion(contraseña);
        
        
        panelComponentes.add(contraseña);
        
        configurarErrorLabel(lblErrorContrasena, 260, 20);
        lblErrorContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelComponentes.add(lblErrorContrasena);
        
        panelComponentes.add(Box.createRigidArea(new Dimension(0,15)));
        
        
        // Button Registrar
        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new BoxLayout(panelBoton, BoxLayout.Y_AXIS));
        panelBoton.setOpaque(false);
        panelBoton.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        JButton registrar = new JButton("Registrarse");
        crearBoton(registrar, "..\\img\\icono.png");
        
        registrar.addActionListener(e -> validacionDeRegistro());
        
        registrar.addMouseListener(new MouseAdapter() 
        {
			public void mouseEntered(MouseEvent e) 
			{
				changeBackground(registrar);
			}
			
			public void mouseExited(MouseEvent e) 
			{
				resetBackground(registrar);
			}
		});
        
        panelBoton.add(registrar);
        panelComponentes.add(panelBoton);
        
        add(panelComponentes);
        add(fondo);
        add(fondo2);

        setVisible(true);
    }
    
    private void configurarErrorLabel(JLabel label, int ancho, int alto) 
    {
        label.setPreferredSize(new Dimension(ancho, alto));
        label.setMaximumSize(new Dimension(ancho, alto));
        label.setMinimumSize(new Dimension(ancho, alto));
        label.setHorizontalAlignment(SwingConstants.LEFT);
    }
    
    private JTextField crearTextField(String JTextFieldName) 
    {
        JTextField textField = new JTextField();
        textField.setMaximumSize(new Dimension(260, 40));
        textField.setPreferredSize(new Dimension(260, 40));
        textField.setBackground(Colores.BLACKBERRY_CREAM);
        textField.setForeground(Color.WHITE);
        textField.setFont(fontTextoCampo);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        textField.setName(JTextFieldName);
        
        return textField;
    }
    
    private void crearBoton(JButton button, String ruta)
    {
        button.setBackground(Colores.WHITE);
        button.setForeground(Color.black);
        button.setToolTipText("Registrarse");
        button.setFont(fontBoton);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(200, 40));
        button.setPreferredSize(new Dimension(200, 40));
        
        try 
        {
            Image icono = ImageIO.read(getClass().getResource(ruta));
            icono = icono.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(icono));
        }
        catch (Exception ex)
        {
            System.out.println("No se pudo poner el icono");
        }
    }
    
    private JLabel crearErrorLabel() 
    {
        JLabel label = new JLabel("");
        label.setFont(fontError);
        label.setForeground(Color.RED);
        return label;
    }
    
    
    
    // Validaciones de Formulario Registro
    
    private void validacionDeRegistro()
    {
    	resetearErrorLabels();

		boolean valid = true;

		if (!validarNombre())  valid = false;

		if (!validarApellido())  valid = false;
		
		if (!validarCorreo())  valid = false;
		
		if (!validarConstasena())  valid = false;
		
		
		if (valid) {
			JOptionPane.showMessageDialog(this, "Registro exitoso");
			
			dispose(); // Use el dispose que habias puesto en addActionListener
		}
    }
    
    private void resetearErrorLabels() 
    {
		lblErrorNombre.setText("");
		lblErrorApellido.setText("");
		lblErrorCorreo.setText("");
		lblErrorContrasena.setText("");
	}
    
    
    private boolean validarNombre()
    {
    	if (nombres.getText().trim().isEmpty()) 
    	{
    		lblErrorNombre.setText("El nombre es obligatorio");
			return false;
		}else {
			lblErrorNombre.setText(" ");
		}

		return true;
    }
    
    private boolean validarApellido()
    {
    	if (apellidos.getText().trim().isEmpty()) 
    	{
    		lblErrorApellido.setText("El apellido es obligatorio");
			return false;
		}else {
			lblErrorApellido.setText(" ");
		}

		return true;
    }
    
    private boolean validarCorreo()
    {
    	if (correo.getText().trim().isEmpty()) 
    	{
			lblErrorCorreo.setText("El email es obligatorio");
			return false;
		}else {
			lblErrorCorreo.setText(" ");
		}

		if (!correo.getText().contains("@")) 
		{
			lblErrorCorreo.setText("Email inválido");
			return false;
		}else {
			lblErrorCorreo.setText(" ");
		}

		return true;
    }
    
    private boolean validarConstasena()
    {
    	if (contraseña.getText().trim().isEmpty()) 
    	{
    		lblErrorContrasena.setText("La contraseña es obligatorio");
			return false;
		}else {
			lblErrorContrasena.setText(" ");
		}
    	
    	if (!contraseña.getText().matches(".*[!$?_*].*")) // Regex que checa que por lo menos hay uno de estos char
    	{
    	    lblErrorContrasena.setText("Necesita un caracter especial (! $ ? _ *)");
    	    return false;
    	}else {
			lblErrorContrasena.setText(" ");
		}
    	
    	if (contraseña.getText().trim().matches(".*\\s.*")) // Regex que checa si hay espacios entre texto
    	{
    		lblErrorContrasena.setText("La contraseña no puede tener espacios");
    	    return false;
    	}else {
			lblErrorContrasena.setText(" ");
		}

		return true;
    }
    
    private void asignarValidacion(JTextField JtextField)
    {
    	System.out.println(JtextField.getName());
    	
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
    			contraseña.getDocument().addDocumentListener(new DocumentListener() {
    				
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
    
    Color defaultColor = null;
	Color clickedColor = Color.GRAY;
	
	private void changeBackground(JComponent c)
	{
		defaultColor = c.getBackground();
		
		c.setBackground(clickedColor);
		c.setForeground(Color.WHITE);
	}
	
	private void resetBackground(JComponent c)
	{
		c.setBackground(defaultColor);
		c.setForeground(Color.BLACK);
	}
}
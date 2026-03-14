package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import utils.Colores;


public class Login extends JPanel{

	public int x;
	public int y;
	public boolean logrado;
	private Font fontTexto = new Font("Times New Roman", Font.BOLD, 17);
	private Font fontBoton = new Font("Times New Roman", Font.BOLD, 17);
	private Font fontTitulo = new Font("Times New Roman", Font.BOLD, 30);
	JLabel mensajeCorreo = new JLabel(" ");
	JLabel mensajeContraseña = new JLabel(" ");
	JTextField usuario = new JTextField(30);
	JPasswordField contraseña = new JPasswordField(30);
	
	public Login(){	
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(50,50,50,50));
		
		configurarMensajes();
		configurarTextos();
		
		JLabel saludo = new JLabel("  Bienvenido!");
		saludo.setForeground(Colores.WHITE);
		saludo.setFont(fontTitulo);
		add(saludo);
		
		add(mensajeCorreo);
		
		
		add(usuario);
		add(Box.createRigidArea(new Dimension(0,20)));
		add(mensajeContraseña);
		
		add(contraseña);
		add(Box.createRigidArea(new Dimension(0,40)));
		
		PanelPersonalizable botones = new PanelPersonalizable();
		botones.setLayout(new BoxLayout(botones, BoxLayout.Y_AXIS));
		botones.setBackground(Colores.MIDNIGHT_VIOLET);
		botones.setBorder(new EmptyBorder(0,15,0,0));
		
		JButton buttonIniciar = new JButton("Iniciar Sesión");
		crearBoton(buttonIniciar, "..\\img\\login.png", "Clic para Iniciar Sesión!");
		buttonIniciar.addActionListener(e -> evaluarCredenciales());
		
		botones.add(buttonIniciar);
		
		buttonIniciar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				changeBackground(buttonIniciar);
			}
			
			public void mouseExited(MouseEvent e) 
			{
				resetBackground(buttonIniciar);
			}
		});
		
		
		
		JButton Registrarse = new JButton(" Registrarse   ");
		crearBoton(Registrarse, "..\\img\\enter.png", "Clic para Registrarse!");
		Registrarse.addActionListener(e -> new FormularioRegistro());
		
		Registrarse.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				changeBackground(Registrarse);
			}
			
			public void mouseExited(MouseEvent e) 
			{
				resetBackground(Registrarse);
			}
		});
		
		add(botones);
		botones.add(Box.createRigidArea(new Dimension(0, 12))); // Espacio de 12 píxeles
		botones.add(Registrarse);
	}
	
	
	private void resetearCredenciales() {
		mensajeCorreo.setText(" ");
		mensajeContraseña.setText(" ");
	}
	
	private void evaluarCredenciales() {
		resetearCredenciales();
		boolean error=false;
		Window window=SwingUtilities.getWindowAncestor(this);
		if(usuario.getText().equals("")) {
			mensajeCorreo.setText("* Correo obligatorio *");
			error=true;
			
		}
		if(contraseña.getPassword().length==0) {
			mensajeContraseña.setText("* Contraseña obligatoria *");
			error=true;
		}
		if(error==false) {
			new VentanaPrincipal();
			window.dispose();
		}
		
	}
	private void evaluarCorreo() {
		if(usuario.getText().equals("")) {
			mensajeCorreo.setText("* Correo obligatorio *");
		}else {
			mensajeCorreo.setText(" ");
		}
	}
	private void evaluarContrasena() {
		if(contraseña.getPassword().length==0) {
			mensajeContraseña.setText("* Contraseña obligatorio *");
		}else {
			mensajeContraseña.setText(" ");
		}
	}
	private void configurarMensajes() {
		
		mensajeCorreo.setForeground(Color.RED);
		mensajeCorreo.setFont(fontTexto);
		mensajeCorreo.setVisible(true);
		
		mensajeContraseña.setForeground(Color.RED);
		mensajeContraseña.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mensajeContraseña.setVisible(true);
	}
	private void configurarTextos() {
		
		
		usuario.setFont(fontTexto);
		usuario.setBackground(Colores.BLACKBERRY_CREAM);
        usuario.setForeground(Color.WHITE);
		usuario.setMaximumSize(new Dimension(670,50));
		
		usuario.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				evaluarCorreo();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				evaluarCorreo();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				evaluarCorreo();
			}
		});
		usuario.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				usuario.setBackground(Colores.BLACKBERRY_CREAM);
		        usuario.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				usuario.setBackground(Color.WHITE);
		        usuario.setForeground(Color.BLACK);
			}
		});
		
		
		contraseña.setFont(fontTexto);
		contraseña.setBackground(Colores.BLACKBERRY_CREAM);
        contraseña.setForeground(Color.WHITE);
		contraseña.setMaximumSize(new Dimension(670,50));
		contraseña.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				evaluarContrasena();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				evaluarContrasena();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				evaluarContrasena();
			}
		});
		contraseña.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				contraseña.setBackground(Colores.BLACKBERRY_CREAM);
		        contraseña.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				contraseña.setBackground(Color.WHITE);
		        contraseña.setForeground(Color.BLACK);
			}
		});
	}
	private void crearBoton(JButton button, String ruta, String descripcion)
	{
		button.setBackground(Colores.WHITE);
		button.setForeground(Color.black);
		button.setToolTipText(descripcion);
		button.setFont(fontBoton);
		button.setIconTextGap(10); // Pone espacio entre icono y el texto del boton
		
		
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

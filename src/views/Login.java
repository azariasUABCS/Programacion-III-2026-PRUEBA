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

import exceptions.InvalidUserException;
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
	JButton buttonIniciar= new JButton("Iniciar Sesión");
	JButton Registrarse = new JButton(" Registrarse   ");
	
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
		
		configurarBotones();
		
	}
	private void configurarBotones() {
		PanelPersonalizable botones = new PanelPersonalizable();
		botones.setLayout(new BoxLayout(botones, BoxLayout.Y_AXIS));
		botones.setBackground(Colores.MIDNIGHT_VIOLET);
		botones.setBorder(new EmptyBorder(0,15,0,0));
		
		
		crearBoton(buttonIniciar, "..\\img\\login.png", "Clic para Iniciar Sesión!");
		
		
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
		
		
		
		
		crearBoton(Registrarse, "..\\img\\enter.png", "Clic para Registrarse!");
		
		
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

	public Window getWindow() {
		return SwingUtilities.getWindowAncestor(this);
	}

	public boolean isLogrado() {
		return logrado;
	}


	public void setLogrado(boolean logrado) {
		this.logrado = logrado;
	}


	public Font getFontTexto() {
		return fontTexto;
	}


	public void setFontTexto(Font fontTexto) {
		this.fontTexto = fontTexto;
	}


	public Font getFontBoton() {
		return fontBoton;
	}


	public void setFontBoton(Font fontBoton) {
		this.fontBoton = fontBoton;
	}


	public Font getFontTitulo() {
		return fontTitulo;
	}


	public void setFontTitulo(Font fontTitulo) {
		this.fontTitulo = fontTitulo;
	}


	public JLabel getMensajeCorreo() {
		return mensajeCorreo;
	}


	public void setMensajeCorreo(JLabel mensajeCorreo) {
		this.mensajeCorreo = mensajeCorreo;
	}


	public JLabel getMensajeContraseña() {
		return mensajeContraseña;
	}


	public void setMensajeContraseña(JLabel mensajeContraseña) {
		this.mensajeContraseña = mensajeContraseña;
	}


	public JTextField getUsuario() {
		return usuario;
	}


	public void setUsuario(JTextField usuario) {
		this.usuario = usuario;
	}


	public JPasswordField getContraseña() {
		return contraseña;
	}


	public void setContraseña(JPasswordField contraseña) {
		this.contraseña = contraseña;
	}


	public JButton getButtonIniciar() {
		return buttonIniciar;
	}


	public void setButtonIniciar(JButton buttonIniciar) {
		this.buttonIniciar = buttonIniciar;
	}


	public JButton getRegistrarse() {
		return Registrarse;
	}


	public void setRegistrarse(JButton registrarse) {
		Registrarse = registrarse;
	}


	public Color getDefaultColor() {
		return defaultColor;
	}


	public void setDefaultColor(Color defaultColor) {
		this.defaultColor = defaultColor;
	}


	public Color getClickedColor() {
		return clickedColor;
	}


	public void setClickedColor(Color clickedColor) {
		this.clickedColor = clickedColor;
	}


	
	
	
}

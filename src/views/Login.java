package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Window;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;



import utils.Colores;


public class Login extends JPanel{

	public int x;
	public int y;
	public boolean logrado;
	private Font fontTexto = new Font("Times New Roman", Font.BOLD, 17);
	private Font fontBoton = new Font("Times New Roman", Font.BOLD, 17);
	private Font fontTitulo = new Font("Times New Roman", Font.BOLD, 30);
	JLabel mensajeCorreo = new JLabel("* Correo obligatorio *");
	JLabel mensajeContraseña = new JLabel("* Contraseña obligatoria *");
	JTextField usuario = new JTextField(30);
	JPasswordField contraseña = new JPasswordField(30);
	
	public Login(){	
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(50,50,50,50));
		
		
		JLabel saludo = new JLabel("  Bienvenido!");
		saludo.setForeground(Colores.WHITE);
		saludo.setFont(fontTitulo);
		add(saludo);
		
		mensajeCorreo.setForeground(Color.RED);
		mensajeCorreo.setFont(fontTexto);
		mensajeCorreo.setVisible(false);
		add(mensajeCorreo);
		
		
		usuario.setForeground(Color.BLACK);
		usuario.setFont(fontTexto);
		usuario.setMaximumSize(new Dimension(670,50));
		add(usuario);
		add(Box.createRigidArea(new Dimension(0,20)));
		
		mensajeContraseña.setForeground(Color.RED);
		mensajeContraseña.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mensajeContraseña.setVisible(false);
		add(mensajeContraseña);
		
		contraseña.setForeground(Color.BLACK);
		contraseña.setFont(fontTexto);
		contraseña.setMaximumSize(new Dimension(670,50));
		

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
		
		
		
		JButton Registrarse = new JButton(" Registrarse   ");
		crearBoton(Registrarse, "..\\img\\enter.png", "Clic para Registrarse!");
		Registrarse.addActionListener(e -> new FormularioRegistro());
		
		add(botones);
		botones.add(Box.createRigidArea(new Dimension(0, 12))); // Espacio de 12 píxeles
		botones.add(Registrarse);
	}
	
	
	private void resetearCredenciales() {
		mensajeCorreo.setVisible(false);
		mensajeContraseña.setVisible(false);
	}
	
	private void evaluarCredenciales() {
		resetearCredenciales();
		boolean error=false;
		Window window=SwingUtilities.getWindowAncestor(this);
		if(usuario.getText().equals("")) {
			mensajeCorreo.setVisible(true);
			error=true;
			
		}
		if(contraseña.getPassword().length==0) {
			mensajeContraseña.setVisible(true);
			error=true;
		}
		if(error==false) {
			new VentanaPrincipal();
			window.dispose();
		}
		
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
	
	
}

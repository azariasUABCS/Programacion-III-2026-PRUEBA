package views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Login extends JPanel{

	public int x;
	public int y;
	
	private Font fontTexto = new Font("Times New Roman", Font.BOLD, 25);
	private Font fontBoton = new Font("Times New Roman", Font.BOLD, 15);
	private Font fontTitulo = new Font("Times New Roman", Font.BOLD, 30);
	
	
	private Color textoColor = new Color(164, 186, 183);

	
	public Login(){	
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(50,50,50,50));
		
		
		JLabel saludo = new JLabel("   Bienvenido!");
		saludo.setForeground(new Color(189,189,189));
		saludo.setFont(fontTitulo);
		add(saludo);
		
		
		JLabel credenciales = new JLabel("Credenciales erroneas");
		credenciales.setForeground(Color.RED);
		credenciales.setFont(fontTexto);
		credenciales.setVisible(false);
		add(credenciales);
		add(Box.createRigidArea(new Dimension(0,20)));
		
		JTextField usuario = new JTextField(30);
		usuario.setForeground(Color.GRAY);
		usuario.setFont(fontTexto);
		usuario.setMaximumSize(new Dimension(670,50));
		add(usuario);
		add(Box.createRigidArea(new Dimension(0,20)));
		
		JPasswordField contraseña = new JPasswordField(30);
		contraseña.setForeground(Color.GRAY);
		contraseña.setFont(fontTexto);
		contraseña.setMaximumSize(new Dimension(670,50));
		

		add(contraseña);
		add(Box.createRigidArea(new Dimension(0,40)));
		
		FondoPersonalizable botones=new FondoPersonalizable();
		botones.setLayout(new BoxLayout(botones, BoxLayout.Y_AXIS));
		botones.setBackground(Color.GRAY);
		botones.setBorder(new EmptyBorder(0,25,0,0));
		
		JButton button = new JButton("Iniciar Sesión");
		crearBoton(button, "..\\img\\icono.png");
		button.addActionListener(e -> {
			credenciales.setVisible(true);
		});
		botones.add(button);
		JButton button2 = new JButton(" Registrarse  ");
		crearBoton(button2, "..\\img\\icono.png");
		button2.addActionListener(e -> {
			FormularioRegistro formulario = new FormularioRegistro();
		});
		botones.add(button2);
		add(botones);
		
		
		
		
	}
	
	private void crearBoton(JButton button, String ruta)
	{
		//button.setBounds(515, 460, 240, 60);
		button.setBackground(Color.GRAY);
		button.setForeground(Color.black);
		button.setToolTipText("Click para iniciar sesión!");
		button.setFont(fontBoton);
		
		try 
		{
			Image icono = ImageIO.read(getClass().getResource(ruta));
					
			icono = icono.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			
			button.setIcon(new ImageIcon(icono));
		}
		catch (Exception ex)
		{
			System.out.println("No se pudo poner el icono");
		}
	}
	
	
}

package views;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Panel extends JPanel{

	public int x;
	public int y;
	
	private Font fontTexto = new Font("Times New Roman", Font.BOLD, 25);
	private Font fontBoton = new Font("Times New Roman", Font.BOLD, 25);
	private Font fontTitulo = new Font("Times New Roman", Font.BOLD, 75);
	
	
	private Color textoColor = new Color(164, 186, 183);

	
	public Panel()
	{	
		setLayout(null);
		
		JButton button = new JButton("Iniciar Sesión");
		
		crearBoton(button, "..\\img\\icono.png");
		
		add(button);
		
		JLabel saludo = new JLabel("Bienvenido!");
		saludo.setForeground(textoColor);
		saludo.setFont(fontTitulo);
		saludo.setBounds(450,200,500, 100);
		add(saludo);
		
		JTextField usuario = new JTextField();
		usuario.setForeground(Color.GRAY);
		usuario.setFont(fontTexto);
		usuario.setBounds(525,325,220, 60);
		add(usuario);
		
		
		JPasswordField contraseña = new JPasswordField();
		contraseña.setForeground(Color.GRAY);
		contraseña.setFont(fontTexto);
		contraseña.setBounds(525,390,220, 60);
		add(contraseña);
	}
	
	private void crearBoton(JButton button, String ruta)
	{
		button.setBounds(515, 460, 240, 60);
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

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
	
	private Font fontTexto = new Font("Arial", Font.BOLD, 20);

	
	public Panel()
	{	
		setLayout(null);
		
		JButton button = new JButton("Iniciar Session");
		
		crearBoton(button, "..\\img\\icono.png");
		
		add(button);
		
		
		
		JLabel saludo = new JLabel("Bienvendio!");
		saludo.setForeground(Color.blue);
		saludo.setFont(fontTexto);
		saludo.setBounds(25,25,200, 50);
		add(saludo);
		
		
		JTextField texto = new JTextField();
		texto.setForeground(Color.blue);
		texto.setFont(fontTexto);
		texto.setBounds(525,325,220, 60);
		add(texto);
		
		
		JPasswordField contraseña = new JPasswordField();
		contraseña.setForeground(Color.blue);
		contraseña.setFont(fontTexto);
		contraseña.setBounds(525,390,220, 60);
		add(contraseña);
	}
	
	private void crearBoton(JButton button, String ruta)
	{
		button.setBounds(525, 460, 220, 60);
		
		button.setBackground(Color.cyan);
		button.setForeground(Color.black);
		
		button.setToolTipText("Es un Boton!");
		
		button.setFont(fontTexto);
		
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

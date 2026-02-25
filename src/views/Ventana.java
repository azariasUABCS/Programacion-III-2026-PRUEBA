package views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;


import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;


public class Ventana extends JFrame{
	
	private Color colorBG1 = new Color(190,165,125);
	private Color colorBG2 = new Color(165, 36, 34);
	private Font fontTexto = new Font("Times New Roman", Font.BOLD, 25);
	private Font fontBoton = new Font("Times New Roman", Font.BOLD, 25);
	private Font fontTitulo = new Font("Times New Roman", Font.BOLD, 75);
	
	
	private Color textoColor = new Color(164, 186, 183);

	
	public Ventana()
	{
		setLayout(null);
		setBounds(25, 25, 1300, 700); // Hace lo mismo de setSize y setLocation.
		setResizable(false);  // No se puede cambiar de tamaño con el mouse.
		setTitle("Mi Aplicación (Progamación III) por Azarias");  // Nombre de la Ventana
		setLocationRelativeTo(null);  // Pone la ventana en el centro
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image icono = tk.getImage("src\\img\\icono.png");
		setIconImage(icono);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la penstaña, si no se queda abrierta.
		getContentPane().setBackground(new Color(189,189,189));
		
		
		Login login = new Login();
		login.setBounds(480,140,300,400);
		login.setBackground(Color.GRAY);
		add(login);
		
		
		
		FondoPersonalizable fondo=new FondoPersonalizable();
		fondo.setBounds(490, 150, 300, 400);
		fondo.setBackground(Color.DARK_GRAY);
		add(fondo);
		
		/*
		Panel miPanel = new Panel();
		
		//miPanel.setLayout(new BoxLayout(miPanel, BoxLayout.Y_AXIS));
		//miPanel.setBorder(new Border());
		
		add(miPanel, BorderLayout.CENTER);
		
		miPanel.setBackground(colorBG2);
		miPanel.setSize(15,15);
		*/
		
		setVisible(true);  // Siempre agrega el set visible antes del final.
	}
	
}

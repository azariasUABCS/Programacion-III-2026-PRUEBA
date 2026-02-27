package views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
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

import utils.Colores;


public class Ventana extends JFrame{
	
	
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
		getContentPane().setBackground(Colores.BLACKBERRY_CREAM);
		
		ImageIcon cursorImage = new ImageIcon("src\\img\\pointer_b.png");
		Cursor myCursor = tk.createCustomCursor(cursorImage.getImage(), new Point(0,0), "Cursor");
		this.setCursor(myCursor);
		
		// Login Panel
		Login login = new Login();
		login.setBounds(480,140,300,400);
		login.setBackground(Colores.MIDNIGHT_VIOLET);
		add(login);
		
		
		// Shadow of Login Panel
		FondoPersonalizable fondo=new FondoPersonalizable();
		fondo.setBounds(490, 150, 300, 400);
		fondo.setBackground(new Color(44, 0, 47));
		add(fondo);
		
		
		setVisible(true);  // Siempre agrega el set visible antes del final.
	}
	
}

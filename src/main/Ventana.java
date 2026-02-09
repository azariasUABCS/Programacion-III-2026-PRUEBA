package main;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class Ventana extends JFrame{
	
	public Ventana()
	{
		//setSize(500,500);  // Tamaño por pixeles
		//setLocation(100, 100);
		
		
		setBounds(25, 25, 1300, 700); // Hace lo mismo de setSize y setLocation.
		
		
		setResizable(false);  // No se puede cambiar de tamaño con el mouse.
		setTitle("Mi Aplicación (Progamación III) por Azarias");  // Nombre de la Ventana.
		
		
		setLocationRelativeTo(null);  // Pone la ventana en el centro
		
		
		// Para poner el icono de la Ventana
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image icono = tk.getImage("src\\img\\icono.png");
		setIconImage(icono);
		
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la penstaña, si no se queda abrierta.
		
		
		Panel miPanel = new Panel(new Color(125, 221, 57), 15,15);
		add(miPanel);

		Panel otroPanel = new Panel(Color.red, 155, 155);
		add(otroPanel);
		
		
		setVisible(true);  // Siempre agrega el set visible antes del final.
	}
}

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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;

import controllers.LoginController;
import utils.Colores;


public class Ventana extends JFrame{
	
	public Ventana()
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		setLayout(null);
		setBounds(25, 25, 1300, 700); // Hace lo mismo de setSize y setLocation.
		setResizable(false);  // No se puede cambiar de tamaño con el mouse.
		setTitle("Mi Aplicación (Progamación III) por Azarias");  // Nombre de la Ventana
		setLocationRelativeTo(null);  // Pone la ventana en el centro
		
		Image icono = tk.getImage("src\\img\\icono.png");
		setIconImage(icono);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la penstaña, si no se queda abrierta.
		getContentPane().setBackground(Colores.BLACKBERRY_CREAM);
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				getContentPane().setBackground(Colores.BLACKBERRY_CREAM);
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				getContentPane().setBackground(Color.GRAY);
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		ImageIcon cursorImage = new ImageIcon("src\\img\\pointer_b.png");
		Cursor myCursor = tk.createCustomCursor(cursorImage.getImage(), new Point(0,0), "Cursor");
		this.setCursor(myCursor);
		
		// Login Panel
		Login login = new Login();
		login.setBounds(750,140,300,400);
		login.setBackground(Colores.MIDNIGHT_VIOLET);
		login.setOpaque(false);
		new LoginController(login);
		add(login);
		
		//Agregar a los usuarios
		Usuarios usuarios= new Usuarios();
		JScrollPane scrollUsuarios= new JScrollPane(usuarios);
		scrollUsuarios.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollUsuarios.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollUsuarios.setBounds(140, 140, 600, 400);
		
		scrollUsuarios.setOpaque(false);
		scrollUsuarios.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = Colores.BLACKBERRY_CREAM;       // color del "pulgar" (la parte que arrastras)
		        this.trackColor = Colores.MIDNIGHT_VIOLET; // color del fondo
		    }
		    @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                return button;
            }


		    
		});
		scrollUsuarios.getVerticalScrollBar().setUnitIncrement(100);
		scrollUsuarios.getVerticalScrollBar().setOpaque(false);
		scrollUsuarios.setBorder(null);
		add(scrollUsuarios);
		
		// Shadow of Login Panel
		PanelPersonalizable fondo1=new PanelPersonalizable();
		fondo1.setBounds(130, 120, 950, 450);
		fondo1.setBackground(Colores.MIDNIGHT_VIOLET);
		add(fondo1);
		
		// Shadow of Login Panel
		PanelPersonalizable fondo2=new PanelPersonalizable();
		fondo2.setBounds(140, 130, 950, 450);
		fondo2.setBackground(new Color(44, 0, 47));
		add(fondo2);
		
		
		setVisible(true);  // Siempre agrega el set visible antes del final.
	}
	
}

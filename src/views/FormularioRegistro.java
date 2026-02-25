package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormularioRegistro extends JFrame{
	
	public Font fuente;
	private Font fontTexto = new Font("Times New Roman", Font.BOLD, 25);
	private Font fontBoton = new Font("Times New Roman", Font.BOLD, 15);
	private Font fontTitulo = new Font("Times New Roman", Font.BOLD, 40);
	
	
	private Color textoColor = new Color(164, 186, 183);
	
	public FormularioRegistro()
	{
		setSize(300, 450); // Hace lo mismo de setSize y setLocation.
		
		setLayout(null);
		setResizable(false);  // No se puede cambiar de tamaño con el mouse.
		setTitle("Registro");  // Nombre de la Ventana.
		setLocationRelativeTo(null);  // Pone la ventana en el centro
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la penstaña, si no se queda abrierta.
		
		JPanel panelComponentes = new JPanel();
		panelComponentes.setBackground(Color.GRAY);
		panelComponentes.setLayout(new BoxLayout(panelComponentes, BoxLayout.Y_AXIS));
		JLabel indicaciones = new JLabel("Nombre        Apellidos");
		indicaciones.setForeground(new Color(189,189,189));
		indicaciones.setFont(fontTexto);
		
		JLabel indicacionCorreo = new JLabel("Correo");
		
		indicacionCorreo.setFont(fontTexto);
		
		JLabel indicacionContraseña = new JLabel("Contraseña");
		
		indicacionContraseña.setFont(fontTexto);
		
		JLabel saludo = new JLabel("Registrate");
		saludo.setOpaque(false);
		saludo.setFont(fontTitulo);
		saludo.setBorder(new EmptyBorder(20, 20, 10, 10));
		panelComponentes.add(saludo);
		
		JPanel panelNombres=new JPanel();
		panelNombres.setLayout(new BoxLayout(panelNombres, BoxLayout.X_AXIS));
		panelNombres.setPreferredSize(new Dimension(300,100));
		panelNombres.setBackground(Color.GRAY);
		JTextField nombres = new JTextField(35);
		JTextField apellidos = new JTextField(35);
		panelNombres.add(nombres);
		panelNombres.add(Box.createRigidArea(new Dimension(20,0)));
		panelNombres.setBorder(new EmptyBorder(10,10,40,10));
		panelNombres.add(apellidos);
		panelNombres.setMaximumSize(new Dimension(600,10));
		
		JTextField correo = new JTextField(70);
		JTextField contraseña = new JTextField(70);
		
		JButton button = new JButton("Registrarse");
		button.setBorder(new EmptyBorder(0,60,0,60));
		crearBoton(button, "..\\img\\icono.png");
		button.addActionListener(e -> {
			dispose();
		});
		
		JPanel panelDatos=new JPanel();
		panelNombres.setLayout(new BoxLayout(panelNombres, BoxLayout.X_AXIS));
		panelNombres.setPreferredSize(new Dimension(300,100));
		panelComponentes.add(indicaciones);
		panelComponentes.add(panelNombres);
		panelComponentes.add(indicacionCorreo);
		panelComponentes.add(correo);
		panelComponentes.add(indicacionContraseña);
		panelComponentes.add(contraseña);
		panelComponentes.add(button);
		add(panelComponentes);
		setContentPane(panelComponentes);
		
		setVisible(true);
	}
	private void crearBoton(JButton button, String ruta)
	{
		//button.setBounds(515, 460, 240, 60);
		button.setBackground(Color.GRAY);
		button.setForeground(Color.black);
		button.setToolTipText("Registrarse");
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

	

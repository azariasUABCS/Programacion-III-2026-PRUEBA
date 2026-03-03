package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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

import utils.Colores;

public class FormularioRegistro extends JFrame{
	
	public Font fuente;
	private Font fontTexto = new Font("Times New Roman", Font.BOLD, 15);
	private Font fontTextoCampo = new Font("Times New Roman", Font.BOLD, 15);
	private Font fontBoton = new Font("Times New Roman", Font.BOLD, 15);
	private Font fontTitulo = new Font("Times New Roman", Font.BOLD, 40);
	
	
	private Color textoColor = new Color(164, 186, 183);
	
	public FormularioRegistro()
	{
		setSize(320, 500); // Hace lo mismo de setSize y setLocation.
		
		setLayout(null);
		setResizable(false);  // No se puede cambiar de tamaño con el mouse.
		setTitle("Registro");  // Nombre de la Ventana.
		setLocationRelativeTo(null);  // Pone la ventana en el centro
		
		
		getContentPane().setBackground(Colores.BLACKBERRY_CREAM);
		FondoPersonalizable fondo = new FondoPersonalizable();
		fondo.setBounds(25, 50, 250, 350);
		fondo.setBackground(Colores.MIDNIGHT_VIOLET);
		
		FondoPersonalizable fondo2 = new FondoPersonalizable();
		fondo2.setBounds(30, 55, 250, 350);
		fondo2.setBackground(new Color(44, 0, 47));
		
		
		JPanel panelComponentes = new JPanel();
		panelComponentes.setLayout(new BoxLayout(panelComponentes, BoxLayout.Y_AXIS));
		//panelComponentes.setSize(new Dimension(300,350));
		panelComponentes.setBounds(0, 50, 300, 375);
		panelComponentes.setOpaque(false);
		
		JLabel indicaciones = new JLabel("   Nombre          Apellidos");
		indicaciones.setForeground(Colores.WHITE);
		indicaciones.setFont(fontTexto);
		
		JLabel indicacionCorreo = new JLabel("Correo");
		indicacionCorreo.setFont(fontTexto);
		indicacionCorreo.setForeground(Colores.WHITE);
		indicacionCorreo.setOpaque(false);
		
		JLabel indicacionContraseña = new JLabel("Contraseña");
		indicacionContraseña.setOpaque(false);
		indicacionContraseña.setFont(fontTexto);
		indicacionContraseña.setForeground(Colores.WHITE);
		
		JLabel saludo = new JLabel(" Registrate");
		saludo.setOpaque(false);
		saludo.setFont(fontTitulo);
		saludo.setForeground(Color.WHITE);
		panelComponentes.add(saludo);
		
		JPanel panelNombres=new JPanel();
		panelNombres.setLayout(new BoxLayout(panelNombres, BoxLayout.X_AXIS));
		
		panelNombres.setBackground(Color.GRAY);
		JTextField nombres = new JTextField(35);
		nombres.setMaximumSize(new Dimension(600,60));
		nombres.setBackground(Colores.BLACKBERRY_CREAM);
		nombres.setForeground(Color.WHITE);
		nombres.setFont(fontTextoCampo);
		JTextField apellidos = new JTextField(35);
		apellidos.setMaximumSize(new Dimension(600,60));
		
		apellidos.setBackground(Colores.BLACKBERRY_CREAM);
		apellidos.setForeground(Color.WHITE);
		apellidos.setFont(fontTextoCampo);
		panelNombres.add(nombres);
		panelNombres.add(apellidos);
		
		
		
		
		JTextField correo = new JTextField(70);
		correo.setBackground(Colores.BLACKBERRY_CREAM);
		correo.setForeground(Color.WHITE);
		correo.setFont(fontTextoCampo);
		correo.setMaximumSize(new Dimension(600,70));
		
		
		JTextField contraseña = new JTextField(70);
		contraseña.setBackground(Colores.BLACKBERRY_CREAM);
		contraseña.setForeground(Color.WHITE);
		contraseña.setFont(fontTextoCampo);
		contraseña.setMaximumSize(new Dimension(600,70));
		
		
		JPanel panelDatos=new JPanel();
		panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
		panelDatos.setOpaque(false);
		
		JPanel panelBoton= new JPanel();
		panelBoton.setLayout(new BoxLayout(panelBoton, BoxLayout.Y_AXIS));
		
		JButton button = new JButton("Registrarse");
		button.setBorder(new EmptyBorder(0,0,0,20));
		crearBoton(button, "..\\img\\icono.png");
		button.addActionListener(e -> {
			dispose();
		});
		
		
		panelBoton.add(button);
		panelBoton.setOpaque(false);
		panelBoton.setBorder(new EmptyBorder(0,30,0,20));
		
		
		panelComponentes.add(indicaciones);
		panelComponentes.add(panelNombres);
		panelComponentes.setBorder(new EmptyBorder(20,40,40,40));
		panelDatos.add(indicacionCorreo);
		panelDatos.add(correo);
		
		panelDatos.add(indicacionContraseña);
		panelDatos.add(contraseña);
		panelComponentes.add(panelDatos);
		panelComponentes.add(Box.createRigidArea(new Dimension(0,75)));
		panelComponentes.add(panelBoton);
		add(panelComponentes);
		add(fondo);
		add(fondo2);

		
		
		setVisible(true);
	}
	
	private void crearBoton(JButton button, String ruta)
	{
		button.setBackground(Colores.WHITE);
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

	

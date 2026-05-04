package views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.LineBorder;

import utils.Colores;

public class UsuarioPanel extends JPanel {
	private Font fontTexto = new Font("Times New Roman", Font.BOLD, 17);
	
	public UsuarioPanel(String nombre, String apellido,ImageIcon foto) 
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Colores.PROFILE_PANEL);
		setVisible(true);
		setBorder(new LineBorder(Colores.LOGIN_PANEL, 10));
		JLabel icono=new JLabel(foto);
		icono.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel usrNombre= new JLabel(nombre);
		usrNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel usrApellido= new JLabel(apellido);
		usrApellido.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		usrNombre.setFont(fontTexto);
		usrApellido.setFont(fontTexto);
		add(icono);
		add(usrNombre);
		add(usrApellido);
		
		
	}
	
}

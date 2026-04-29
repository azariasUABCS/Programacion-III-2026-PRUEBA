package views;

import java.awt.Font;

import javax.swing.*;
import javax.swing.border.LineBorder;

import utils.Colores;

public class UsuarioPanel extends JPanel {
	private Font fontTexto = new Font("Times New Roman", Font.BOLD, 17);
	
	public UsuarioPanel(String nombre, String apellido) 
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Colores.PROFILE_PANEL);
		setVisible(true);
		setBorder(new LineBorder(Colores.LOGIN_PANEL, 10));
		JLabel usrNombre= new JLabel(nombre);
		JLabel usrApellido= new JLabel(apellido);
		usrNombre.setFont(fontTexto);
		usrApellido.setFont(fontTexto);
		add(usrNombre);
		add(usrApellido);
		
		
	}
}

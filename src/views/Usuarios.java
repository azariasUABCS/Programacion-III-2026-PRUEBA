package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import utils.Colores;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;


public class Usuarios extends JPanel {
	public Usuarios() {
		ArrayList<UsuarioPanel> usuarios = new ArrayList<UsuarioPanel>();
		
		int alto=0;
		//Añade usuarios simullados"
		for(int i=0;i<1;i++) {
			usuarios.add(new UsuarioPanel());
		}
		
		//define alto
		if(usuarios.size()%2==0) {
			alto=(usuarios.size()/2)*300;
		}else {
			alto=((usuarios.size()/2)+1)*300;
		}
		
		setPreferredSize(new Dimension(600,alto));
		setOpaque(false);
		setLayout(new GridLayout(0,2));
		
		
		for(UsuarioPanel usuario : usuarios) {
			
			add(usuario);
		}
		if(usuarios.size()%2!=0) {
			PanelPersonalizable relleno = new PanelPersonalizable();
			relleno.setBackground(Colores.MIDNIGHT_VIOLET);
			add(relleno);
		}
		setVisible(true);
		
	}
}

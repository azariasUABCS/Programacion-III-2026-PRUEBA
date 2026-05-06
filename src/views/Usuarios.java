package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modelos.User;
import respository.UserRepository;

import tablemodels.UserTableModel;
import utils.Colores;
import utils.PanelPersonalizable;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Usuarios extends JPanel {
	public Usuarios() {
		ArrayList<UsuarioPanel> usuarios = new ArrayList<UsuarioPanel>();
		UserRepository repository = new UserRepository();
		try 
		{
			List<User> users = repository.getUsers(); 
			
		
			UserTableModel usersTable=new UserTableModel(users);
			int alto=0;
			
			
			//define alto
			if(usersTable.getNumGuardar()%2==0) {
				
				alto=(usersTable.getNumGuardar()/2)*300;
			}else {
				System.out.println(4456);
				alto=((usersTable.getNumGuardar()/2)+1)*300;
			}
			//Añade usuarios simullados"
			for(int i=0;i<usersTable.getRowCount();i++) {
				if(usersTable.getValueAt(i, 4).toString().equals("true")) {
					try {
						usuarios.add(new UsuarioPanel(usersTable.getValueAt(i, 0).toString(),usersTable.getValueAt(i, 1).toString(),escalarImagen(usersTable.getValueAt(i, 3).toString(), 200, 200)));
					} catch (Exception e) {
						// TODO: handle exception
						usuarios.add(new UsuarioPanel(usersTable.getValueAt(i, 0).toString(),usersTable.getValueAt(i, 1).toString(),escalarImagenLocal("..\\img\\icono.png" , 200, 200)));
					}
				}
				
				
			}
			System.out.println(alto);
			setPreferredSize(new Dimension(600,alto));
			setOpaque(false);
			setLayout(new GridLayout(0,2));
			
			
			for(UsuarioPanel usuario : usuarios) {
				
				add(usuario);
			}
			if(usuarios.size()%2!=0) {
				PanelPersonalizable relleno = new PanelPersonalizable();
				relleno.setBackground(Colores.LOGIN_PANEL);
				add(relleno);
			}
			setVisible(true);
		} 
		catch (IOException ex) 
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
		
		
	}
	private ImageIcon escalarImagen(String direccion,int x,int y) {
	    	System.out.println(direccion);
	        ImageIcon iconoOriginal = new ImageIcon(direccion);
	
	       
	        Image imagenEscalada = iconoOriginal.getImage()
	                .getScaledInstance(x, y, Image.SCALE_SMOOTH);
	
	        
	        ImageIcon iconoFinal = new ImageIcon(imagenEscalada);
	        iconoFinal.setDescription(direccion);
	        return iconoFinal;
	}
	private ImageIcon escalarImagenLocal(String direccion,int x,int y) {
    	System.out.println(direccion);
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(direccion));

       
        Image imagenEscalada = iconoOriginal.getImage()
                .getScaledInstance(x, y, Image.SCALE_SMOOTH);

        
        ImageIcon iconoFinal = new ImageIcon(imagenEscalada);
        iconoFinal.setDescription(direccion);
        return iconoFinal;
}
}

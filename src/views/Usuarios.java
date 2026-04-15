package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modelos.User;
import respository.UserRepository;
import tablemodels.UserTableModel;
import utils.Colores;

import java.awt.Dimension;
import java.awt.GridLayout;
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
			
			System.out.println("\n\n----------- Usuarios Registrados -----------\n");
			for(User user : users) 
			{
				System.out.println(user);
				System.out.println("\n----------------------------------\n");
			}
			UserTableModel usersTable=new UserTableModel(users);
			int alto=0;
			//Añade usuarios simullados"
			for(int i=0;i<usersTable.getRowCount();i++) {
				usuarios.add(new UsuarioPanel(usersTable.getValueAt(i, 0).toString(),usersTable.getValueAt(i, 1).toString()));
			}
			
			//define alto
			if(usersTable.getRowCount()%2==0) {
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
		catch (IOException ex) 
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
		
		
	}
}

package views;

import java.awt.Dimension;
import java.io.IOException;
import java.util.List;

import javax.swing.*;

import modelos.User;
import respository.UserRepository;

public class VentanaPrincipal extends JFrame {
	
	public JButton btnUsers;
	
	public VentanaPrincipal() {
		setLayout(null);
		setLocationRelativeTo(null);
		setSize(new Dimension(1000,1000));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		/* 	
		* 	Esto imprime todo los datos o txt del archivo src/files/user.csv y esta separado por las comas.
		* 	Aqui ya puedes usar este codigo para lo que ocupes. Tambien esta en el github de la profe.
		*/
		
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
		} 
		catch (IOException ex) 
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
		
	}
}

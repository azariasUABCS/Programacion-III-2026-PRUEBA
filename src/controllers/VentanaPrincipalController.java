package controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelos.User;
import respository.UserRepository;
import tablemodels.UserTableModel;
import views.Login;
import views.Ventana;
import views.VentanaPrincipal;

public class VentanaPrincipalController {
	
	private VentanaPrincipal view;
	
	public VentanaPrincipalController(VentanaPrincipal ventanaPrincipal)
	{
		this.view = ventanaPrincipal;
		registerListeners();
	}
	
	public void registerListeners( ) 
	{
		
		view.mItemExit.addActionListener(e -> handleClose());
		
		view.addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent e) 
			{
				handleClose();
			}
		});
		
		view.btnUsers.addActionListener(e -> {
			showUsers();
		});
		
		view.btnHome.addActionListener(e -> view.showView(VentanaPrincipal.HOME));
		view.btnAdd.addActionListener(e -> {
			new RegistroControllerTableAdd();
		});
	}
	
	private void showUsers() 
	{
		UserRepository repository = new UserRepository();
		
		try {
			List<User> users = repository.getUsers();
			
			UserTableModel model = new UserTableModel(users);
			
			view.usersPanel.setTableModel(model);
			
			view.showView(VentanaPrincipal.USERS);
			
		}
		catch (IOException ex) 
		{
			JOptionPane.showMessageDialog(view, ex.getMessage());
		}
		
	}
	
	private void handleClose() 
	{
		int option = view.confirmExit();
		System.out.println(option);

		if (option == JOptionPane.YES_OPTION) 
		{
			new Ventana();
			view.dispose();
		}
	}
	
	
}

package controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import modelos.User;
import respository.UserRepository;
import tablemodels.UserTableModel;
import views.Ventana;
import views.VentanaPrincipal;

public class VentanaPrincipalController {

	private VentanaPrincipal ventanaPrincipal;
	
	public VentanaPrincipalController(VentanaPrincipal ventanaPrincipal) {
		
		this.ventanaPrincipal = ventanaPrincipal;
		registerListeners();
		
	}
	
	public void registerListeners( ) {
		
		ventanaPrincipal.mItemExit.addActionListener(e -> handleClose());
		
		ventanaPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				handleClose();
			}
		});
		
		ventanaPrincipal.btnUsers.addActionListener(e -> {
			showUsers();
		});
		
		ventanaPrincipal.btnHome.addActionListener(e -> ventanaPrincipal.showView(ventanaPrincipal.HOME));
		
	}
	
	public void showUsers() {
		
		UserController controller = new UserController(ventanaPrincipal.usersPanel, this);
		
		UserRepository repository = new UserRepository();
		
		try {
			List<User> users = repository.getUsers();
			
			UserTableModel model = new UserTableModel(users);
			
			ventanaPrincipal.usersPanel.setTableModel(model);
			
			ventanaPrincipal.showView(ventanaPrincipal.USERS);
			
		}catch (IOException ex) {
			JOptionPane.showMessageDialog(ventanaPrincipal, ex.getMessage());
		}
		
	}
	
	private void handleClose() {
		int option = ventanaPrincipal.confirmExit();
		System.out.println(option);

		if (option == JOptionPane.YES_OPTION) {
			new Ventana();
			ventanaPrincipal.dispose();
		}
	}
	
}
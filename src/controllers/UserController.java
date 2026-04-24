package controllers;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import modelos.User;
import respository.UserRepository;
import tablemodels.UserTableModel;
import views.UserFormDialog;
import views.UsersView;
import views.VentanaPrincipal;

public class UserController {

	private UsersView view;
	private UserRepository repo;
	private UserTableModel model;
	
	public UserController(UsersView view, VentanaPrincipalController ventanaController, List<User> users) 
	{
		this.model=new UserTableModel(users);
		this.view = view;
		repo = new UserRepository();
		
		view.getBtnAdd().addActionListener(e -> {
			
			UserFormDialog form = new UserFormDialog(null, null);
			new UserDialogController(form, ventanaController); 
			form.setVisible(true);
		});
		this.view.getBtnEdit().addActionListener(e -> {
			int row = view.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(view, "Selecciona un usuario");
				return;
			}
			
			openForm(model.getUserAt(row),ventanaController);
		});
		view.getBtnDelete().addActionListener(e -> {
			int row = view.getSelectedRow();
			System.out.println(row);
			if(row == -1) {
				JOptionPane.showMessageDialog(view, "Selecciona un usuario");
				return;
			}
			try {
				repo.delete(row);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	private void openForm(User user, VentanaPrincipalController ventanaController) {
		int row = view.getSelectedRow();
		System.out.println(row);
		UserFormDialog dialog = new UserFormDialog(null, user);
		new UserDialogController(dialog, ventanaController,user); 
		dialog.setVisible(true);
		
		if(dialog.isGuardado()) {
			User savedUser = dialog.getUser();
			
			try {
				if(user == null) {
					repo.save(savedUser);
				}else {
					
					repo.update(row, savedUser);
					
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(view, e.getMessage());
			}
			
		}
		loadUsers();
		
	}
	public void loadUsers() {	
		System.out.println("Carga usuarios");
		try {
			List<User> users = repo.getUsers();
			
			if(model == null) {
				model = new UserTableModel(users);
				view.setTableModel(model);
			}else {
				model.setUsers(users);
			}
			
		}catch (IOException ex) {
			JOptionPane.showMessageDialog(view, ex.getMessage());
		}
	}
}




package controllers;

import respository.UserRepository;
import tablemodels.UserTableModel;
import views.UserFormDialog;
import views.UsersView;
import views.VentanaPrincipal;

public class UserController {

	private UsersView view;
	private UserRepository repo;
	private UserTableModel model;
	
	public UserController(UsersView view, VentanaPrincipalController ventanaController) 
	{
		this.view = view;
		repo = new UserRepository();
		
		view.getBtnAdd().addActionListener(e -> {
			
			UserFormDialog form = new UserFormDialog(null, null);
			new UserDialogController(form, ventanaController); 
			form.setVisible(true);
		});
	}
	
}




package controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import modelos.User;
import respository.UserRepository;
import services.PDFExporter;
import tablemodels.UserTableModel;
import views.UserFormDialog;
import views.UsersView;
import views.VentanaPrincipal;

public class UserController {

	private UsersView view;
	private UserRepository repo;
	private UserTableModel model;
	private VentanaPrincipalController ventanaPrincipalController;
	private PDFExporter pdfExporter;

	
	public UserController(UsersView view, VentanaPrincipalController ventanaController, List<User> users) 
	{
		this.model=new UserTableModel(users);
		this.view = view;
		this.ventanaPrincipalController = ventanaController;
		
		repo = new UserRepository();
		pdfExporter = new PDFExporter();
		
		
		// Boton Agregar ActionListener
		view.getBtnAdd().addActionListener(e -> {
			
			openForm(null,ventanaController);
			
			try {
				ventanaController.showUsers(); // Solo sirve si uso esto porque cargar users ya esta en openForm().
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		});
		
		
		// Boton Editar ActionListener
		this.view.getBtnEdit().addActionListener(e -> {
			
			int row = view.getSelectedRow();
			
			if(row == -1) {
				JOptionPane.showMessageDialog(view, "Selecciona un usuario");
				return;
			}
			
			openForm(model.getUserAt(row),ventanaController);

			try {
				ventanaPrincipalController.showUsers();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		
		// Boton Delete ActionListener
		view.getBtnDelete().addActionListener(e -> {
			
			int row = view.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(view, "Selecciona un usuario");
				return;
			}
			try {
				repo.delete(row);
				ventanaPrincipalController.showUsers();
			} 
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		this.view.getBtnPdf().addActionListener(e -> {
			
			generarPdf();
		});
	}
	
	
	private void openForm(User user, VentanaPrincipalController ventanaController) {
		
		int row = view.getSelectedRow();
		System.out.println(row);
		UserFormDialog dialog;
		if(user==null) {
			dialog = new UserFormDialog(null, user);
			new UserDialogController(dialog);
		}else {
			dialog = new UserFormDialog(null, user);
			new UserDialogController(dialog, user);
		}
		 
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
		
		cargarUsers();
	}
	
	
	public void cargarUsers() {	
		
		//System.out.println("Carga usuarios");
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
	
	public void generarPdf()
	{
		File file = view.selectPdfFile();
		
		if(file == null) { return; }
		
		try
		{
			pdfExporter.exportUsers(repo.getUsers(), file);
			
			if(Desktop.isDesktopSupported())
			{
				Desktop.getDesktop().open(file);
			}
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(view, "Error al exportar");
		}
	}
}




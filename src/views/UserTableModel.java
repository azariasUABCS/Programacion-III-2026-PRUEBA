package views;

import java.util.List;

import javax.swing.table.AbstractTableModel;



import modelos.User;
public class UserTableModel extends AbstractTableModel {
	private List<User> users;
	private final String[] columns= {
			"nombre",
			"apellidos",
			"email"
			
	};
	public UserTableModel(List<User> users) {
		this.users=users;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return users.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		User user=users.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return user.getNombre();
		case 1:
			return user.getApellido();
		case 2:
			return user.getCorreo();
		}
		return user;
		
	}

}

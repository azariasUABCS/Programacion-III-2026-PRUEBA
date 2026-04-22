package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tablemodels.UserTableModel;

public class UsersView extends JPanel{

	private JTable tabla;
	private JButton btnEditar;
	private JButton btnAgregar;
	private JButton btnEliminar;

	public UsersView() 
	{
		setLayout(new BorderLayout());
		tabla = new JTable();

		add(new JScrollPane(tabla), BorderLayout.CENTER);
		
		JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.LEFT));

        btnAgregar = new JButton("Agregar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");

        panelButtons.add(btnAgregar);
        panelButtons.add(btnEditar);
        panelButtons.add(btnEliminar);
        
        add(panelButtons, BorderLayout.NORTH);

	}

	public void setTableModel(UserTableModel model) 
	{
		tabla.setModel(model);
	}

	public JTable getTable() 
	{
		return tabla;
	}

	public JButton getBtnAdd() 
	{
        return btnAgregar;
    }

    public JButton getBtnEdit() {
        return btnEditar;
    }

    public JButton getBtnDelete() 
    {
        return btnEliminar;
    }
	
    public int getSelectedRow() 
    {
    	return tabla.getSelectedRow();
    }
}

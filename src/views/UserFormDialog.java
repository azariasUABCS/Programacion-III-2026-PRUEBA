package views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.UserDialogController;
import controllers.VentanaPrincipalController;
import modelos.User;
import respository.UserRepository;

public class UserFormDialog extends JDialog{

	public JTextField txtNombre;
	public JTextField txtApellido;
	public JTextField txtCorreo;
	
	public JLabel txtErrNombre = new JLabel(" ");
	public JLabel txtErrApellido = new JLabel(" ");
	public JLabel txtErrCorreo = new JLabel(" ");

    public JButton btnGuardar;
    public JButton btnCancelar;

    public User user;
    public boolean guardado = false;
    
    private UserRepository userRepository = new UserRepository();
    
    		
    public UserFormDialog(JFrame parent, User user) 
    {
    	super(parent, true);
    	
    	this.user = user;
    	
    	setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        add(createTitlePanel(), BorderLayout.NORTH);
        add(createFormPanel());
        add(createButtonPanel(), BorderLayout.SOUTH);
        
    }
    
    private JPanel createTitlePanel() 
    {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Formulario de Usuario"));
        return panel;
    }
    
    private JPanel createButtonPanel() {

        JPanel panel = new JPanel();

        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        panel.add(btnGuardar);
        panel.add(btnCancelar);
        
        btnCancelar.addActionListener(e -> dispose());
        
        return panel;
    }

    private JScrollPane createFormPanel() {

    	JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

		JScrollPane scroll = new JScrollPane(panel);
		scroll.setBorder(null);
		scroll.setHorizontalScrollBar(null);
		scroll.getVerticalScrollBar().setUnitIncrement(14);

		txtNombre = new JTextField();
		txtApellido = new JTextField();
		txtCorreo = new JTextField();

		panel.add(createField("Nombre:", txtNombre, txtErrNombre));
		panel.add(createField("Apellido:", txtApellido, txtErrApellido));
		panel.add(createField("Correo:", txtCorreo, txtErrCorreo));


		return scroll;
    }
    		
    private JPanel createField(String labelText, Component field, JLabel errorLabel) {

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel label = new JLabel(labelText);
		label.setMaximumSize(new Dimension(Integer.MAX_VALUE, label.getPreferredSize().height));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		errorLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, label.getPreferredSize().height));
		errorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel.add(label);
		panel.add(errorLabel);
		panel.add(field);

		return panel;
	}
    

    
    public Window getWindow()
    {
    	return this;
    }
    		
    public void agregarUser(String txtNombre, String txtApellido, String txtCorreo) throws IOException
	{
		User newUser = new User(txtNombre, txtApellido, txtCorreo);
		
		try
		{
			userRepository.save(newUser);
			System.out.println("Se Registro Usuario!");
			JOptionPane.showMessageDialog(this, "Usuario registrado");
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	} 		
    		
    public void eliminarUsuario()
    {
    	
    }
    		
}

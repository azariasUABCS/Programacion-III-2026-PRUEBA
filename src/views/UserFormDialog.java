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
import javax.swing.JPasswordField;
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
	public JPasswordField txtContraseña;
	public JLabel txtErrNombre = new JLabel(" ");
	public JLabel txtErrApellido = new JLabel(" ");
	public JLabel txtErrCorreo = new JLabel(" ");
	public JLabel txtErrContraseña = new JLabel(" ");

    public JButton btnGuardar;
    public JButton btnCancelar;

    public User user;
    public boolean guardado = false;
    
    private UserRepository userRepository = new UserRepository();
    
    		
    public UserFormDialog(JFrame parent, User user) 
    {
    	super(parent, true);
    	
    	
    	
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
		txtContraseña=new JPasswordField();

		panel.add(createField("Nombre:", txtNombre, txtErrNombre));
		panel.add(createField("Apellido:", txtApellido, txtErrApellido));
		panel.add(createField("Correo:", txtCorreo, txtErrCorreo));
		panel.add(createField("Contraseña:", txtContraseña, txtErrContraseña));

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
    		
    public void agregarUser(String txtNombre, String txtApellido, String txtCorreo, String txtContraseña) throws IOException
	{
		User newUser = new User(txtNombre, txtApellido, txtCorreo, txtContraseña);
		
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

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	

	public JPasswordField getTxtContraseña() {
		return txtContraseña;
	}

	public void setTxtContraseña(JPasswordField txtContraseña) {
		this.txtContraseña = txtContraseña;
	}

	public JLabel getTxtErrNombre() {
		return txtErrNombre;
	}

	public void setTxtErrNombre(JLabel txtErrNombre) {
		this.txtErrNombre = txtErrNombre;
	}

	public JLabel getTxtErrApellido() {
		return txtErrApellido;
	}

	public void setTxtErrApellido(JLabel txtErrApellido) {
		this.txtErrApellido = txtErrApellido;
	}

	public JLabel getTxtErrCorreo() {
		return txtErrCorreo;
	}

	public void setTxtErrCorreo(JLabel txtErrCorreo) {
		this.txtErrCorreo = txtErrCorreo;
	}

	public JLabel getTxtErrContraseña() {
		return txtErrContraseña;
	}

	public void setTxtErrContraseña(JLabel txtErrContraseña) {
		this.txtErrContraseña = txtErrContraseña;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isGuardado() {
		return guardado;
	}

	public void setGuardado(boolean guardado) {
		this.guardado = guardado;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
    	
	 
}

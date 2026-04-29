package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelos.User;
import respository.UserRepository;
import utils.Colores;
import utils.PanelPersonalizable;

public class FormularioRegistro extends JFrame{
    
	
	// Puro Fonts, ya depues hare otra clase de Fonts
    public Font fuente;
    private Font fontError = new Font("Times New Roman", Font.ITALIC, 12);
    private Font fontTextoCampo = new Font("Times New Roman", Font.ITALIC, 15);
    private Font fontBoton = new Font("Times New Roman", Font.BOLD, 20);
    private Font fontTitulo = new Font("Times New Roman", Font.BOLD, 35);
    
    
    // Fields de Texto para Usuario
    public JTextField nombres;
    public JTextField apellidos;
    public JTextField correo;
    public JTextField contraseña;
    
    // JBotones para Regsitro Controller
    public JButton registrar = new JButton(" Registrarse");
   
    private UserRepository userRepository;
    
    // Labels de Error
    public JLabel lblErrorNombre;
    public JLabel lblErrorApellido;
    public JLabel lblErrorCorreo;
    public JLabel lblErrorContrasena;
    
    
    public FormularioRegistro()
    {
    	userRepository = new UserRepository();
    	
        setSize(850, 675);
        setLayout(null);
        setResizable(false);
        setTitle("Registro");
        setLocationRelativeTo(null);
        getContentPane().setBackground(Colores.BACKGROUND);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
		ImageIcon cursorImage = new ImageIcon("src\\img\\pointer_b.png");
		Cursor myCursor = tk.createCustomCursor(cursorImage.getImage(), new Point(0,0), "Cursor");
		this.setCursor(myCursor);
        
        PanelPersonalizable fondo = new PanelPersonalizable();
        fondo.setBounds(75, 50, 680, 550);
        fondo.setBackground(Colores.LOGIN_PANEL);
        
        // Shadow
        PanelPersonalizable fondo2 = new PanelPersonalizable();
        fondo2.setBounds(72, 46, 687, 557);
        fondo2.setBackground(Colores.SHADOW_COLOR);
        

        JPanel panelComponentes = new JPanel();
        panelComponentes.setLayout(new BoxLayout(panelComponentes, BoxLayout.Y_AXIS));
        panelComponentes.setBounds(70, 50, 680, 550);
        panelComponentes.setOpaque(false);
        panelComponentes.setBorder(new EmptyBorder(20, 40, 20, 40));
        
        // Para centrar todos los componentes
        panelComponentes.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        JLabel saludo = new JLabel("Registrate");
        saludo.setOpaque(false);
        saludo.setFont(fontTitulo);
        saludo.setForeground(Colores.TEXT_COLOR);
        saludo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panelComponentes.add(saludo);
        panelComponentes.add(Box.createRigidArea(new Dimension(0,35)));

        lblErrorNombre = crearErrorLabel();
        lblErrorApellido = crearErrorLabel();
        lblErrorCorreo = crearErrorLabel();
        lblErrorContrasena = crearErrorLabel();
        
        
        crearComponentesDeRegistro(panelComponentes);
        
        
        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new BoxLayout(panelBoton, BoxLayout.Y_AXIS));
        panelBoton.setOpaque(false);
        panelBoton.setAlignmentX(Component.CENTER_ALIGNMENT);

        crearBoton(registrar, "..\\img\\icono.png");
        
        registrar.addMouseListener(new MouseAdapter() 
        {
			public void mouseEntered(MouseEvent e) 
			{
				changeBackground(registrar);
			}
			
			public void mouseExited(MouseEvent e) 
			{
				resetBackground(registrar);
			}
		});
        

        panelComponentes.add(Box.createRigidArea(new Dimension(0,15)));
        panelBoton.add(registrar);
        panelComponentes.add(panelBoton);
        
        
        panelComponentes.add(Box.createRigidArea(new Dimension(0, 20)));
        
        add(panelComponentes);
        add(fondo);
        add(fondo2);

        setVisible(true);
    }
    
    
    private JTextField crearTextField(String placeholder, String JTextFieldName) 
    {
        JTextField textField = new JTextField(placeholder);
        
        int fieldWidth = 400;
        int fieldHeight = 45;
        
        textField.setMaximumSize(new Dimension(fieldWidth, fieldHeight));
        textField.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        textField.setMinimumSize(new Dimension(fieldWidth, fieldHeight));
        
        textField.setBackground(Colores.BACKGROUND);
        textField.setForeground(Color.BLACK);
        textField.setFont(fontTextoCampo);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setName(JTextFieldName);
        
        return textField;
    }
    
    private void asignarFocusListenerConPlaceholder(JTextField textField, String placeholder) {
    	
    	textField.setBackground(Colores.TABBED_TEXT_COLOR);
    	
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                    textField.setBackground(Color.WHITE);
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.BLACK);
                    textField.setBackground(Colores.TABBED_TEXT_COLOR);
                } else {
                	textField.setForeground(Color.BLACK);
                    textField.setBackground(Colores.TABBED_TEXT_COLOR);
                }
            }
        });
    }
    
    private void crearBoton(JButton button, String ruta)
    {
        int buttonWidth = 200;   
        int buttonHeight = 50;   
        
        button.setBackground(Colores.BUTTON_COLOR1);
        button.setForeground(Color.black);
        button.setToolTipText("Registrarse");
        button.setFont(fontBoton);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(buttonWidth, buttonHeight));
        button.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        button.setMinimumSize(new Dimension(buttonWidth, buttonHeight));
        
        try 
        {
            Image icono = ImageIO.read(getClass().getResource(ruta));
            icono = icono.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(icono));
        }
        catch (Exception ex)
        {
            System.out.println("No se pudo poner el icono");
        }
    }
    
    private JLabel crearErrorLabel() 
    {
        JLabel label = new JLabel("");
        label.setFont(fontError);
        label.setForeground(Color.RED);
        label.setMaximumSize(new Dimension(400, 20));
        label.setPreferredSize(new Dimension(400, 20));
        label.setMinimumSize(new Dimension(400, 20));
        label.setAlignmentX(Component.LEFT_ALIGNMENT); // CAMBIADO: Alinear a la izquierda
        label.setHorizontalAlignment(SwingConstants.LEFT); // CAMBIADO: Texto alineado a la izquierda
        return label;
    }
    
    public void resetearErrorLabels() 
    {
		lblErrorNombre.setText("");
		lblErrorApellido.setText("");
		lblErrorCorreo.setText("");
		lblErrorContrasena.setText("");
    }
    
    public void crearComponentesDeRegistro(JPanel panelComponentes)
    {
        nombres = crearTextField("Nombre", "nombres");
        apellidos = crearTextField("Apellido", "apellidos");
        correo = crearTextField("correo@ejemplo.com", "correo");
        contraseña = crearTextField("Contraseña", "contraseña");
        
        asignarFocusListenerConPlaceholder(nombres, "Nombre");
        asignarFocusListenerConPlaceholder(apellidos, "Apellido");
        asignarFocusListenerConPlaceholder(correo, "correo@ejemplo.com");
        asignarFocusListenerConPlaceholder(contraseña, "Contraseña");
        
        
        JPanel panelNombreWrapper = new JPanel();
        panelNombreWrapper.setLayout(new BoxLayout(panelNombreWrapper, BoxLayout.Y_AXIS));
        panelNombreWrapper.setOpaque(false);
        panelNombreWrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelNombreWrapper.setMaximumSize(new Dimension(400, 70));
        
        nombres.setAlignmentX(Component.LEFT_ALIGNMENT); 
        panelNombreWrapper.add(nombres);
        panelNombreWrapper.add(Box.createRigidArea(new Dimension(0, 5)));
        
        lblErrorNombre.setAlignmentX(Component.LEFT_ALIGNMENT); 
        panelNombreWrapper.add(lblErrorNombre);
        
        panelComponentes.add(panelNombreWrapper);
        panelComponentes.add(Box.createRigidArea(new Dimension(0, 15)));
        
        // Panel para Apellido
        JPanel panelApellidoWrapper = new JPanel();
        panelApellidoWrapper.setLayout(new BoxLayout(panelApellidoWrapper, BoxLayout.Y_AXIS));
        panelApellidoWrapper.setOpaque(false);
        panelApellidoWrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelApellidoWrapper.setMaximumSize(new Dimension(400, 70));
        
        apellidos.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelApellidoWrapper.add(apellidos);
        panelApellidoWrapper.add(Box.createRigidArea(new Dimension(0, 5)));
        
        lblErrorApellido.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelApellidoWrapper.add(lblErrorApellido);
        
        panelComponentes.add(panelApellidoWrapper);
        panelComponentes.add(Box.createRigidArea(new Dimension(0, 15)));
        
        // Panel para Correo
        JPanel panelCorreoWrapper = new JPanel();
        panelCorreoWrapper.setLayout(new BoxLayout(panelCorreoWrapper, BoxLayout.Y_AXIS));
        panelCorreoWrapper.setOpaque(false);
        panelCorreoWrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCorreoWrapper.setMaximumSize(new Dimension(400, 70));
        
        correo.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelCorreoWrapper.add(correo);
        panelCorreoWrapper.add(Box.createRigidArea(new Dimension(0, 5)));
        
        lblErrorCorreo.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelCorreoWrapper.add(lblErrorCorreo);
        
        panelComponentes.add(panelCorreoWrapper);
        panelComponentes.add(Box.createRigidArea(new Dimension(0, 15)));
        
        // Panel para Contraseña
        JPanel panelContrasenaWrapper = new JPanel();
        panelContrasenaWrapper.setLayout(new BoxLayout(panelContrasenaWrapper, BoxLayout.Y_AXIS));
        panelContrasenaWrapper.setOpaque(false);
        panelContrasenaWrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelContrasenaWrapper.setMaximumSize(new Dimension(400, 70));
        
        contraseña.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelContrasenaWrapper.add(contraseña);
        panelContrasenaWrapper.add(Box.createRigidArea(new Dimension(0, 5)));
        
        lblErrorContrasena.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelContrasenaWrapper.add(lblErrorContrasena);
        
        panelComponentes.add(panelContrasenaWrapper);
        
        panelComponentes.add(Box.createVerticalGlue());
    }
    
    
   // Getters
    public String getNombre() {
        String text = nombres.getText();
        return text.equals("Nombre") ? "" : text;
    }
    
    public String getApellido() {
        String text = apellidos.getText();
        return text.equals("Apellido") ? "" : text;
    }
    
    public String getCorreo() {
        String text = correo.getText();
        return text.equals("correo@ejemplo.com") ? "" : text;
    }
    
    public String getContraseña() {
        String text = contraseña.getText();
        return text.equals("Contraseña") ? "" : text;
    }
    
    
    
    Color defaultColor = Color.GRAY;
	Color clickedColor = Color.GRAY;
	
	private void changeBackground(JComponent c)
	{
		defaultColor = c.getBackground();
		c.setBackground(clickedColor);
		c.setForeground(Color.WHITE);
	}
	
	private void resetBackground(JComponent c)
	{
		c.setBackground(defaultColor);
		c.setForeground(Color.BLACK);
	}
	
	public Window getWindow()
	{
		return this;
	}
	
	public void registerUser(User user)
	{
		try
		{
			userRepository.save(user);
			System.out.println("Se Registro Usuario!");
			JOptionPane.showMessageDialog(this, "Usuario registrado");
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
}
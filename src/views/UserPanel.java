package views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.*;
import javax.swing.border.LineBorder;

import modelos.User;
import utils.Colores;

public class UserPanel extends JPanel {
	private Font fontTexto = new Font("Times New Roman", Font.BOLD, 17);
	private JButton session;
	User user;
	public UserPanel(User user) 
	{	
		this.user=user;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Colores.PROFILE_PANEL);
		setVisible(true);
		setBorder(new LineBorder(Colores.LOGIN_PANEL, 10));
		JLabel icono;
		try {
			icono=new JLabel(escalarImagen(this.user.getFoto(), 200, 200));
		} catch (Exception e) {
			// TODO: handle exception
			icono=new JLabel(escalarImagenLocal("..\\img\\icono.png", 200, 200));
		}
		
		icono.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel usrNombre= new JLabel(this.user.getNombre());
		usrNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel usrApellido= new JLabel(this.user.getApellido());
		usrApellido.setAlignmentX(Component.CENTER_ALIGNMENT);
		session=new JButton("iniciar");
		session.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		usrNombre.setFont(fontTexto);
		usrApellido.setFont(fontTexto);
		add(icono);
		add(usrNombre);
		add(usrApellido);
		add(session);
		
	}
	private ImageIcon escalarImagen(String direccion,int x,int y) throws Exception {
    	//System.out.println(direccion);
        ImageIcon iconoOriginal = new ImageIcon(direccion);

       
        Image imagenEscalada = iconoOriginal.getImage()
                .getScaledInstance(x, y, Image.SCALE_SMOOTH);

        
        ImageIcon iconoFinal = new ImageIcon(imagenEscalada);
        iconoFinal.setDescription(direccion);
        
        if(iconoFinal.getDescription().equals("null"));
        
        return iconoFinal;
	}
	private ImageIcon escalarImagenLocal(String direccion,int x,int y) {
		System.out.println("nigga");
	    ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(direccion));
	
	   
	    Image imagenEscalada = iconoOriginal.getImage()
	            .getScaledInstance(x, y, Image.SCALE_SMOOTH);
	
	    
	    ImageIcon iconoFinal = new ImageIcon(imagenEscalada);
	    iconoFinal.setDescription(direccion);
	    return iconoFinal;
	}
	public JButton getSession() {
		return session;
	}
	public void setSession(JButton session) {
		this.session = session;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Window getWindow() {
		return SwingUtilities.getWindowAncestor(this);
	}
}

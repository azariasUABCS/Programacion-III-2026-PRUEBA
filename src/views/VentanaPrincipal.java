package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.IOException;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.*;

import controllers.VentanaPrincipalController;
import modelos.User;
import respository.UserRepository;

public class VentanaPrincipal extends JFrame 
{
	public static final String HOME = "HOME";
	public static final String USERS = "USERS";
	
	public JMenuItem mItemExit;
	public JButton btnUsers;

	public JButton btnHome;
	
	public JButton btnAdd;
	public JButton btnMod;
	public JButton btnDel;
	
	public UsersView usersPanel;
	
	private CardLayout cardLayout;
	private JPanel container;
	
	
	public VentanaPrincipal() 
	{
		setSize(800, 600);
		setTitle("Mi aplicación");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setMenu();
		
		createNavbar();
		createViews();

		setVisible(true);
	}
	
	public void createNavbar() 
	{
		JPanel navbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		btnHome = new JButton("Inicio");
		btnUsers = new JButton("Usuarios");
		
		btnAdd = new JButton("Añadir");
		btnMod = new JButton("Modificar");
		btnDel = new JButton("Eliminar");
		
		navbar.add(btnHome);
		navbar.add(btnUsers);
		navbar.add(btnAdd);
		navbar.add(btnMod);
		navbar.add(btnDel);
		add(navbar, BorderLayout.NORTH);
	}
	
	private void createViews() 
	{
		cardLayout = new CardLayout();
		container = new JPanel(cardLayout);
		
		JPanel homePanel = new JPanel();
		homePanel.add(new JLabel("Bienvenido al Sistema"));
		
		usersPanel = new UsersView();
		
		container.add(homePanel, HOME);
		container.add(usersPanel, USERS);
		
		add(container, BorderLayout.CENTER);
		
	}
	
	public void showView(String view) 
	{
		cardLayout.show(container, view);
	}

	public void setMenu() {

	    JMenuBar mb = new JMenuBar();
	    setJMenuBar(mb);

	    JMenu menuFile = new JMenu("File");
	    menuFile.setMnemonic(KeyEvent.VK_F);
	    mb.add(menuFile);

	    JMenuItem mItemOpen = new JMenuItem("Open");
	    mItemOpen.setMnemonic(KeyEvent.VK_O);
	    menuFile.add(mItemOpen);

	    JMenuItem mItemSave = new JMenuItem("Save");
	    mItemSave.setMnemonic(KeyEvent.VK_S);
	    menuFile.add(mItemSave);

	    menuFile.addSeparator();

	    mItemExit = new JMenuItem("Exit");
	    mItemExit.setMnemonic(KeyEvent.VK_E);
	    menuFile.add(mItemExit);

	    JMenu menuOtherOption = new JMenu("Other Option");
	    menuOtherOption.setMnemonic(KeyEvent.VK_O);
	    mb.add(menuOtherOption);

	    JMenu menuOption1 = new JMenu("Option 1");
	    menuOtherOption.add(menuOption1);

	    JMenuItem mItemOption3 = new JMenuItem("Option 3");
	    menuOption1.add(mItemOption3);

	    JMenuItem mItemOption2 = new JMenuItem("Option 2");
	    menuOtherOption.add(mItemOption2);

	}
	
	public int confirmExit() 
	{
	    return JOptionPane.showConfirmDialog(
	        this,
	        "¿Seguro que deseas regresar? Se perderán todos los datos",
	        "¿Seguro?",
	        JOptionPane.YES_NO_OPTION
	    );
	}

}
	

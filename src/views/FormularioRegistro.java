package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FormularioRegistro extends JFrame{
	
	public Font fuente;
	
	
	public FormularioRegistro()
	{
		setSize(300, 500); // Hace lo mismo de setSize y setLocation.
		
		
		setResizable(false);  // No se puede cambiar de tamaño con el mouse.
		setTitle("Registro");  // Nombre de la Ventana.
		
		
		setLocationRelativeTo(null);  // Pone la ventana en el centro
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la penstaña, si no se queda abrierta.
		
		
		inicializarComponentes();
	
		setVisible(true);  // Siempre agrega el set visible antes del final.
	}
	
	public void inicializarComponentes()
	{
		JLabel lblTitulo = new JLabel("Registro");
		
		lblTitulo.setFont(fuente);
		
		add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panelComponentes = new JPanel();
		
		panelComponentes.setLayout(new BoxLayout(panelComponentes, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < 15; i++) 
		{
			JLabel lbl = new JLabel("Campo " + i);
			panelComponentes.add(lbl);
			
			JTextField txt = new JTextField(15);
			panelComponentes.add(txt);
	
			panelComponentes.add(Box.createRigidArea(new Dimension(0,25)));
		}
		
		JScrollPane scroll = new JScrollPane(panelComponentes);
		scroll.setHorizontalScrollBar(null);
		add(scroll);
	}
}

	

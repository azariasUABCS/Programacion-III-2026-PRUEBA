package main;
import java.awt.Color;

import javax.swing.JPanel;


public class Panel extends JPanel{

	public int x;
	public int y;

	public Panel(Color colorPanel, int x, int y)
	{
		//setBackground(Color.red);
		//setBackground(new Color(125, 221, 57)); // Pones tu color de RGB con un Object Anonimo.
		
		setSize(x,y);
		setBackground(colorPanel); 
	}
	
}

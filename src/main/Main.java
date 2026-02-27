package main;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import com.formdev.flatlaf.FlatLightLaf;

import views.Ventana;


public class Main {
	
	public static void main(String[] args)
	{
		FlatLightLaf.setup(); 
		
		Ventana ventanita = new Ventana();
	}
}

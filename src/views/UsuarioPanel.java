package views;

import javax.swing.*;
import javax.swing.border.LineBorder;

import utils.Colores;

public class UsuarioPanel extends JPanel {
	public UsuarioPanel() {
		setLayout(null);
		setBackground(Colores.BLACKBERRY_CREAM);
		setVisible(true);
		setBorder(new LineBorder(Colores.MIDNIGHT_VIOLET, 10));
	}
}

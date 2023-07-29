package combobox;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// BREINNER BENITEZ - JUNIOR CON DESEOS DE APRENDER MAS Y TABJAR EN MI PASION, GRACIAS POR VER.
public class JCombob {

	public static void main(String[] args) {

		Combomarco marco = new Combomarco();

		marco.setDefaultCloseOperation(3);
		marco.setVisible(true);

	}

}

class Combomarco extends JFrame {

	public Combomarco() {

		setTitle("ComboBox");

		setBounds(0, 0, 350, 350);

		Panelcombo p = new Panelcombo();
		
		Toolkit toolkit =  Toolkit.getDefaultToolkit();
		
		Image image= toolkit.getImage("src/combobox/imagenes/foto.png");
		
		setIconImage(image);
		
		add(p);
	}

}

class Panelcombo extends JPanel {

	private JTextArea area;
	private JComboBox combo;

	public Panelcombo() {

		setLayout(new BorderLayout(10, 20));
		// se agrego lamina con el combo box

		JPanel lamina = new JPanel();

		add(lamina, BorderLayout.NORTH);

		combo = new JComboBox();
		combo.setEditable(true);
		lamina.add(combo);

		combo.addItem("selecionar");
		combo.addItem("serif");
		combo.addItem("arial");

		// text Area para el texto
		area = new JTextArea("ingresa texto y seleciona porfavor",10, 20);

		JScrollPane scroll = new JScrollPane(area);

		JPanel laminacentro = new JPanel();

		add(laminacentro, BorderLayout.CENTER);

		laminacentro.add(scroll);

		area.setFont(new Font("area", Font.PLAIN, 14));

		comboevento evento = new comboevento();

		combo.addActionListener(evento); // evento

	}

	private class comboevento implements ActionListener { // clase interna y privada

		public void actionPerformed(ActionEvent e) {

			Object selecion = combo.getSelectedItem();
			int funcion = 0;
			/*
			 * if (selecion == "arial") { funcion += Font.BOLD;
			 * 
			 * area.setFont(new Font("arial", funcion, 14));
			 * 
			 * } if (selecion == "serif") { funcion += Font.BOLD; area.setFont(new
			 * Font("serif", funcion, 14));
			 * 
			 * 
			 * 
			 * }
			 */
			area.setFont(new Font((String) combo.getSelectedItem(), 1, 14));
		}

	}
}
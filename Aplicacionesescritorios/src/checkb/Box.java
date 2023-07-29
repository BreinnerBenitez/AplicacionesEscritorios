package checkb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//BREINNER BENITEZ - JUNIOR CON DESEOS DE APRENDER MAS Y TABAJAR EN MI PASION, GRACIAS POR VER.
public class Box {

	public static void main(String[] args) {
		VentanaMarco venta = new VentanaMarco();
		venta.setDefaultCloseOperation(3);
		venta.setVisible(true);

	}

}

class VentanaMarco extends JFrame {

	public VentanaMarco() {

		setTitle("CheckBox");
		setBounds(0, 0, 350, 350);
		panelcheck p = new panelcheck();
		
       Toolkit toolkit =  Toolkit.getDefaultToolkit();
		
		Image image= toolkit.getImage("src/checkb/imagenes/foto.png");
		
		setIconImage(image);
		add(p);
	}

}

class panelcheck extends JPanel {
	private JLabel texto;
	private JCheckBox check1, check2;

	public panelcheck() {

		setLayout(new BorderLayout());
		Font miletra = new Font("Serif", Font.PLAIN, 24);
		// parte de arriba
		JPanel panel1 = new JPanel();

		texto = new JLabel(" Breinner Benitez - Junnior ");

		texto.setFont(miletra);

		add(panel1, BorderLayout.NORTH);

		panel1.add(texto);

		// parte de abajo
		JPanel panel2 = new JPanel();

		panel2.setLayout(new GridLayout(1, 2));

		add(panel2, BorderLayout.SOUTH);

		check1 = new JCheckBox("Negrita");
		check2 = new JCheckBox("Cursiva");

		panel2.add(check1);
		panel2.add(check2);

		check1.addActionListener(new checkevento());
		check2.addActionListener(new checkevento());
	}

	private class checkevento implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			int tipo = 0;

			if (check1.isSelected()) {
				tipo += Font.BOLD;
				}
			if (check2.isSelected()) {
				tipo += Font.ITALIC;
				}

			texto.setFont(new Font("Serif", tipo, 24));

		}

	}

}
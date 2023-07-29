package contraseña;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;


// BREINNER BENITEZ - JUNIOR CON DESEOS DE APRENDER MAS Y TABAJAR EN MI PASION, GRACIAS POR VER.

public class Contraseñaevento {

	public static void main(String[] args) {

		Ventanacontraseña ventana = new Ventanacontraseña();
		ventana.setDefaultCloseOperation(3);

	}

}

class Ventanacontraseña extends JFrame {

	public Ventanacontraseña() {

		setTitle("contraseña_junior_Breinner");
		setBounds(0, 0, 350, 350);

		Panelcontra panel = new Panelcontra();
		
		Toolkit toolkit =  Toolkit.getDefaultToolkit();
		
		Image image= toolkit.getImage("src/contraseña/imagenes/foto.png");
		
		setIconImage(image);
		add(panel);
		setVisible(true);

	}

}

class Panelcontra extends JPanel {
	JPasswordField texto2;

	public Panelcontra() {
		setLayout(new BorderLayout());
     // parte del usuario 
		JPanel lamina2 = new JPanel();
		lamina2.setLayout(new GridLayout(2, 2, 0, 10));
		add(lamina2, BorderLayout.NORTH);
		JLabel usuario = new JLabel("usuario");
		lamina2.add(usuario);
		JTextField texto = new JTextField(10);
		lamina2.add(texto);
  // parte de la contraseña
		JLabel contraseña = new JLabel("contraseña");
		lamina2.add(contraseña);
		texto2 = new JPasswordField(10);
		lamina2.add(texto2);

		JButton botonenviar = new JButton("enviar");

		add(botonenviar, BorderLayout.SOUTH);
		
		// evento de contraseña
		contraseñaevento evento = new contraseñaevento();

		Document textocon = texto2.getDocument();
		

		textocon.addDocumentListener(evento);
		// Evento de Enviar
		
		Eventoenviar event = new Eventoenviar();
		
	      botonenviar.addActionListener(event);
	}

	private class contraseñaevento implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {
			char[] contrasena;
			contrasena = texto2.getPassword();

			if (contrasena.length < 8 || contrasena.length > 12) {

				texto2.setBackground(Color.RED);
			} else {
				texto2.setBackground(Color.green);
			}
		}

		public void removeUpdate(DocumentEvent e) {

			char[] contrasena;
			contrasena = texto2.getPassword();

			if (contrasena.length < 8 || contrasena.length > 12) {

				texto2.setBackground(Color.RED);
			} else {
				texto2.setBackground(Color.green);
			}

		}

		public void changedUpdate(DocumentEvent e) {

		}

	}
	
	private class Eventoenviar implements ActionListener{

	
		public void actionPerformed(ActionEvent e) {
			
			JOptionPane.showMessageDialog(null, "Soy junior con ganas de aprender Gracias por estar aqui");
			
		}
		
		
	}
}

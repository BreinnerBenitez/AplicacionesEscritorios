package calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class Calculadora {

	
	// BREINNER BENITEZ - JUNIOR CON DESEOS DE APRENDER MAS Y TABAJAR EN MI PASION, GRACIAS POR VER.
	
	public static void main(String[] args) {

		marcocal calculadora = new marcocal();

		calculadora.setDefaultCloseOperation(3);

	}

}

class marcocal extends JFrame { 

	public marcocal() {

		setTitle("CALCULADORA Junior-Breinner");
		setBounds(100, 100, 350, 350);

		panelcalc lamina1 = new panelcalc();
		add(lamina1);
		
		Toolkit toolkit =  Toolkit.getDefaultToolkit();
		
		//Image image= toolkit.getImage("src/calculadora/imagenes/foto.png");
		Image image= toolkit.getImage("imagenes/cortar.png");
		
		setIconImage(image);
		
		setVisible(true);

	}

}

class panelcalc extends JPanel {

	JPanel lamina2 = new JPanel();
	private JButton display;
	private boolean principio = true;

	public panelcalc() {

		setLayout(new BorderLayout());

		display = new JButton("0");

		display.setEnabled(false);

		add(display, BorderLayout.NORTH);
		lamina2.setLayout(new GridLayout(4, 4));

		eventocalculadora insertar = new eventocalculadora();
		ActionListener operacion = new Accionopera();
		setponerboton("7", insertar);
		setponerboton("8", insertar);
		setponerboton("9", insertar);
		setponerboton("/", operacion);
		setponerboton("4", insertar);
		setponerboton("5", insertar);
		setponerboton("6", insertar);
		setponerboton("*", operacion);
		setponerboton("1", insertar);
		setponerboton("2", insertar);
		setponerboton("3", insertar);
		setponerboton("-", operacion);
		setponerboton("0", insertar);
		setponerboton(",", insertar);
		setponerboton("=", operacion);
		setponerboton("+", operacion);

		/*
		 * JButton boton1 = new JButton("1"); lamina2.add(boton1); JButton boton2 = new
		 * JButton("2"); lamina2.add(boton2); JButton boton3 = new JButton("3");
		 * lamina2.add(boton3); JButton boton4 = new JButton("4"); lamina2.add(boton4);
		 * JButton boton5 = new JButton("5"); lamina2.add(boton5); JButton boton6 = new
		 * JButton("6"); lamina2.add(boton6); JButton boton7 = new JButton("7");
		 * lamina2.add(boton7); JButton boton8 = new JButton("8"); lamina2.add(boton8);
		 * JButton boton9 = new JButton("9"); lamina2.add(boton9); JButton boton10 = new
		 * JButton("10"); lamina2.add(boton10); JButton boton11 = new JButton("*");
		 * lamina2.add(boton11); JButton boton12 = new JButton("+");
		 * lamina2.add(boton12); JButton boton13 = new JButton("-");
		 * lamina2.add(boton13); JButton boton14 = new JButton(".");
		 * lamina2.add(boton14); JButton boton15 = new JButton(",");
		 * lamina2.add(boton15); JButton boton16 = new JButton("");
		 * lamina2.add(boton16);
		 * 
		 * add(lamina2, BorderLayout.CENTER);
		 */

		ultimaoperacion = "=";
	}

	private void setponerboton(String rotulo, ActionListener oyente) {
		add(lamina2, BorderLayout.CENTER);

		JButton boton = new JButton(rotulo);

		boton.addActionListener(oyente);
		lamina2.add(boton);

	}

	private class eventocalculadora implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String Entrada = e.getActionCommand();

			if (principio) {

				display.setText("");
				principio = false;
			}
			display.setText(display.getText() + Entrada);

		}

	}

	private class Accionopera implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String operacion = e.getActionCommand();

			calcular(Double.parseDouble(display.getText()));
			ultimaoperacion = operacion; // coge la ultimaoperacion
			principio = true;

		}

		public void calcular(double x) {

			if (ultimaoperacion.equals("+")) {

				resultado += x;
				// System.out.println(resultado);

			} else if (ultimaoperacion.equals("-")) {

				resultado -= x;

			} else if (ultimaoperacion.equals("*")) {

				resultado *= x;

			} else if (ultimaoperacion.equals("/")) {

				resultado /= x;

			}

			else if (ultimaoperacion.equals("=")) {

				resultado = x;

			}

			display.setText("" + resultado);
		}

	}

	private double resultado;

	private String ultimaoperacion;
}

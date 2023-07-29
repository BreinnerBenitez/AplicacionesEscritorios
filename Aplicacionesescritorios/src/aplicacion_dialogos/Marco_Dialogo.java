package practica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.*;

public class Marco_Dialogo extends JFrame {

	public Marco_Dialogo() {

		setLayout(new BorderLayout());

		setTitle("Prueba de dialogos Breinner");

		setBounds(0, 0, 500, 500);

		JPanel lamina_cuadricula = new JPanel();

		lamina_cuadricula.setLayout(new GridLayout(2, 3));

		// primera caja

		String primeracaja[] = { "mensaje", "confirmar", "Opcion", "entrada" };

		lamina_tipo = new Lamina_Botones("tipo", primeracaja);

		lamina_cuadricula.add(lamina_tipo);

		add(lamina_cuadricula);

		// segunda caja

		String segundacaja[] = { "ERROR_MESEGE", "INFORMATION_MESSAGE", "WARNING MENSAGE", "QUESTION_MESAGE",
				"PLAIN_MESSAGE" };

		lamina2 = new Lamina_Botones("tipo de mensaje", segundacaja);

		lamina_cuadricula.add(lamina2);

		// tercera caja

		String terceracaja[] = { "Cadena", "Icono", "Componente", "Otros", "Object[]" };

		lamina3 = new Lamina_Botones("mensaje", terceracaja);

		lamina_cuadricula.add(lamina3);

		// CUARTA CAJA

		String cuartacaja[] = { "DEFAULT", "YES_NO_OPTION", "YES_CANCEL_OPTION", "OK_CANCEL_OPTION" };

		lamina4 = new Lamina_Botones("confirmar", cuartacaja);

		lamina_cuadricula.add(lamina4);

		// quinta caja

		String quintacaja[] = { "String[]", "Icon[]", "object[]" };

		lamina5 = new Lamina_Botones("opcion", quintacaja);

		lamina_cuadricula.add(lamina5);

		// Sexta Caja

		String sextacaja[] = { "campo de texto", "combo" };

		lamina6 = new Lamina_Botones("entrada", sextacaja);

		lamina_cuadricula.add(lamina6);

		// lamina mostrar

		JPanel panelmostrar = new JPanel();

		panelmostrar.setBackground(Color.gray);
		add(panelmostrar, BorderLayout.SOUTH);

		JButton mostrar = new JButton("Mostrar");

		accionmostrar evento = new accionmostrar();

		mostrar.addActionListener(evento);
		panelmostrar.add(mostrar);
		
		Toolkit toolkit =  Toolkit.getDefaultToolkit();

		Image imagen = toolkit.getImage("src/aplicacion_dialogos/imagenes/foto.png");
		
		setIconImage(imagen);
	}

	// --------------------------- PROPORCIONA EL MENSJAE 3----------------

	public Object damemensaje() {

		String s = lamina3.dameSeleccion();

		if (s.equals("Cadena")) {

			return cadenaMensaje;

		} else if (s.equals("Icono")) {

			return iconoMensaje;

		} else if (s.equals("Componente")) {

			return componentemensaje;

		} else if (s.equals("Otros")) {

			return ObjetoMensaje;

		} else if (s.equals("Object[]")) {

			return new Object[] { cadenaMensaje, iconoMensaje, componentemensaje, ObjetoMensaje };

		} else {

			return null;
		}

	}

	// ---------------------------------------------------------------------------//

	// -------------------------- METODO LAMINA 2 PARA MENSAJE icono
	// -----------------------//

	public int retornaimagen() {

		String selecionado = lamina2.dameSeleccion();

		int tipo_mensaje = 0;

		if (selecionado.equals("ERROR_MESEGE")) {

			return tipo_mensaje;

		} else if (selecionado.equals("INFORMATION_MESSAGE")) {

			return tipo_mensaje = 1;
		} else if (selecionado.equals("WARNING MENSAGE")) {

			return tipo_mensaje = 2;

		} else if (selecionado.equals("QUESTION_MESAGE")) {

			return tipo_mensaje = 3;

		} else if (selecionado.equals("PLAIN_MESSAGE")) {

			return tipo_mensaje = -1;

		} else {
			return -1;

		}

	}

	// ----------------------------------------------------------------------//

	// ---------------------METEDO LAMINA 4 PARA CONFIRMAR ----------------------//

	public int retornar_confirmar() {

		String selecionado = lamina4.dameSeleccion();

		int tipo_mensaje = 0;

		if (selecionado.equals("DEFAULT")) {

			return tipo_mensaje = 2;

		} else if (selecionado.equals("YES_NO_OPTION")) {

			return tipo_mensaje = 0;

		} else if (selecionado.equals("YES_CANCEL_OPTION")) {

			return tipo_mensaje = 1;

		} else if (selecionado.equals("OK_CANCEL_OPTION")) {

			return tipo_mensaje = 2;

		} else {
			return 0;

		}

	}

	// ----------------------------metodo lamina 5 ----------------------------//

	public Object[] dameOpciones(Lamina_Botones lamina) {

		String s = lamina.dameSeleccion();

		if (s.equals("String[]")) {

			return new String[] { "amarillo", "azul", "rojo" };

		} else if (s.equals("Icon[]")) {

			return new Object[] { new ImageIcon("src/copiar.png"), new ImageIcon("src/copiar.png"),
					new ImageIcon("src/copiar.png") };
		} else if (s.equals("object[]")) {

			return new Object[] { cadenaMensaje, iconoMensaje, componentemensaje, ObjetoMensaje };

		} else {

			return null;

		}

	}

	// -------------------------------------------------------------------//

	// ------------------------------------------- ACCION
	// EVENTO**------------------------------//
	private class accionmostrar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String selecion = lamina_tipo.dameSeleccion();

			if (lamina_tipo.dameSeleccion().equals("mensaje")) {

				JOptionPane.showMessageDialog(Marco_Dialogo.this, damemensaje(), "titulo", retornaimagen());

			} else if (lamina_tipo.dameSeleccion().equals("confirmar")) {

				JOptionPane.showConfirmDialog(Marco_Dialogo.this, damemensaje(), "confirmir", retornar_confirmar(), retornaimagen());

			} else if (lamina_tipo.dameSeleccion().equals("Opcion")) {

				JOptionPane.showOptionDialog(Marco_Dialogo.this, damemensaje(), "Opciones", 1, retornaimagen(),null, dameOpciones(lamina5), null);

			} else if (lamina_tipo.dameSeleccion().equals("entrada")) {
				
				if (lamina6.dameSeleccion().equals("campo de texto")) {
					
					String mensaje  =JOptionPane.showInputDialog(Marco_Dialogo.this,damemensaje(), "ingresa datos", retornaimagen());
				
					JOptionPane.showMessageDialog(null, "tu mensaje es:  "+mensaje);
				
				} else  {
					
					JOptionPane.showInputDialog(Marco_Dialogo.this,damemensaje(), "ingresa datos", retornaimagen(),null, new String[] {"Amarillo","Azul","Rojo"},"azul");
					
				}
				
				

			}

		}

	}

	// --------------------------------------------------------------------------------//

	private Lamina_Botones lamina_tipo, lamina2, lamina3, lamina4, lamina5, lamina6;
	private String cadenaMensaje = "mensaje";
	private Icon iconoMensaje = new ImageIcon("src/copiar.png");
	private Object ObjetoMensaje = new Date();
	private Component componentemensaje = new Laminaejemplo();

}

class Laminaejemplo extends JPanel {

	public Laminaejemplo() {

		setBackground(Color.yellow);

	}

	/*
	 * // ---------------------------------GRAFICO COMPONENTE MENSAJE //
	 * -----------------------------// public void pintComponent(Graphics g) {
	 * 
	 * super.paintComponents(g);
	 * 
	 * Graphics2D g2 = (Graphics2D) g;
	 * 
	 * Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(),
	 * getHeight()); g2.setPaint(Color.yellow);
	 * 
	 * g2.fill(rectangulo);
	 * 
	 * }
	 */

}

package ejercicioPro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.text.*;

public class Ejercicioprotext {

	public static void main(String[] Breinner) {

		Macroprotext mar = new Macroprotext();
		mar.setDefaultCloseOperation(3);

	}

}

class Macroprotext extends JFrame {

	public Macroprotext() {
		setTitle("procesa texto");
		setBounds(0, 0, 1000, 550);
		Panelprotext panel = new Panelprotext();
		add(panel);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Image imagen = toolkit.getImage("src/cuadrotexto/imagenes/foto.png");
		setIconImage(imagen);
		
		setVisible(true);
	}

}

class Panelprotext extends JPanel {
	JMenu Fuente;     
	JMenu Estilo;
	JMenu Tamano;
	// item de fuentes

	// area de texto
	JTextArea area;

	JTextArea area2;
	
	// eventos para click derecho
	JMenuItem Negrilla;
	JMenuItem Cursi; //cursiva
	
	

	public Panelprotext() {

		setLayout(new BorderLayout(0, 10));

		// panel del menu

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.GRAY);
		add(panelMenu, BorderLayout.NORTH);

		// menu
		JMenuBar Menu = new JMenuBar();

		// Opciones del panel de menu

		Fuente = new JMenu("Fuente");
		Estilo = new JMenu("Estilo");
		Tamano = new JMenu("Tamaño");

		// menu de breinner

		Menu.add(Fuente);
		Menu.add(Estilo);
		Menu.add(Tamano);
		panelMenu.add(Menu);
		// cuadro de texto

		area = new JTextArea();

		JScrollPane scroll = new JScrollPane(area);

		add(scroll, BorderLayout.CENTER);

		// lamina para que me muestre los resultados
		JPanel lamina2 = new JPanel();
		
		area2 = new JTextArea();
		JScrollPane scroll2 = new JScrollPane(area2);
		add(lamina2, BorderLayout.SOUTH);

		lamina2.add(scroll2);

		// fuente

		configuramenu("Arial", "Fuente", "arial", 9, 10,"");
		configuramenu("Cautier", "Fuente", "Curier", 9, 10,"");
		configuramenu("Verdana", "Fuente", "Verdana", 9, 10,"");

		// estilo

		configuramenu("Negrita", "Estilo", "", Font.BOLD, 1,"bin/graficos/copiar.png");
		configuramenu("Cursiva", "Estilo", "", Font.ITALIC, 1,"bin/graficos/cortar.png");
		
		JPopupMenu emergente = new  JPopupMenu();
		 Negrilla = new JMenuItem("Negrita");
		 
		 Cursi = new JMenuItem("Cursiva");
		 emergente.add(Negrilla);
		 emergente.add(Cursi);
		 area.setComponentPopupMenu(emergente);
		
		 eventopop evento = new eventopop();
		 Negrilla.addActionListener(evento);
		 Cursi.addActionListener(evento);
		 
		 
		 

		// tamaño

		configuramenu("12", "Tamaño", "", 9, 12,"");
		configuramenu("16", "Tamaño", "", 9, 16,"");
		configuramenu("20", "Tamaño", "", 9, 20,"");
		configuramenu("24", "Tamaño", "", 9, 24,"");

	}

	public void configuramenu(String menus, String tmenu, String tipoletra, int estilo, int tamano,String imagen) {
       
	
		JMenuItem elemen_menu = new JMenuItem(menus, new ImageIcon(imagen));

		if (tmenu == "Fuente") {

			Fuente.add(elemen_menu);
		} else if (tmenu == "Estilo") {

			Estilo.add(elemen_menu);

		} else if (tmenu == "Tamaño") {

			Tamano.add(elemen_menu);

		} else {
		}

		elemen_menu.addActionListener(new eventomen(menus, tipoletra, estilo, tamano));

		// elemen_menu.addActionListener(
		// arreglando.GestionaE(menus,tipoletra,estilo,tamano));
	}
	
	//pone negrilla , arial y  tamaño 14  o cursiva 
	private class eventopop implements ActionListener{

	
		public void actionPerformed(ActionEvent e) {
			
			
			Object click = e.getSource();
			
			if (click==Negrilla) {
				
				area.setFont(new Font("arial",1,14));
				String textoinfo = "tipo de texto: Arial - tipo de estilo: Negrilla  - numero letra: 14 ";
				area2.setText(textoinfo);
				
			}else {
				area.setFont(new Font("arial",2,14));
				String textoinfo = "tipo de texto: Arial - tipo de estilo: Cursiva   - numero letra: 14 ";
				area2.setText(textoinfo);
				
			}
			
		}
		
		
		
	}
	
	

	private class eventomen implements ActionListener {

		String tipotexto;
		String menu;
		int numeroletra;
		int estiloletra;

		public eventomen(String elemento, String tipotexto, int estiloletra, int numeroletra) {

			this.tipotexto = tipotexto;
			this.estiloletra = estiloletra;
			this.numeroletra = numeroletra;
			menu = elemento;
		}

		public void actionPerformed(ActionEvent e) {
			letras = area.getFont();

			if (menu == "Arial" || menu == "Courier" || menu == "Verdana") {
					
			
				estiloletra = letras.getStyle();
				numeroletra = letras.getSize();

			} else if (menu == "Cursiva" || menu == "Negrita") {
						
					if(letras.getStyle()==1 || letras.getStyle()==2) {
					
					 estiloletra=3;
					
				}
				tipotexto = letras.getFontName();
				numeroletra = letras.getSize();

			} else if (menu == "12" || menu == "16" || menu == "20" || menu == "24") {

				estiloletra = letras.getStyle();
				tipotexto = letras.getFontName();
			}
			area.setFont(new Font(tipotexto, estiloletra, numeroletra));
			String textoinfo = "tipo de texto: " + tipotexto + "- tipo de estilo: " + estiloletra + "- numero letra: "
					+ numeroletra;
			area2.setText(textoinfo);
		}

	}

	Font letras;
}
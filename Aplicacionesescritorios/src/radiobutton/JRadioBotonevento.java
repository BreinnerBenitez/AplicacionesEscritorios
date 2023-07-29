package radiobutton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//PROGRAMADOR JUNIOR BUSCANDO TRABAJO BREINNER BENITEZ, MUCHAS GRACIAS POR MIRAR

import javax.swing.*;
public class JRadioBotonevento {

	
	// BREINNER BENITEZ - JUNIOR CON DESEOS DE APRENDER MAS Y TABAJAR EN MI PASION, GRACIAS POR VER.
	
	
	
	public static void main(String[] Breinenr) {
		VentanaRadioB ventana = new VentanaRadioB ();
		
		ventana.setDefaultCloseOperation(3);
		
		ventana.setVisible(true);
		

	}

}

class VentanaRadioB extends JFrame{
	
	public VentanaRadioB () {
		
		setTitle ("RadioB_Junior_Breinner");
		setBounds (0,0,350,350);
		
		PaneleventoRadio panel = new PaneleventoRadio();
		
		Toolkit toolkit =  Toolkit.getDefaultToolkit();
		
		Image image= toolkit.getImage("src/radiobutton/imagenes/foto.png");
		
		setIconImage(image);
		
		add(panel);
		
	}
	
}

class PaneleventoRadio extends JPanel{
	
	private JRadioButton botonradio1 ; 
	private JRadioButton botonradio2 ; 
	private JRadioButton botonradio3 ; 
	private JTextField numero_texto;
	//JRadioButton botonradio4;
	private JTextArea area; 
	public PaneleventoRadio () {
		
		setLayout(new BorderLayout());   // lamina principal
		
		 area = new JTextArea ("ingresa texto y seleciona porfavor",10,10); // Texto area 
		
		JScrollPane panelScroll = new JScrollPane(area); // scroll con el texto de area
		
		add(panelScroll, BorderLayout.NORTH);
		
		// lamina del sur para los JRaddioButton
		
		JPanel laminas = new JPanel ();   
		
		add(laminas,BorderLayout.SOUTH);
		
		 botonradio1 = new JRadioButton("Negrilla");
		 botonradio2 = new JRadioButton("Cursiva");
		 botonradio3 = new JRadioButton("letra Arial + 2 de zoom");
		// botonradio4 = new JRadioButton("boton 4");
		 JLabel  letra = new JLabel("Numero de letra");
		 numero_texto= new JTextField("14",5);
		 
		 
		laminas.add(botonradio1);
		laminas.add(botonradio2);
		laminas.add(botonradio3);
		laminas.add(letra);
		laminas.add(numero_texto);
		ButtonGroup gruparadio = new ButtonGroup();
		
		
		
		
		gruparadio.add(botonradio1);
		gruparadio.add(botonradio2);
		gruparadio.add(botonradio3);
		
		//gruparadio.add(botonradio4);
	 eventoradio evento = new eventoradio ();
	 
	   botonradio1.addActionListener(evento);
	   botonradio2.addActionListener(evento);
	   botonradio3.addActionListener(evento);
	   numero_texto.addActionListener(evento);
	   //botonradio4.addActionListener(evento);
	}
	
	private class eventoradio implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			String N = numero_texto.getText();
			int numero= 24;
			 numero = Integer.parseInt(N);
			int funcion =0;
			if (botonradio1.isSelected()) {
				
				funcion+=Font.BOLD;
			} if(botonradio2.isSelected()) {
				
				funcion+=Font.ITALIC;
				
			} if (botonradio3.isSelected()) {
				
				funcion+=Font.ROMAN_BASELINE;
			} //if() {
				
				
			//}
			
			area.setFont(new Font("areal", funcion, numero));
		}
		
		
	}
	
}
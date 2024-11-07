package AWT;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//ESTA CLASE ES PARA PROBAR PONER EL LISTENER GENERAL EN UNA CLASE A PARTE Y LLAMARLO

public class EjRadioButton2 {
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Ejemplo JCheckBox");
		ventana.setSize(300,300);
		
		
		JLabel lb1 = new JLabel("Selecciona tu color favorito");
		JLabel lb2 = new JLabel("Etiqueta Seleccionada");
		JLabel lb3 = new JLabel("Etiqueta Deseleccionada");

		JRadioButton rb1 = new JRadioButton("Rojo");
		JRadioButton rb2 = new JRadioButton("Amarillo");
		JRadioButton rb3 = new JRadioButton("Verde");
		
		JPanel colores = new JPanel();
		
		colores.setLayout(new BoxLayout(colores, BoxLayout.Y_AXIS)); //Alineado todo, uno encima de otro
		ventana.setContentPane(colores);
		
		colores.add(lb1);
		ButtonGroup grupord = new ButtonGroup();
		grupord.add(rb1);
		grupord.add(rb2);
		grupord.add(rb3);
		
		colores.add(rb1);
		colores.add(rb2);
		colores.add(rb3);
		colores.add(lb2);
		colores.add(lb3);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Manera manual de que se cierre con la x
		ventana.setVisible(true);
		
		
		
		EscuchadorJRadioButton escuchador = new EscuchadorJRadioButton(lb2,lb3);
		
		
		rb1.addItemListener(escuchador);
		rb2.addItemListener(escuchador); 
		rb3.addItemListener(escuchador);
		
	}
	

}
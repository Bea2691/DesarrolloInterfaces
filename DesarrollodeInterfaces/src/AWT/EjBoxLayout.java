package AWT;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EjBoxLayout {

	public static void main(String[] args) {
		JFrame ventana = new JFrame ("BoxLayout Manager");
		Container contenedor = ventana.getContentPane();
		contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));
		
		
		contenedor.add(new JButton("Uno"));
		contenedor.add(new JButton("Dos"));
		contenedor.add(new JButton("Tres"));
		contenedor.add(new JButton("Cuatro"));
		contenedor.add(new JButton("Cinco"));
		
		ventana.setSize(400,100);
		ventana.setVisible(true);
		

	}

}

package AWT;

import java.awt.Component;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ej2BoxLayout {

	public static void main(String[] args) {
		JFrame ventana = new JFrame ("BoxLayout Manager");
		Container contenedor = ventana.getContentPane();
		contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));
		
		JButton boton = new JButton("Uno");
		boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		contenedor.add(boton);
		
		boton = new JButton("Dos");
		boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		contenedor.add(boton);
		
		boton = new JButton("Tres");
		boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		contenedor.add(boton);
		
		boton = new JButton("Cuatro");
		boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		contenedor.add(boton);
		
		boton = new JButton("Cinco");
		boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		contenedor.add(boton);


		
		ventana.setSize(400,400);
		ventana.setVisible(true);
		
		
		
		

	}

}

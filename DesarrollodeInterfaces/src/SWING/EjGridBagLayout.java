package SWING;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.JButton;
import javax.swing.JFrame;

public class EjGridBagLayout {

	
	
	public static void añadirComponentes(Container pane) {
		JButton boton;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints restricciones= new GridBagConstraints();
		
		restricciones.fill = GridBagConstraints.HORIZONTAL;
		
		boton = new JButton("Boton");
		restricciones.weightx = 0.5;
		restricciones.weighty = 1;
		restricciones.fill= GridBagConstraints.BOTH;
		restricciones.gridx =0;
		restricciones.gridy =0;
		pane.add(boton, restricciones);
		
		boton = new JButton("Boton2");
		restricciones.weightx = 0.5;
		restricciones.fill= GridBagConstraints.HORIZONTAL;
		restricciones.gridx =1;
		restricciones.gridy =0;
		pane.add(boton, restricciones);
		
		boton = new JButton("Boton3");
		restricciones.weightx = 0.5;
		restricciones.fill= GridBagConstraints.HORIZONTAL;
		restricciones.gridx =2;
		restricciones.gridy =0;
		pane.add(boton, restricciones);
		
		boton = new JButton("Yo ocupo tres columnas");
		restricciones.weightx = 0.0;
		restricciones.fill= GridBagConstraints.HORIZONTAL;
		restricciones.gridx =0;
		restricciones.gridy =1;
		restricciones.gridwidth= 3; //ocupa 3 columnas
		restricciones.ipady= 40;
		pane.add(boton, restricciones);

	
		boton = new JButton("Empiezo en b2");
		restricciones.weighty = 1;
		restricciones.fill= GridBagConstraints.HORIZONTAL;
		restricciones.gridx =1;
		restricciones.gridy =2;
		restricciones.gridwidth=2;
		restricciones.ipady= 0;
		restricciones.anchor = GridBagConstraints.PAGE_END;
		restricciones.insets= new Insets(10,0,0,0);
		pane.add(boton, restricciones);
		
		
		
		
	}
	private static void crearFrame() {
		JFrame frame = new JFrame("Ejemplo Gird Bag Layout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		añadirComponentes(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		crearFrame();

	}

}

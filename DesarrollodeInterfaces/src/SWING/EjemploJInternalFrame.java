package SWING;


import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class EjemploJInternalFrame {
	
	public EjemploJInternalFrame() {
		
		JFrame ventana = new JFrame();
		JButton boton = new JButton("Pulsar");
		boton.setBounds(135, 100, 80, 25);
		ventana.add(boton);
		
		//JDesktoppane permite que los componentes puedan solaparse
		JDesktopPane dpane = new JDesktopPane();
		ventana.getContentPane().add(dpane);
		
		
		//Contenido del JInternalFrame 
		JPanel panel1= new JPanel();
		panel1.setLayout(new FlowLayout());
		JLabel etiq1 = new JLabel("Primera etiqueta");
		panel1.add(etiq1);
		JTextField tf1= new JTextField(10);
		panel1.add(tf1);
		
		
		JPanel panel2= new JPanel();
		panel2.setLayout(new FlowLayout());
		JLabel etiq2 = new JLabel("Segunda etiqueta");
		panel2.add(etiq2);
		JButton boton2= new JButton();
		panel2.add(boton2);
		
		//Creamos Internal Frame
		JInternalFrame internal1= new JInternalFrame("Primer internal Frame");
		JInternalFrame internal2= new JInternalFrame("Primer internal Frame");
		internal1.add(panel1);
		internal2.add(panel2);
		
		//Tamaño a los Internal Frame
		internal1.pack();
		internal2.pack();
		
		//Por defecto, los internal frame no se pueden redimensionar y no aparecen con el boton de cerrar
		
		internal1.setResizable(true);
		internal1.setClosable(false);//Poder cerrar, no
		internal1.setIconifiable(true);//Minimizar
		
		internal2.setResizable(false);
		internal2.setClosable(true);//Poder cerrar, no
		internal2.setIconifiable(true);//Minimizar
		
		//Asociar los InternalFrame al DesktopPane
		dpane.add(internal1);
		dpane.add(internal2);
		
		//Visualizar el Frame principal y posteriormente los internal Frame
		ventana.setSize(400,400);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		internal1.setVisible(true);
		internal2.setVisible(true);
		
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tf1.setText("Pulsado botón");
				
			}
			
		});
	
		boton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tf1.setText("Pulsado botón segundo");
				
			}
			
		});
	}

	public static void main(String[] args) {
		new EjemploJInternalFrame();

	}

}

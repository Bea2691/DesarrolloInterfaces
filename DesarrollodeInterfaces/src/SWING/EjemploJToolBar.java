package SWING;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class EjemploJToolBar extends JFrame{

	JToolBar barra = new JToolBar();
	JButton boton1 = new JButton("Nuevo");
	JButton boton2= new JButton(new ImageIcon("src/SWING/azul.png"));
	JTextField campoTexto = new JTextField("Text Field");
	JButton boton3 = new JButton("Salir");
	
		
	
	public EjemploJToolBar() {
		super("Bara de Herramientas");
		setSize(350,200);
		setVisible(true);
		setLayout(new BorderLayout());
		add(barra, BorderLayout.NORTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		boton3.setBounds(135,100,80,25);
		boton3.setToolTipText("Salir");
		super.add(boton3);
		
		boton1.setToolTipText("Nuevo");
		barra.add(boton1);
		boton2.setToolTipText("Abrir");
		barra.add(boton2);
		barra.add(campoTexto);
		
		//Pintar borde de la barra de herramientas
		barra.setBorderPainted(true);
		
		
		//Para que la barra de herramientas no se pueda coger por los puntos y mover
		barra.setFloatable(false);
		
		//Eliminar el hober  de los elementos de la barra
		barra.setRollover(false);
		
		//Separador al final de la barra de herramientas
		barra.addSeparator();
		
		//Orientacion de los elementos de la barra
		barra.setOrientation(JToolBar.HORIZONTAL);
		
		
		boton1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				campoTexto.setText("Pulsado boton Nuevo");
			}
		});
		boton2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				campoTexto.setText("Pulsado icono");
			}
		});
		boton3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		new EjemploJToolBar();

	}

}

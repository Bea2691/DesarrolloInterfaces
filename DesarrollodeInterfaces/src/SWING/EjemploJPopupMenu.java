package SWING;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class EjemploJPopupMenu extends JFrame implements ActionListener {
	
	private JPopupMenu popup;
	private JMenuItem cortar,copiar,pegar;
	private JLabel etiqueta;
	private JButton boton;
	
	public EjemploJPopupMenu() {
		JFrame frame= new JFrame("Ejemplo POPup Menu ");
		JPopupMenu popupMenu = new JPopupMenu();
		
		boton= new JButton("Salir");
		boton.setBounds(110,200,100,30);
		frame.getContentPane().add(boton);
		boton.addActionListener(this);
		
		
		//Elementos del PopUp
		cortar = new JMenuItem("Cortar");
		popupMenu.add(cortar);
		copiar = new JMenuItem("Copiar");
		popupMenu.add(copiar);
		pegar = new JMenuItem("Pegar");
		popupMenu.add(pegar);
		
		cortar.addActionListener(this);
		copiar.addActionListener(this);
		pegar.addActionListener(this);
		
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(popupMenu);
		frame.setSize(300,300);
		
		etiqueta = new JLabel("");
		etiqueta.setBounds(70,10,150,30);
		frame.getContentPane().add(etiqueta);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//Captura el click dereho del raton
		frame.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//show(Componente, coordenada x y coordenada y
				if(e.getButton() == MouseEvent.BUTTON3) { //EL boton3 es el click derecho
				popupMenu.show(frame, e.getX(),e.getY());
				System.out.println(e.getX() + "----" + e.getY());
			}}
			
		});
		
	}

	public static void main(String[] args) {
		new EjemploJPopupMenu();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cortar) {
			etiqueta.setText("Capturado evento cortar");
		}
		if(e.getSource() == copiar) {
			etiqueta.setText("Capturado evento copiar");
		}
		if(e.getSource() == pegar) {
			etiqueta.setText("Capturado evento pegar");
		}
		if(e.getSource().equals(boton)) {
			System.exit(0);
		}
		
	}

}

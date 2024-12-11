package SWING;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatDarculaLaf;

public class EjJTabbedPane {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatDarculaLaf());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JFrame ventana = new JFrame("Ejemplo JTabbedPane");
		Container contenedor = ventana.getContentPane();
		
		JButton boton1 = new JButton("Botón 1");
		JButton boton2 = new JButton("Botón 2");
		JButton boton3 = new JButton("Botón 3");
		JButton boton31 = new JButton("Botón 31");
		JButton boton41 = new JButton("Botón 41");
		JLabel etiqueta = new JLabel("Etiqueta");
		
		JPanel panel = new JPanel();//Panel contenedor para los componentes
		
		panel.add(boton1);
		panel.add(boton2);
		panel.add(etiqueta);
		
		JPanel panel2 = new JPanel();
		panel2.add(boton3);
		
		JTabbedPane pestañas= new JTabbedPane();
		pestañas.add("Pestaña 1", panel);
		pestañas.add("Pestaña 2", panel2);
		pestañas.add("Pestaña 3", boton31);
		pestañas.add("Pestaña 4", boton41);
		
		//Colores de fondo en las pestañas
		pestañas.setBackgroundAt(0, Color.PINK);
		pestañas.setBackgroundAt(1, Color.LIGHT_GRAY);
		pestañas.setBackgroundAt(2, Color.PINK);
		pestañas.setBackgroundAt(3, Color.LIGHT_GRAY);
		//Color letra pestañas
		pestañas.setForeground(Color.BLACK);	
		
		//Iconos
		pestañas.setIconAt(0, new ImageIcon("C:\\Users\\Alum_DAM\\Desktop\\jojo.png"));
		pestañas.setIconAt(1, new ImageIcon("C:\\Users\\Alum_DAM\\Desktop\\jaja.png"));
		pestañas.setIconAt(2, new ImageIcon("C:\\Users\\Alum_DAM\\Desktop\\jojo.png"));
		pestañas.setIconAt(3, new ImageIcon("C:\\Users\\Alum_DAM\\Desktop\\jaja.png"));
		
		contenedor.add(pestañas);
		ventana.setSize(456,300);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		
		ActionListener botones;
		
		boton1.addActionListener(botones= new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String comando= e.getActionCommand();
				switch(comando) {
				case "Botón 1":
					System.out.println("Pulsado boton 1");
					JOptionPane.showMessageDialog(contenedor, "Seleccionado boton 1");
					break;
				case "Botón 2":
					System.out.println("Pulsado boton 2");
					JOptionPane.showMessageDialog(contenedor, "Seleccionado boton 2");
					break;
				case "Botón 3":
					System.out.println("Pulsado boton 3");
					JOptionPane.showMessageDialog(contenedor, "Seleccionado boton 3");
					break;
				case "Botón 31":
					System.out.println("Pulsado boton 31");
					JOptionPane.showMessageDialog(contenedor, "Seleccionado boton 31");
					break;
				case "Botón 41":
					System.out.println("Pulsado boton 41");
					JOptionPane.showMessageDialog(contenedor, "Seleccionado boton 41");
					break;
				}
				etiqueta.setText(comando);
				
			}
		});
		
		
		boton2.addActionListener(botones);
		boton3.addActionListener(botones);
		boton31.addActionListener(botones);
		boton41.addActionListener(botones);
		
	}

}

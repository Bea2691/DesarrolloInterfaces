package AWT;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjCardLayout2 extends JFrame {

	CardLayout tarjetas;
	JPanel panelTarjetas;

	public EjCardLayout2() {
		// Centrar JFrame en la pantalla
		setLocationRelativeTo(null);

		// Inicializamos a BorderLayout el Frame
		setLayout(new BorderLayout());

		// Creacion panel superior con botón para cambiar card
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.RED);

		// Añadir botón al panel superior
		JButton cambiarTarjeta = new JButton("Cambiar Tarjeta");

		cambiarTarjeta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// tarjetas es la instancia del Layout CardLayout que
				// utilizaremos para las dos tarjetas que tendremos
				// en nuestra interfaz

				tarjetas.next(panelTarjetas);
			}
		});

		// Añadir el boton al panel
		panelSuperior.add(cambiarTarjeta);
		// Anadir el panel a la parte norte del JFrame
		add(panelSuperior, BorderLayout.NORTH);

		// Inicialización del layout para el panel de las tarjetas
		tarjetas = new CardLayout();
		panelTarjetas = new JPanel();
		panelTarjetas.setLayout(tarjetas);

		// Inicializar los paneles de las tarjetas
		JPanel primeraTarjeta = new JPanel();
		primeraTarjeta.setBackground(Color.GREEN);
		JPanel segundaTarjeta = new JPanel();
		segundaTarjeta.setBackground(Color.BLUE);

		// Añadir botones a las tarjetas
		// Primera Tarjeta
		nuevoBoton(primeraTarjeta, "Manzanas");
		nuevoBoton(primeraTarjeta, "Naranjas");
		nuevoBoton(primeraTarjeta, "Plátanos");
		// Segunda Tarjeta
		nuevoBoton(segundaTarjeta, "Lechugas");
		nuevoBoton(segundaTarjeta, "Tomates");
		nuevoBoton(segundaTarjeta, "Cebollas");

		panelTarjetas.add(primeraTarjeta, "Frutas");
		panelTarjetas.add(segundaTarjeta, "Ensalada");

		add(panelTarjetas, BorderLayout.CENTER);

	}

	private void nuevoBoton(JPanel panel, String titulo) {
		JButton boton = new JButton(titulo);
		panel.add(boton);
	}

	public static void main(String[] args) {
		EjCardLayout2 formulario = new EjCardLayout2();
		formulario.setSize(400, 300);
		formulario.setTitle("Ejemplo de CardLayout");
		formulario.setDefaultCloseOperation(EXIT_ON_CLOSE);
		formulario.setVisible(true);
	}
}

package AWT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EjCardLayout {

	private JFrame frame;
	private CardLayout paneles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjCardLayout window = new EjCardLayout();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EjCardLayout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel panelSuperior = new JPanel();
		frame.getContentPane().add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setBackground(Color.RED);
		
		
		JButton cambiarTarjeta = new JButton("Cambiar Tarjeta");
		panelSuperior.add(cambiarTarjeta);
		
		JPanel panelInferior = new JPanel();
		frame.getContentPane().add(panelInferior, BorderLayout.CENTER);
		paneles = new CardLayout();
		panelInferior.setLayout(paneles);
		
		
		cambiarTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.next(panelInferior);;
			}
		});
		
				
		JPanel panelInferior1 = new JPanel();
		panelInferior.add(panelInferior1, "name_951349574131000");
		panelInferior1.setLayout(null);
		panelInferior1.setBackground(Color.GREEN);
		
		JPanel panelInferior2 = new JPanel();
		panelInferior.add(panelInferior2, "name_951353577383600");
		panelInferior2.setBackground(Color.BLUE);
		
	
		
		JButton btnNewButton = new JButton("Manzanas");
		btnNewButton.setBounds(85, 5, 85, 21);
		panelInferior1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Naranjas");
		btnNewButton_1.setBounds(175, 5, 85, 21);
		panelInferior1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Platanos");
		btnNewButton_2.setBounds(265, 5, 85, 21);
		panelInferior1.add(btnNewButton_2);
		
		JButton button = new JButton("New button");
		button.setBounds(85, 5, 85, 21);
		panelInferior1.add(button);
		panelInferior2.setLayout(null);
		
		
		JButton btnNewButton_3 = new JButton("Lechugas");
		btnNewButton_3.setBounds(103, 5, 75, 21);
		panelInferior2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Tomates");
		btnNewButton_4.setBounds(183, 5, 73, 21);
		panelInferior2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Cebollas");
		btnNewButton_5.setBounds(261, 5, 71, 21);
		panelInferior2.add(btnNewButton_5);
		
		JPanel panelInferior3 = new JPanel();
		panelInferior.add(panelInferior3, "name_952869121795900");
		panelInferior3.setLayout(null);
		panelInferior3.setBackground(Color.MAGENTA);
		
		JButton btnNewButton_6 = new JButton("Gato");
		btnNewButton_6.setBounds(124, 5, 53, 21);
		panelInferior3.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Perro");
		btnNewButton_7.setBounds(182, 5, 57, 21);
		panelInferior3.add(btnNewButton_7);
		
		JButton btnNewButton_7_1 = new JButton("Caballo");
		btnNewButton_7_1.setBounds(244, 5, 67, 21);
		panelInferior3.add(btnNewButton_7_1);
		
		
		
		
		
	}
}

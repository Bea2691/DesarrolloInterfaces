package AWT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EjTextField {

	private JFrame frame;
	private JTextField tf1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjTextField window = new EjTextField();
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
	public EjTextField() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tf1 = new JTextField();
		tf1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tf1.setEditable(false); //Esto es una chorrada, cuando da a enter no puede escribir mas
			}
		});
		
		tf1.setBounds(187, 80, 127, 19);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		JLabel lb1 = new JLabel("Texto:");
		lb1.setBounds(126, 83, 45, 13);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("Texto inicial");
		lb2.setBounds(85, 120, 298, 13);
		frame.getContentPane().add(lb2);
		
		JLabel lb3 = new JLabel("Texto final");
		lb3.setBounds(85, 143, 298, 13);
		frame.getContentPane().add(lb3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setEditable(true);
			}
		});
		btnNewButton.setBounds(181, 201, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		tf1.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				lb2.setText("Posicion final del texto marcado " + e.getDot());
				lb3.setText("Posicion inicial del texto marcado " + e.getMark());
			}
		});
	}
}

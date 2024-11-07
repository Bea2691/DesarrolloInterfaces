package AWT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PruebaJButtonMultiple extends JFrame implements ActionListener {

	private JFrame frame;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaJButtonMultiple window = new PruebaJButtonMultiple();
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
	public PruebaJButtonMultiple() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btn1 = new JButton("Rojo");
		btn1.setBounds(42, 64, 85, 21);
		panel.add(btn1);
		
		btn2 = new JButton("Verde");
		btn2.setBounds(176, 64, 85, 21);
		panel.add(btn2);
		
		btn3 = new JButton("Rosa");
		btn3.setBounds(310, 64, 85, 21);
		panel.add(btn3);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
	}
	
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			Color color = frame.getBackground();
			
			
			if(source.equals(btn1)) {
				color = Color.RED;
				
			}else if(source.equals(btn2)) {
				color = Color.GREEN;
			}else if(source.equals(btn3)) {
				color = Color.PINK;
			}
			
			panel.setBackground(color);
		
		}
	

}

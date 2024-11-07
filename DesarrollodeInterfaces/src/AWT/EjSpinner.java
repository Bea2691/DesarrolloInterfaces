package AWT;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EjSpinner {
	JFrame ventana;
	JSpinner spinner;
	JTextField tf;
	
	public EjSpinner() {
		ventana = new JFrame("Ventana Spinner");
		ventana.getContentPane().setLayout(new FlowLayout());
		
		tf = new JTextField(20);
		spinner= new JSpinner();
		spinner.setValue(30);
		
		
		ventana.getContentPane().add(spinner);
		ventana.getContentPane().add(tf);
		ventana.pack();
		
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		//Se asocia el spinner a ChangeListener
		
		spinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				//Valor del spinner sale en el texField
				tf.setText(spinner.getValue().toString());
				
			}
		});
	}

	public static void main(String[] args) {
		new EjSpinner();

	}

}

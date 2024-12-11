package SWING;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EjJSlider {

	
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Ejemplo JSlider");
		
		Container contenedor = ventana.getContentPane();
		
		JSlider slider = new JSlider(0,100); // se ponen los valores desde los que va a ir el slider de 0-100 en este caso
		slider.setMajorTickSpacing(20);//intervalos grandes
		slider.setMinorTickSpacing(5); //intervalos pequeños
		slider.setPaintLabels(true); //que se visualizen las etiquetas de los ticks
		slider.setPaintTicks(true);//que se visualicen los ticks
		slider.setToolTipText("Establecer valor");
		
		JSlider slider2 = new JSlider(0,100); // se ponen los valores desde los que va a ir el slider de 0-100 en este caso
		slider2.setMajorTickSpacing(20);//intervalos grandes
		slider2.setMinorTickSpacing(5); //intervalos pequeños
		slider2.setPaintLabels(true); //que se visualizen las etiquetas de los ticks
		slider2.setPaintTicks(true);//que se visualicen los ticks
		slider2.setToolTipText("Establecer valor");
		
		contenedor.add(slider, BorderLayout.NORTH);
		contenedor.add(slider2, BorderLayout.CENTER);
		
		ventana.pack();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		
		ChangeListener prueba;
		slider.addChangeListener(prueba= new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider sliderin = (JSlider) e.getSource();
				if(sliderin.getValueIsAdjusting()) {
					System.out.println("Valor: " + sliderin.getValue());
					sliderin.setToolTipText(String.valueOf(sliderin.getValue()));
					
				}
			}
		});
		
		slider2.addChangeListener(prueba);
		
		
		
		
	}
}


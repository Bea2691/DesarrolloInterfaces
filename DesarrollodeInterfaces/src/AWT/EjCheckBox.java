package AWT;

import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ItemEvent;

public class EjCheckBox {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Ejemplo JCheckBox");
		ventana.setSize(300,300);
		
		
		JLabel lb1 = new JLabel("Selecciona tu color favorito");
		JLabel lb2 = new JLabel("Etiqueta Seleccionada");
		JLabel lb3 = new JLabel("Etiqueta Deseleccionada");

		JCheckBox ch1 = new JCheckBox("Rojo");
		
		JCheckBox ch2 = new JCheckBox("Amarillo");
		JCheckBox ch3 = new JCheckBox("Verde");
		
		JPanel colores = new JPanel();
		
		colores.setLayout(new BoxLayout(colores, BoxLayout.Y_AXIS)); //Alineado todo, uno encima de otro
		ventana.setContentPane(colores);
		
		colores.add(lb1);
		colores.add(ch1);
		colores.add(ch2);
		colores.add(ch3);
		colores.add(lb2);
		colores.add(lb3);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Manera manual de que se cierre con la x
		ventana.setVisible(true);
		
		ItemListener escuchador; //Este es el listener de los checkboxes
		
		ch1.addItemListener(escuchador = new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//Asociamos el componente que ha producido el evento
				JCheckBox boton = (JCheckBox) e.getItemSelectable();
				//Asociamos el comando del evento
				String comando = boton.getActionCommand();
				
				
				switch(e.getStateChange()) {
				case ItemEvent.SELECTED:
					System.out.println("Seleccionado el color " + comando);
					lb2.setText("Seleccionado el color " + comando);
					break;
				case ItemEvent.DESELECTED:
					System.out.println("Deseleccionado " + comando);
					lb3.setText("Deseleccionado " + comando);
					break;
				
				}
			}
		});
		
		ch2.addItemListener(escuchador); 
		ch3.addItemListener(escuchador);
		
	}
	

}

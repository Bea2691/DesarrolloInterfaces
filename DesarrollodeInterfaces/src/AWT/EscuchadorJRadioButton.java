package AWT;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

//Esta CLASE SOLO CONTIENE EL LISTENER GENERAL PARA LOS RADIOBUTTONS

public class EscuchadorJRadioButton implements ItemListener{
	
	JLabel etiquetaSelec, etiquetaDeselec;
	
 


		public EscuchadorJRadioButton(JLabel etiquetaSelec, JLabel etiquetaDeselec) {
		super();
		this.etiquetaSelec = etiquetaSelec;
		this.etiquetaDeselec = etiquetaDeselec;
	}




		public void itemStateChanged(ItemEvent e) {
			//Asociamos el componente que ha producido el evento
			JRadioButton boton = (JRadioButton) e.getItemSelectable();
			//Asociamos el comando del evento
			String comando = boton.getActionCommand();
			
			
			switch(e.getStateChange()) {
			case ItemEvent.SELECTED:
				System.out.println("Seleccionado el color " + comando);
				etiquetaSelec.setText("Seleccionado el color " + comando);
				break;
			case ItemEvent.DESELECTED:
				System.out.println("Deseleccionado " + comando);
				etiquetaDeselec.setText("Deseleccionado " + comando);
				break;
			
			}
		}
	
}


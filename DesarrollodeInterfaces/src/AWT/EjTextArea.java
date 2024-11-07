package AWT;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.event.CaretEvent;

public class EjTextArea {

public static void main(String[] args) {
	
	JFrame ventana = new JFrame("Ejemplo TextArea");
	
	Container contenedor = ventana.getContentPane();
	
	JTextArea texto = new JTextArea(5,10); //5 filas 10 columnas
	
	JScrollPane scroll = new JScrollPane(texto);
	
	JLabel nif = new JLabel("Nif: ");
	contenedor.setLayout(new FlowLayout());
	
	contenedor.add(nif);
	contenedor.add(scroll);
	texto.setText("Empezamos");
	
	JLabel etiqueta = new JLabel();
	etiqueta.setText("Texto inicial Jlabel");
	ventana.getContentPane().add(etiqueta);
	
	ventana.setSize(352,278);
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ventana.setLocationRelativeTo(null);
	ventana.setVisible(true);
	
	//Esto es para saber en que posición estas en el textArea
	texto.addCaretListener(new CaretListener() {
		public void caretUpdate(CaretEvent e) {
			int posicionFinal= e.getDot();
			int posicionInicial= e.getMark();
			try {
				//Linea actual del cursor en el texto tomando como referencia la posición final
				int linea = texto.getLineOfOffset(posicionFinal);
				//Columna actual en la que esta el cursor tomando  referencia la posición
				int col = posicionFinal - texto.getLineStartOffset(linea);
				String info = "Linea :" + (linea+1) + " - Columna: " + (col +1);
				System.out.println("Informacion: " + info);
				etiqueta.setText(info);
				//System.out.println("getLineStarOffset: " + texto.getLineStartOffset(linea)+ "-- Posición Final: " + posicionFinal);
				
			} catch (BadLocationException e1) {
				
				e1.printStackTrace();
			}
		}
	});
	
}	
}

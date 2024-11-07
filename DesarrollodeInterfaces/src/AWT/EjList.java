package AWT;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.AbstractListModel;

public class EjList {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Ventana Lista");
		
		String[] datos = {"Enero","Febrero", "Marzo", "Abril","Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre","Diciembre"};
		ventana.getContentPane().setLayout(null);
		
		JList meses = new JList(datos);
		
		JScrollPane scroll = new JScrollPane(meses);
		scroll.setBounds(0, 0, 163, 186);
		
		meses.setVisibleRowCount(3); //Filas visibles
		meses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ventana.getContentPane().add(scroll);
						
		//ventana.pack();//Se acomoda la ventana al contenido
		ventana.setSize(454,347);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);

	}
}

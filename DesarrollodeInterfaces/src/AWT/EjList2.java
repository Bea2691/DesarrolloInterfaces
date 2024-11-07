package AWT;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class EjList2 {

	public static void main(String[] args) {
		//Ejemplo para añadir y eliminar elementos de una lista con un remove y un Thread.sleep()
		
		JFrame ventana = new JFrame("Ejemplo lista añadir y eliminar");
		JList meses = new JList();
		//Utilizamos la clase DefaultListModel, proporciona el método addElement() para añadir elementos a la lista
		DefaultListModel <String> modelo = new DefaultListModel<String>();
		modelo.addElement("Elemento 1");
		modelo.addElement("Elemento 2");
		modelo.addElement("Elemento 3");
		modelo.addElement("Elemento 4");
		modelo.addElement("Elemento 5");
		
		meses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		meses.setModel(modelo);
		
	
		
		
		JScrollPane scroll = new JScrollPane(meses);
		
		
		ventana.getContentPane().add(scroll);
		
		
		ventana.setSize(450,350);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelo.remove(2);
		
		
		

	}

}

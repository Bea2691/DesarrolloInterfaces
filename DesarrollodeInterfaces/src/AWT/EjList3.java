package AWT;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EjList3 {

	JFrame frame;
	JList<String> lista;
	JLabel etiqueta;
	
	
	public EjList3() {
		frame = new JFrame("JFrame con ListSelectionListener");
		
		//Modelo por defecto
		
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		modelo.addElement("Java");
		modelo.addElement("Python");
		modelo.addElement("Javascript");
		modelo.addElement("C++");
		
		lista = new JList<String>(modelo);
		lista.setBounds(10, 53, 200, 210);
		frame.getContentPane().add(lista);
		
		frame.setSize(300,300);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		etiqueta = new JLabel("Selecciona un lenguaje");
		etiqueta.setBounds(10,10,200,50);
		frame.getContentPane().add(etiqueta);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Añadir listener
		
		lista.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					String seleccionado = lista.getSelectedValue();
					etiqueta.setText("Lenguaje seleccionado: " + seleccionado);
					
				}
				
			}
		});
		
		
		
		}
	
	public static void main(String[] args) {
		new EjList3();

	}

}

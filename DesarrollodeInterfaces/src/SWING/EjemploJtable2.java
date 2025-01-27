package SWING;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EjemploJtable2 extends JPanel{

	private JScrollPane panelScroll;
	private String titColumna[];
	private String datoColumna[][];
	
	
	
	public EjemploJtable2() {
		setLayout(new BorderLayout());
		
		//Arrays columnas y titulos de columnas
		creaColumnas();
		creaDatos();
		
		//Para que no se puedan editar las celdas directamente
		JTable tabla = new JTable(datoColumna, titColumna){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		//Eliminar las lineas horizontales entre las celdas de la tabla
		tabla.setShowHorizontalLines(false);
		//Se pueden seleccionar las celdas de la tabla
		tabla.setRowSelectionAllowed(true);
		//Se pueden seleccionar las columnas de la tabla
		tabla.setColumnSelectionAllowed(true);
		
		//Combina las dos anteriores
		//tabla.setCellSelectionEnabled(true);
		
		//Cmabiamos el color de la letra de celda SELECCIONADA
		tabla.setSelectionForeground(Color.lightGray); //letra
		tabla.setSelectionBackground(Color.DARK_GRAY); //fondo
		tabla.setAutoCreateRowSorter(true);
		
		//Tooltip al posicionar sobre la tabla
		tabla.setToolTipText("Seleccionar");
		
		//Deshabilitar poder mover las columnas del encabezado de posicion
		tabla.getTableHeader().setReorderingAllowed(false);
		
		panelScroll = new JScrollPane(tabla);
		add(panelScroll, BorderLayout.NORTH);
		
	}
	private void creaDatos() {
		datoColumna = new String[100][8];
		for (int iY =0; iY <100; iY++) {
			for (int iX=0; iX<8;iX++) {
				datoColumna[iY][iX]="" + iX + "," + iY;
			}
		}
		
	}
	private void creaColumnas() {
		titColumna = new String[8];
		for(int i=0; i<8;i++) {
			titColumna[i]= "Col." + i;
		}
		
	}
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Ejemplo JTable 2");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().add(new EjemploJtable2(), BorderLayout.CENTER);
		ventana.setSize(500,300);
		ventana.setVisible(true);
		

	}

}

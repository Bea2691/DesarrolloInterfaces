package SWING;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class EjemploJTable extends JFrame implements ActionListener {
	private JTable tabla;
	private JScrollPane barras;
	private DefaultTableModel modelo;
	private JButton boton1, boton2;
	private String[] columnas = {"Indice", "Info"};
	
	public EjemploJTable() {
		//Inicializar elementos de la interfaz
		tabla = new JTable();
		barras= new JScrollPane(tabla);
		
		//Construir el modelo de la tabla por defecto(0 filas y 0 columnas)
		modelo = new DefaultTableModel();
		
		boton1 = new JButton("Imprimir registro");
		
		//Establecer el texto del comando del boton, se envia con ActionEvent
		boton1.setActionCommand("Imprime");
		boton2 = new JButton("Cambiar número Registros");
		boton2.setActionCommand("Cambia");
		
		modelo.setColumnIdentifiers(columnas);
		//Establecer modelo de la tabla
		tabla.setModel(modelo);
		
		//Para ordenar automaticamente los datos de la tabla al pulsar sobre la cabecera de la tabla
		tabla.setAutoCreateRowSorter(true);
		
		//Elegir el tip ode seleccion de los registros
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Se pueden seleccionar las celdas de la tabla
		tabla.setRowSelectionAllowed(true);
		
		//Agregar datos a la tabla
		this.agregarDatos();
		
		//Configurar la ventana principal
		this.prepararVentana();
		
		//Agregar elementos de la interfaz
		this.agregarElementos();
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		
	}	
	
	private void agregarElementos() {
		this.getContentPane().add(barras, BorderLayout.NORTH);
		this.getContentPane().add(boton1, BorderLayout.CENTER);
		this.getContentPane().add(boton2, BorderLayout.SOUTH);
	
		
	}

	private void prepararVentana() {
		this.setTitle("Datos de la tabla");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		
	}

	private void agregarDatos() {
		for (Integer i=0; i<100; i++) {
			String mensaje= i + " unidades";
			String [] datos = {i.toString(), mensaje};
			modelo.addRow(datos);
		}
		
	}

	public static void main(String[] args) {
		EjemploJTable tabla= new EjemploJTable();
		
		tabla.pack();
		tabla.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Obtener datos del registro seleccionado
		if(tabla.getSelectedRow() != -1 && e.getActionCommand() == "Imprime") {
			String codigo = (String) modelo.getValueAt(tabla.getSelectedRow(), 0);
			String info = (String) modelo.getValueAt(tabla.getSelectedRow(), 1);
			
			//Imprime por pantalla
			System.out.println("\n\nInformacion de la tabla");
			System.out.println("=======================");
			System.out.println("Columnas de la tabla: " + tabla.getColumnCount());
			System.out.println("Filas de la tabla: " + tabla.getRowCount());
			System.out.println("\nColumna seleccionada:" + tabla.getSelectedColumn());
			System.out.println("Fila seleccionada: " + tabla.getSelectedRow());
			System.out.println("\nIndice: " + codigo + " --- Informacion: " + info);
			
			//Para escribir la info real seleccionada una vez hay un cambio por ejemplo al ordenar los datos
			String codigo2 = (String) modelo.getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 0);
			String info2 = (String) modelo.getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 1);
			
			System.out.println("\nIndice: " + codigo2 + " --- Informacion: " + info2);
			
		} else if (e.getActionCommand() == "Cambia") modelo.setRowCount(120);
		else {System.out.println("seleccione un registro bobo");}
		
	}

}

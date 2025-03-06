package SWING;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.formdev.flatlaf.FlatDarculaLaf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;


public class SimulacroExamen extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JList<String> lista;
    private JLabel etiqueta; 
    private JSlider slider1, slider2;
    private JTextField txt;
    private JButton boton;
    private JPopupMenu popupMenu;
    private JMenuItem cortar, copiar, pegar;
    private JTabbedPane tabbedPane;

    public SimulacroExamen() {
        setTitle("Simulacro Examen");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(10, 10, 360, 280);
        add(tabbedPane);

        // Pestaña 1: Lista
        JPanel panelLista = new JPanel();
        panelLista.setLayout(null);

        etiqueta = new JLabel("Selecciona un lenguaje");
        etiqueta.setBounds(10, 10, 200, 30);
        panelLista.add(etiqueta);

        DefaultListModel<String> modelo = new DefaultListModel<>();
        modelo.addElement("Java");
        modelo.addElement("Python");
        modelo.addElement("Javascript");
        modelo.addElement("C++");

        lista = new JList<>(modelo);
        lista.setBounds(10, 50, 200, 100);
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String seleccionado = lista.getSelectedValue();
                    etiqueta.setText("Lenguaje seleccionado: " + seleccionado);
                }
            }
        });
        panelLista.add(lista);
        tabbedPane.addTab("Lista", panelLista);

        // Pestaña 2: Panel con GridBagLayout
        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridBagLayout());
        GridBagConstraints restricciones = new GridBagConstraints();

        // Añadir componentes al panel con GridBagLayout
        boton = new JButton("Boton");
        restricciones.weightx = 0.5;
        restricciones.weighty = 1;
        restricciones.fill = GridBagConstraints.BOTH;
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        panelGrid.add(boton, restricciones);

        boton = new JButton("Boton2");
        restricciones.weightx = 0.5;
        restricciones.fill = GridBagConstraints.HORIZONTAL;
        restricciones.gridx = 1;
        restricciones.gridy = 0;
        panelGrid.add(boton, restricciones);

        boton = new JButton("Boton3");
        restricciones.weightx = 0.5;
        restricciones.fill = GridBagConstraints.HORIZONTAL;
        restricciones.gridx = 2;
        restricciones.gridy = 0;
        panelGrid.add(boton, restricciones);

        boton = new JButton("Yo ocupo tres columnas");
        restricciones.weightx = 0.0;
        restricciones.fill = GridBagConstraints.HORIZONTAL;
        restricciones.gridx = 0;
        restricciones.gridy = 1;
        restricciones.gridwidth = 3; // Ocupa 3 columnas
        restricciones.ipady = 40;
        panelGrid.add(boton, restricciones);

        boton = new JButton("Empiezo en b2");
        restricciones.weighty = 1;
        restricciones.fill = GridBagConstraints.HORIZONTAL;
        restricciones.gridx = 1;
        restricciones.gridy = 2;
        restricciones.gridwidth = 2;
        restricciones.ipady = 0;
        restricciones.anchor = GridBagConstraints.PAGE_END;
        restricciones.insets = new Insets(10, 0, 0, 0);
        panelGrid.add(boton, restricciones);

        // Añadir el panel con GridBagLayout al tabbedPane
        tabbedPane.addTab("Grid", panelGrid);

        // Pestaña 3: Sliders
        JPanel panelSliders = new JPanel();
        panelSliders.setLayout(null);

        slider1 = new JSlider(0, 100);
        slider1.setBounds(10, 20, 330, 50);
        slider1.setMajorTickSpacing(20);
        slider1.setMinorTickSpacing(5);
        slider1.setPaintLabels(true);
        slider1.setPaintTicks(true);
        panelSliders.add(slider1);

        slider2 = new JSlider(0, 100);
        slider2.setBounds(10, 80, 330, 50);
        slider2.setMajorTickSpacing(20);
        slider2.setMinorTickSpacing(5);
        slider2.setPaintLabels(true);
        slider2.setPaintTicks(true);
        panelSliders.add(slider2);

        ChangeListener cambioSlider = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                if (slider.getValueIsAdjusting()) {
                    System.out.println("Valor: " + slider.getValue());
                    slider.setToolTipText(String.valueOf(slider.getValue()));
                }
            }
        };

        slider1.addChangeListener(cambioSlider);
        slider2.addChangeListener(cambioSlider);

        tabbedPane.addTab("Sliders", panelSliders);

        // Campo de texto y botón
        txt = new JTextField(30);
        txt.setBounds(10, 310, 200, 25);
        add(txt);

        boton = new JButton("Buscar archivo");
        boton.setBounds(220, 310, 150, 25);
        boton.addActionListener(this);
        add(boton);

        // JPopupMenu
        popupMenu = new JPopupMenu();
        cortar = new JMenuItem("Cortar");
        copiar = new JMenuItem("Copiar");
        pegar = new JMenuItem("Pegar");

        cortar.addActionListener(this);
        copiar.addActionListener(this);
        pegar.addActionListener(this);

        popupMenu.add(cortar);
        popupMenu.add(copiar);
        popupMenu.add(pegar);

        //PopUpmenu, añadido al tabbedpane, habría que eliminar 'tabbedPane' del listener para que se añadiera al frame, o poner ambos para que responda con ambos
        tabbedPane.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(SimulacroExamen.this, e.getX(), e.getY());
                }
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) {
            JFileChooser filechooser = new JFileChooser();
            filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Imagenes solo", "jpg", "png", "gif");
            filechooser.setFileFilter(imgFilter);

            int resultado = filechooser.showOpenDialog(this);
            if (resultado != JFileChooser.CANCEL_OPTION) {
                File fileName = filechooser.getSelectedFile();
                if (fileName == null || fileName.getName().equalsIgnoreCase("")) {
                    txt.setText("...");
                } else {
                    txt.setText(fileName.getAbsolutePath());
                }
            }
        } else if (e.getSource() == cortar) {
            txt.setText("Cortar");
        } else if (e.getSource() == copiar) {
            txt.setText("Copiar");
        } else if (e.getSource() == pegar) {
            txt.setText("Pegar");
        }
    }

    public static void main(String[] args) {
    	try {
			UIManager.setLookAndFeel(new FlatDarculaLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
    	new SimulacroExamen();
    	
		//LO QUE ENTRA EN EL EXAMEN:
		
		
		//JLIST, listener-> addListSelectionListener, valueChanged, e.getValueIsAdjusting, cambio de setText en label
		
		//JSLIDER, changeListener, stateChanged, getValueIsAdjusting, en tooltiptext
		
		//JTABLE, en EJEMPLOJTABLE, esta lo de al seleccionar una celda y dar imprimir te dice los datos por consola:
		/*System.out.println("\n\nInformacion de la tabla");
		System.out.println("Columnas de la tabla: " + tabla.getColumnCount());
		System.out.println("Filas de la tabla: " + tabla.getRowCount());
		System.out.println("\nColumna seleccionada:" + tabla.getSelectedColumn());
		System.out.println("Fila seleccionada: " + tabla.getSelectedRow());
		System.out.println("\nIndice: " + codigo + " --- Informacion: " + info);
		y para mostrar la info real si ordenas los datos de la tabla pulsando el encabezado.
		
		JTABLE, en EJEMPLOJATABLE2, esta la parte estetica, eliminar lineas horizontales, que se pueda seleccionar o no, cambiar el color del fondo y de la letra
		
		
		
		
		JMENU, en EJEMPLOJMENU, es lo del menu superior (incluye cambiar el tamaño de la ventana y el fondo, y la opcion salir con el setMnemonic de alt+letra para moverse)
		
		
		JFILECHOOSE, en EJFILECHOOSER basura, al lanzar solo se abre la ventana para seleccionar archivo.
					 en EJFILECHOOSER2, hay un textfield y un boton para buscar un archivo y carga la direccion en el textfield 
					 
		JTOOLBAR, es como el JMenu pero para poner iconos, checkbox y cosas de acceso rapido, en EJEMPLOJTOOLBAR, es pura basura
		
		JPOPUPMENU, es el menu flotante del click derecho, esta en este simulacro
		
		DYNAMICPANEL, es una mierda de barra lateral que aparece y desaparece al pulsar un boton
		
		GROUPLAYOUT, es un layout, esta en EJPRUEBAGROUPPANE, no creo que entre
		
		JTABBEDPANE, son pestañas en el frame,esta aqui de ejemplo y en EJERCICIOTABBEDPANE, EJJTABBEDPANE Y EL EJERCIO LARGO.
		
		JINTERNALFRAME,son las miniVentanas que se pueden minimizar, en EJEMPLO JINTERNALFRAME hay dos, con un boton en el frame y otro boton en la segunda internal con listener en textfield
		
		El GRIDBAGLAYOUT, esta en la pestaña 2 de este ejemplo y en EJGRIDBAGLAYOUT
		*/
		
		

	}

}

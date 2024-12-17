package SWING;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class EjercicioJListJFileChooserJSliderJTabbed implements ActionListener {
    private DefaultListModel<String> modeloLista;
    private JFrame ventana;
    private int sumaAcumulada = 0;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        new EjercicioJListJFileChooserJSliderJTabbed().crearVentana();
    }

    private void crearVentana() {
        ventana = new JFrame("Ejemplo JTabbedPane");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);

        JTabbedPane pestañas = new JTabbedPane();

        JPanel panel1 = new JPanel(new BorderLayout());
        JButton botonAñadir = new JButton("Añadir");
        
        modeloLista = new DefaultListModel<>();
        JList<String> listaArchivos = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(listaArchivos);

        botonAñadir.addActionListener(this);

        panel1.add(botonAñadir, BorderLayout.NORTH);
        panel1.add(scrollLista, BorderLayout.CENTER);

        JPanel panel2 = new JPanel(new BorderLayout());
        
        JSlider slider = new JSlider(0, 100, 0);
        slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5); 
		slider.setPaintLabels(true); 
		slider.setPaintTicks(true);
		slider.setToolTipText("Establecer valor");
		
        JButton botonSumar = new JButton("Sumar");
        JTextField campoResultado = new JTextField("0", 10);
        campoResultado.setEditable(false);

        botonSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sumaAcumulada += slider.getValue();
                campoResultado.setText(String.valueOf(sumaAcumulada));
            }
        });

        JPanel controlesPanel2 = new JPanel();
        controlesPanel2.add(new JLabel("Selecciona un valor:"));
        controlesPanel2.add(slider);
        controlesPanel2.add(botonSumar);
        controlesPanel2.add(campoResultado);

        panel2.add(controlesPanel2, BorderLayout.CENTER);

        pestañas.add("Pestaña 1", panel1);
        pestañas.add("Pestaña 2", panel2);

        ventana.getContentPane().add(pestañas);

        ventana.setVisible(true);
        
        
        ChangeListener prueba;
		slider.addChangeListener(prueba= new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider sliderin = (JSlider) e.getSource();
				if(sliderin.getValueIsAdjusting()) {
					sliderin.setToolTipText(String.valueOf(sliderin.getValue()));
					
				}
			}
		});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser selectorFichero = new JFileChooser();
        int resultado = selectorFichero.showOpenDialog(ventana);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File ficheroSeleccionado = selectorFichero.getSelectedFile();
            modeloLista.addElement(ficheroSeleccionado.getAbsolutePath());
        }
    }
}

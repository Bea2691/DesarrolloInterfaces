package SWING;

import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;

import java.awt.*;
import java.awt.event.*;

public class EjercicioJTabbedPane {

    public static void main(String[] args) {
    	try {
			UIManager.setLookAndFeel(new FlatDarculaLaf());
		} catch (UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
    	
        JFrame frame = new JFrame("Ejercicio JTabbedPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel pestaña1 = new JPanel();
        pestaña1.setLayout(new FlowLayout());
        JLabel label1 = new JLabel("Soy un Label");
        pestaña1.add(label1);
        
        JButton boton1p1 = new JButton("Mostrar mensaje");
        boton1p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText("¡Hola desde Pestaña 1!");
            }
        });
        JButton boton2p1 = new JButton("Ingresar valor");
        boton2p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputValue = JOptionPane.showInputDialog(pestaña1, "Introduce un valor:");
                if (inputValue != null && !inputValue.isEmpty()) {
                    label1.setText("Valor ingresado: " + inputValue);
                } else {
                    label1.setText("No se ingresó ningún valor.");
                }
            }
        });
        pestaña1.add(boton1p1);
        pestaña1.add(boton2p1);

        JPanel pestaña2 = new JPanel();
        pestaña2.setLayout(new FlowLayout());
        JLabel label2 = new JLabel("Soy un Label");
        pestaña2.add(label2);
        
        
        JButton boton1p2 = new JButton("Mostrar mensaje");
        boton1p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label2.setText("¡Hola desde Pestaña 2!");
            }
        });
        JButton boton2p2 = new JButton("Ingresar valor");
        boton2p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputValue = JOptionPane.showInputDialog(pestaña2, "Introduce un valor:");
                if (inputValue != null && !inputValue.isEmpty()) {
                    label2.setText("Valor ingresado: " + inputValue);
                } else {
                    label2.setText("No se ingresó ningún valor.");
                }
            }
        });
        
        pestaña2.add(boton1p2);
        pestaña2.add(boton2p2);

        JPanel pestaña3 = new JPanel();
        pestaña3.setLayout(new FlowLayout());
        JLabel label3 = new JLabel("Soy un Label");
        pestaña3.add(label3);
        
        JButton boton1p3 = new JButton("Mostrar mensaje");
        boton1p3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label3.setText("¡Hola desde Pestaña 3!");
            }
        });
        JButton boton2p3 = new JButton("Ingresar valor");
        boton2p3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputValue = JOptionPane.showInputDialog(pestaña3, "Introduce un valor:");
                if (inputValue != null && !inputValue.isEmpty()) {
                    label3.setText("Valor ingresado: " + inputValue);
                } else {
                    label3.setText("No se ingresó ningún valor.");
                }
            }
        });
        pestaña3.add(boton1p3);
        pestaña3.add(boton2p3);

        tabbedPane.addTab("Pestaña 1", pestaña1);
        tabbedPane.addTab("Pestaña 2", pestaña2);
        tabbedPane.addTab("Pestaña 3", pestaña3);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}

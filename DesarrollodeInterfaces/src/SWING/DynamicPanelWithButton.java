package SWING;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;

public class DynamicPanelWithButton {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("Dynamic Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.getContentPane().setLayout(new BorderLayout());

        // Crear el panel superior con un botón
        JPanel topPanel = new JPanel();
        JButton toggleButton = new JButton("Mostrar/Ocultar Panel");

        // Crear el panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        // Crear el panel dinámico (izquierdo)
        JPanel dynamicPanel = new JPanel();
        dynamicPanel.setBackground(SystemColor.windowBorder);
        dynamicPanel.setBounds(0, 0, 87, 246);
        dynamicPanel.setVisible(false); // Oculto por defecto
        mainPanel.add(dynamicPanel);

        // Agregar un ActionListener al botón
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Alternar la visibilidad del panel dinámico
                dynamicPanel.setVisible(!dynamicPanel.isVisible());
            }
        });

        // Agregar los paneles al marco
        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        GroupLayout gl_topPanel = new GroupLayout(topPanel);
        gl_topPanel.setHorizontalGroup(
        	gl_topPanel.createParallelGroup(Alignment.LEADING)
        		.addComponent(toggleButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        );
        gl_topPanel.setVerticalGroup(
        	gl_topPanel.createParallelGroup(Alignment.LEADING)
        		.addComponent(toggleButton)
        );
        topPanel.setLayout(gl_topPanel);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

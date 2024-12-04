package AWT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExamenBeatriz2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ExamenBeatriz2().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Examen GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Componentes
        JLabel lblElegido = new JLabel("Nombre Elegido:");
        JTextField txtElegido = new JTextField(20);
        txtElegido.setEditable(false);

        JLabel lblEscribeNombre = new JLabel("Escribe el nombre de una persona sin dígitos:");
        JTextField txtEscribeNombre = new JTextField(20);

        JLabel lblSoloDigitos = new JLabel("Solo se pueden escribir dígitos:");
        JTextField txtSoloDigitos = new JTextField(20);

        JButton btnPulsa = new JButton("Púlsame");
        JButton btnAnadir = new JButton("Añadir");
        JLabel lblSobre = new JLabel("Estás sobre la:");

        // Lista de nombres
        DefaultListModel<String> listaModel = new DefaultListModel<>();
        JList<String> listaNombres = new JList<>(listaModel);
        JScrollPane scrollLista = new JScrollPane(listaNombres);

        // Funcionalidades
        btnPulsa.addActionListener(e -> JOptionPane.showMessageDialog(frame, "¡Has pulsado el botón!"));

        listaNombres.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String seleccionado = listaNombres.getSelectedValue();
                if (seleccionado != null) {
                    txtElegido.setText(seleccionado);
                }
            }
        });

        btnAnadir.addActionListener(e -> {
            String nombre = txtEscribeNombre.getText();
            if (nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) { // Verifica si el nombre no tiene dígitos
                listaModel.addElement(nombre);
                JOptionPane.showMessageDialog(frame, "Nombre añadido: " + nombre);
                txtEscribeNombre.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "El nombre contiene caracteres inválidos.");
            }
        });

        txtEscribeNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isDigit(e.getKeyChar())) {
                    e.consume(); // Evita que se escriban dígitos
                }
            }
        });

        txtSoloDigitos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume(); // Evita caracteres no numéricos
                }
            }
        });

        txtSoloDigitos.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                txtSoloDigitos.setText(""); // Limpia el campo al perder el foco
            }
        });

        // RadioButtons
        JPanel panelRadio = new JPanel();
        ButtonGroup grupoRadios = new ButtonGroup();
        String[] opciones = {"Opción 1", "Opción 2", "Opción 3"};

        for (String opcion : opciones) {
            JRadioButton radio = new JRadioButton(opcion);
            grupoRadios.add(radio);
            panelRadio.add(radio);

            radio.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    lblSobre.setText("Estás sobre la: " + opcion);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    lblSobre.setText("Estás sobre la:");
                }
            });
        }

       
        frame.add(lblEscribeNombre);
        frame.add(txtEscribeNombre);
        frame.add(lblSoloDigitos);
        frame.add(txtSoloDigitos);
        frame.add(btnPulsa);
        frame.add(scrollLista);
        frame.add(lblElegido);
        frame.add(txtElegido);
        frame.add(btnAnadir);
        frame.add(panelRadio);
        frame.add(lblSobre);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}


package SWING;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ExamenBeatrizInterfaces extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField campotexto;
    private JTextArea textArea;
    private JButton btnAñadir, btnLimpiar, btnColor, btnSalir;
    private boolean colorOriginal = true;
    private Color color1, color2;
    private final String textoporDefectocampo = "Campo Texto";
    private final String textoporDefectoArea = "Area Texto";

    public ExamenBeatrizInterfaces() {
        setTitle("Examen Beatriz Interfaces. Hola.");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        

        campotexto = new JTextField(20); //Texfield campo text
        campotexto.setFocusable(true);
        campotexto.setText(textoporDefectocampo);
      //  campotexto.setForeground(Color.GRAY);
        textArea = new JTextArea(10, 30); //TextArea
        textArea.setEditable(false);
        textArea.setText(textoporDefectoArea);

        color1 = Color.WHITE; //Colores del textArea
        color2 = Color.PINK;
        textArea.setBackground(color1);

        btnAñadir = new JButton("Añadir");
        btnLimpiar = new JButton("Limpiar"); //botones
        btnColor = new JButton("Color");
        btnSalir = new JButton("Salir");
        btnSalir.setMnemonic('S'); //Boton con Mnemonic, porque me apetecía

        btnAñadir.addActionListener(this);
        btnLimpiar.addActionListener(this);
        btnColor.addActionListener(this);
        btnSalir.addActionListener(this);

        campotexto.addKeyListener(new java.awt.event.KeyAdapter() { //listener para que detecte que escribe
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnAñadir.setEnabled(!campotexto.getText().trim().isEmpty());
            }
        });

        campotexto.addFocusListener(new FocusListener() { //aqui es para que elimine el txto por defecto cuando se vaya a escribir
            @Override
            public void focusGained(FocusEvent e) {
                if (campotexto.getText().equals(textoporDefectocampo)) {
                    campotexto.setText("");
               
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (campotexto.getText().isEmpty()) {
                    campotexto.setText(textoporDefectocampo);
          
                }
            }
        });

        
        //constrains del gridbag, esta dividida en 3*3
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(new JScrollPane(textArea), gbc); //el textArea ocupa 3 campos en f0 c0

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(btnLimpiar, gbc); //El btnLImpiar ocupa 1 en fila 0 columna 3

        gbc.gridx = 3;
        gbc.gridy = 2;
        add(btnColor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0;
        add(campotexto, gbc); //El campo de texto esta en la fila 3 y ocupa dos columnas

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(btnAñadir, gbc); //El boton añadir esta en la fila 3 columa 2

        gbc.gridx = 3;
        gbc.gridy = 3;
        add(btnSalir, gbc);  //y el btnSalir esta en la fila 3 columna 3

        campotexto.grabFocus();
        btnAñadir.setEnabled(false);
    }

    @Override

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnAñadir) {
        if (textArea.getText().equals(textoporDefectoArea)) { 
            textArea.setText("");   //Al pulsar añadir, se elimina el texto del area y con append se añade con salto de linea \n
        }
        textArea.append(campotexto.getText() + "\n");
        campotexto.setText("");
        campotexto.grabFocus(); //Centramos el focus despues de pulsar
        btnAñadir.setEnabled(false);
    } else if (e.getSource() == btnLimpiar) {
        campotexto.setText(textoporDefectocampo); //Con el btnLimpiar se vuelve a poner el txtoPor defecto y se elimna lo demas
        textArea.setText(textoporDefectoArea);
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //focus vuelve al campo de texto, esto hace que desaparezca el txto por defecto si lo descomento,
        //en el examen se pide focus en campo de texto y al mismo tiempo que haya un setText("Campo Texto"), es incompatible
        campotexto.grabFocus(); 
        
        btnAñadir.setEnabled(false);
    } else if (e.getSource() == btnColor) { //Para el cambio de color, si esta el original cambia al 2 y si esta el 2, al 1
        if (colorOriginal) {
            textArea.setBackground(color2);
        } else {
            textArea.setBackground(color1);
        }
        colorOriginal = !colorOriginal;
        campotexto.grabFocus();
    } else if (e.getSource() == btnSalir) { //Cierra el programa
        System.exit(0);
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ExamenBeatrizInterfaces().setVisible(true);
        });
    }
}

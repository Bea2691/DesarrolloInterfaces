
package AWT;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ExamenBeatrizRInterfaces extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfNombreElegido;
    private JTextField tfNombreSinDigitos;
    private JTextField tfSoloDigitos;

   
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ExamenBeatrizRInterfaces frame = new ExamenBeatrizRInterfaces();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

   
    public ExamenBeatrizRInterfaces() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Se cierra al click en 'X'
        setBounds(100, 100, 885, 580);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Pulsa el boton");
        lblNewLabel.setBounds(36, 47, 105, 18);
        contentPane.add(lblNewLabel);

        JButton btnPulsame = new JButton("Pulsame");
        btnPulsame.setBounds(36, 76, 93, 24);
        contentPane.add(btnPulsame);

        JLabel lblEligeUnaOpcion = new JLabel("Elige una opcion");
        lblEligeUnaOpcion.setBounds(222, 47, 105, 18);
        contentPane.add(lblEligeUnaOpcion);

        JLabel lblNewLabel_1 = new JLabel("Escribe el nombre de una persona sin digitos");
        lblNewLabel_1.setBounds(425, 47, 330, 30);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Nombre elegido");
        lblNewLabel_2.setBounds(222, 184, 181, 18);
        contentPane.add(lblNewLabel_2);

        tfNombreElegido = new JTextField();
        tfNombreElegido.setBounds(223, 229, 104, 22);
        contentPane.add(tfNombreElegido);
        tfNombreElegido.setColumns(10);

        tfNombreSinDigitos = new JTextField();
        tfNombreSinDigitos.setBounds(425, 89, 104, 22);
        contentPane.add(tfNombreSinDigitos);
        tfNombreSinDigitos.setColumns(10);

        JButton btnAñadir = new JButton("Añadir");
        btnAñadir.setBounds(425, 162, 70, 24);
        contentPane.add(btnAñadir);

        JLabel lblNewLabel_3 = new JLabel("Solo se pueden escribir digitos");
        lblNewLabel_3.setBounds(425, 257, 340, 30);
        contentPane.add(lblNewLabel_3);

        tfSoloDigitos = new JTextField();
        tfSoloDigitos.setBounds(425, 319, 104, 22);
        contentPane.add(tfSoloDigitos);
        tfSoloDigitos.setColumns(10);
        
        //RadioButtons, como no pedia Selected/Deselected sino pasar por encima con eventos Mouse no los he metido en un Group.

        JRadioButton rb1 = new JRadioButton("Opcion 1");
        rb1.setBounds(34, 355, 122, 26);
        contentPane.add(rb1);

        JRadioButton rb2 = new JRadioButton("Opcion 2");
        rb2.setBounds(34, 397, 122, 26);
        contentPane.add(rb2);

        JRadioButton rb3 = new JRadioButton("Opcion 3");
        rb3.setBounds(36, 437, 122, 26);
        contentPane.add(rb3);

        JLabel lblDondeEstas = new JLabel("Estas sobre: ");
        lblDondeEstas.setBounds(159, 401, 244, 18);
        contentPane.add(lblDondeEstas);
        
        
        
        //Lista de elementos

        DefaultListModel<String> modelo = new DefaultListModel<>();
        modelo.addElement("Beatriz");
        modelo.addElement("Lorena");
        modelo.addElement("Carlos");
       

        JList<String> list = new JList<>(modelo);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(222, 76, 104, 100); 
        contentPane.add(scrollPane);

       
      
        //Listeners
        
        
        //Al pulsar el boton se muestra un mensaje 
        
        btnPulsame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Pulsado el boton pulsame", "Uhoho me has pulsado",JOptionPane.INFORMATION_MESSAGE);
            }
        });
		
        //Cuando se selecciona un elemento de la lista con un setText aparece en el texfield tfNombreElegido
        
		list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedName = list.getSelectedValue();
                    tfNombreElegido.setText(selectedName);
                }
            }
        });
		
		
		//Aqui se controla que solo acepte caracteres que no sean digitos, si es digito se consume
		tfNombreSinDigitos.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (Character.isDigit(c)) {
		            e.consume();
		        }
		    }
		});
		
		
		//Lo contrario, !, si es diferente a un digito se consume
		tfSoloDigitos.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isDigit(c)) {
		            e.consume(); 
		        }
		    }
		});

		
		//Coge en texto del nombre que se ha escrito y se pasa al MessageDialog, si esta vacio en el else sale el otro mensaje
		btnAñadir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String nombre = tfNombreSinDigitos.getText();
		        if (!nombre.isEmpty()) {
		            modelo.addElement(nombre);
		            JOptionPane.showMessageDialog(null, "Nombre Añadido: " + nombre, "Buena elección de nombre", JOptionPane.INFORMATION_MESSAGE);
		            tfNombreSinDigitos.setText("");
		        } else {
		            JOptionPane.showMessageDialog(null, "No hay ningun nombre", "Vacio, muy vacio", JOptionPane.INFORMATION_MESSAGE);
		        }
		    }
		});
		
		
		//Si pierde el foco se limpie el textfield ""
		tfSoloDigitos.addFocusListener(new FocusAdapter() {
		     public void focusLost(FocusEvent e) {
		        tfSoloDigitos.setText("");
		    }
		});
		
	
             
		//Detecta los eventos del mouse al Entrar (Entered) en un Radiobutton con source coge su texto y lo añade con setText al label
		//Al salir con (Exited) simplemente se muestra el texto "Estas sobre:"
		MouseAdapter mouseAdapter = new MouseAdapter() {
		    
		    public void mouseEntered(MouseEvent e) {
		        JRadioButton source = (JRadioButton) e.getSource();
		        lblDondeEstas.setText("Estas sobre: " + source.getText());
		    }

		    
		    public void mouseExited(MouseEvent e) {
		        lblDondeEstas.setText("Estas sobre: ");
		    }
		};

		rb1.addMouseListener(mouseAdapter);
		rb2.addMouseListener(mouseAdapter);
		rb3.addMouseListener(mouseAdapter);
    }
}


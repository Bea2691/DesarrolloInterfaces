package AWT;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioPanelReflejo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    // Parte superior
    private JRadioButton rb1, rb2, rb3;
    private JCheckBox cb4, cb5, cb6;
    private JTextField textField;
    private JComboBox<String> comboBox;
    private JSpinner spinner;

    // Parte inferior
    private JRadioButton rb1Mirror, rb2Mirror, rb3Mirror;
    private JCheckBox cb4Mirror, cb5Mirror, cb6Mirror;
    private JTextField textFieldMirror;
    private JComboBox<String> comboBoxMirror;
    private JSpinner spinnerMirror;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    	try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EjercicioPanelReflejo frame = new EjercicioPanelReflejo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EjercicioPanelReflejo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridLayout(2, 1)); //Dos paneles
        setContentPane(contentPane);

        // Panel superior
        JPanel originalPanel = new JPanel(new GridLayout(4, 3));
        originalPanel.setBorder(BorderFactory.createTitledBorder("Original"));
        
        rb1 = new JRadioButton("Opción 1");
        rb2 = new JRadioButton("Opción 2");
        rb3 = new JRadioButton("Opción 3");
        
        cb4 = new JCheckBox("Opción 4");
        cb5 = new JCheckBox("Opción 5");
        cb6 = new JCheckBox("Opción 6");

        textField = new JTextField(10);
        comboBox = new JComboBox<>(new String[]{"Item 1", "Item 2", "Item 3"});
        spinner = new JSpinner(new SpinnerNumberModel(20, 0, 100, 1));
        
        //Añadimos los botones al grupo
        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        group.add(rb3);

        //Añadimos al panel Original los componentes
        originalPanel.add(rb1);
        originalPanel.add(cb4);
        originalPanel.add(textField);
        originalPanel.add(rb2);
        originalPanel.add(cb5);
        originalPanel.add(comboBox);
        originalPanel.add(rb3);
        originalPanel.add(cb6);
        originalPanel.add(spinner);

        // Panel inferior (Espejo)
        JPanel mirrorPanel = new JPanel(new GridLayout(4, 3));
        mirrorPanel.setBorder(BorderFactory.createTitledBorder("Espejo"));
        
        rb1Mirror = new JRadioButton("Opción 1");
        rb2Mirror = new JRadioButton("Opción 2");
        rb3Mirror = new JRadioButton("Opción 3");
        
        cb4Mirror = new JCheckBox("Opción 4");
        cb5Mirror = new JCheckBox("Opción 5");
        cb6Mirror = new JCheckBox("Opción 6");

        textFieldMirror = new JTextField(10);
        comboBoxMirror = new JComboBox<>(new String[]{"Item 1", "Item 2", "Item 3"});
        spinnerMirror = new JSpinner(new SpinnerNumberModel(20, 0, 100, 1));

        //Añadimos al grupo los radiobutton espejos
        ButtonGroup mirrorGroup = new ButtonGroup();
        mirrorGroup.add(rb1Mirror);
        mirrorGroup.add(rb2Mirror);
        mirrorGroup.add(rb3Mirror);

        //Fijamos como desactivados
        rb1Mirror.setEnabled(false);
        rb2Mirror.setEnabled(false);
        rb3Mirror.setEnabled(false);
        cb4Mirror.setEnabled(false);
        cb5Mirror.setEnabled(false);
        cb6Mirror.setEnabled(false);
        textFieldMirror.setEnabled(false);
        comboBoxMirror.setEnabled(false);
        spinnerMirror.setEnabled(false);

        //Añadimos componentes al panel espejo
        mirrorPanel.add(rb1Mirror);
        mirrorPanel.add(cb4Mirror);
        mirrorPanel.add(textFieldMirror);
        mirrorPanel.add(rb2Mirror);
        mirrorPanel.add(cb5Mirror);
        mirrorPanel.add(comboBoxMirror);
        mirrorPanel.add(rb3Mirror);
        mirrorPanel.add(cb6Mirror);
        mirrorPanel.add(spinnerMirror);

        //Añadimos al panel principal los otros dos
        contentPane.add(originalPanel);
        contentPane.add(mirrorPanel);

        
        rb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rb1Mirror.setSelected(rb1.isSelected());
                if (rb1.isSelected()) {
                    rb2Mirror.setSelected(false);
                    rb3Mirror.setSelected(false);
                }
            }
        });

        rb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rb2Mirror.setSelected(rb2.isSelected());
                if (rb2.isSelected()) {
                    rb1Mirror.setSelected(false);
                    rb3Mirror.setSelected(false);
                }
            }
        });

        rb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rb3Mirror.setSelected(rb3.isSelected());
                if (rb3.isSelected()) {
                    rb1Mirror.setSelected(false);
                    rb2Mirror.setSelected(false);
                }
            }
        });

        cb4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cb4Mirror.setSelected(cb4.isSelected());
            }
        });

        cb5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cb5Mirror.setSelected(cb5.isSelected());
            }
        });

        cb6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cb6Mirror.setSelected(cb6.isSelected());
            }
        });

        //Listener del Texfield
        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                textFieldMirror.setText(textField.getText());
            }
            public void removeUpdate(DocumentEvent e) {
                textFieldMirror.setText(textField.getText());
            }
            public void changedUpdate(DocumentEvent e) {
                textFieldMirror.setText(textField.getText());
            }
        });
        
        //Listener del comboBox
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBoxMirror.setSelectedItem(comboBox.getSelectedItem());
            }
        });
        
        //Listener del spinner
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                spinnerMirror.setValue(spinner.getValue());
            }
        });
    }
}


package AWT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Simulacro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfadios;
	private JTextField tfmouse;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simulacro frame = new Simulacro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Simulacro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bhola = new JButton("Hola");
		bhola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bhola.setBounds(67, 225, 76, 24);
		contentPane.add(bhola);
		
		
		JRadioButton rbrojo = new JRadioButton("Rojo");
		rbrojo.setBounds(67, 74, 122, 26);
		contentPane.add(rbrojo);
		
		JRadioButton rbverde = new JRadioButton("Verde");
		rbverde.setBounds(67, 116, 122, 26);
		contentPane.add(rbverde);
		
		JRadioButton rbazul = new JRadioButton("Azul");
		rbazul.setBounds(67, 165, 122, 26);
		contentPane.add(rbazul);
		

		ButtonGroup rbg = new ButtonGroup();
		rbg.add(rbverde);
		rbg.add(rbrojo);
		rbg.add(rbazul);
		
		tfadios = new JTextField();
		tfadios.setBounds(180, 226, 104, 22);
		contentPane.add(tfadios);
		tfadios.setColumns(10);
		
		tfmouse = new JTextField();
		tfmouse.setBounds(180, 295, 207, 24);
		contentPane.add(tfmouse);
		tfmouse.setColumns(10);
		
		
		bhola.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (rbrojo.isSelected()) {
		            tfadios.setText(rbrojo.getText());
		        } else if (rbverde.isSelected()) {
		            tfadios.setText(rbverde.getText());
		        } else if (rbazul.isSelected()) {
		            tfadios.setText(rbazul.getText());
		        }
		    }
		});
		addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	tfmouse.setText("Mouse entered the window");
		        System.out.println("Mouse entered the window");
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	tfmouse.setText("Mouse exited the window");
		        System.out.println("Mouse exited the window");
		    }
		});
	}
	
}
/* 
 *Eventos dados 
ActionPerformed para JButton, esto es modo navazo
ActionEvent para JButton
ActionListener para JButton
MouseAdapter-Mouse Clicked
MouseListener 
MouseMotionListener
WindowListener para JFrame
ItemListener para Checkbox y RadioButton
ItemEvent para Checkbox y RadioButton
CaretListener para JTextField y JTextArea
ChangeListener para Spinner
ListSelectionListener para JList
SelectionListener para JComboBox
showMessageDialog*/

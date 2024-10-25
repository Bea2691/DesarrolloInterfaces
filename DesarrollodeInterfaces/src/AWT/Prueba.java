package AWT;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;

public class Prueba extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba frame = new Prueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Prueba() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		misEventos me = new misEventos();
		btn1 = new JButton("New button");
		btn1.addMouseListener(me);
		btn1.setName("btn1");
		btn1.setBounds(70, 110, 85, 21);
		contentPane.add(btn1);
		
		btn2 = new JButton("Cancelar");
		btn2.addMouseListener(me);
		btn2.setName("btn22");
		btn2.setBounds(231, 110, 85, 21);
		contentPane.add(btn2);
	}



}
class misEventos extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton source = (JButton) e.getSource(); //con el source
		if(e.getComponent().getName().equals("btn1")) { //de la manera primera del name del objeto
			System.out.println("Boton 1 pulsado");
			System.out.println(e.getButton());
		}
		//if(source.getText().equals("Cancelar")) { //con el source
	//		System.out.println("Boton 2 pulsado");
		//}
		if(source.getName().equals("btn22")){ //con el JButton source pero por el Name del boton no es texto
			System.out.println("Hola");
		}
	}
	
}
package AWT;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventosAWTRaton extends Frame implements MouseListener, MouseMotionListener, WindowListener{
	
	static TextField tf;
	
	public EventosAWTRaton(String titulo) {
		super(titulo);
		tf = new TextField(60);
		
		//Se asocian los eventos del ratón y window de la clase EventosAWTRaon, con sus manejadores MouseListener, ect (los implementados)
		
		addMouseListener(this);
		addWindowListener(this);
		addMouseMotionListener(this);
		
	}

	public static void main(String[] args) {
		
		EventosAWTRaton ear = new EventosAWTRaton("Eventos Ratón AWT");
		ear.add(tf, BorderLayout.SOUTH);
		ear.setSize(300,300);
		ear.setVisible(true);
		
		

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// Cuando se le da la cerrar ventana
		setVisible(false);
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// Cuando se arrastra algo
		String msg = "Raton arrastado a la posicion x: " + e.getX() +" -y: "+ e.getY();
		tf.setText(msg);
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// Movimiento del raton
		//String msg = "Raton arrastado a la posicion x: " + e.getX() +" -y: "+ e.getY();
		//tf.setText(msg);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String msg = "Ha hecho click";
		tf.setText(msg);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Pulsado el click
		String msg = "Esta pulsando";
		tf.setText(msg);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		String msg = "El raton soltado";
		tf.setText(msg);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		String msg = "El raton ha entrado en la ventana";
		tf.setText(msg);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		String msg = "El raton ha salido en la ventana";
		tf.setText(msg);
		
	}

}

package AWT;

import java.awt.Frame;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdaptadorAWT {

	public static void main(String[] args) {
		
		InterUsu crearGUI= new InterUsu();
		
	}

}

class InterUsu{
	public InterUsu() {
		Frame miFrame = new Frame();
		
		miFrame.setSize(300,300);
		miFrame.setTitle("Eventos con Adapter");
		miFrame.setName("Frame");
		miFrame.setVisible(true);
		
		//Crear componente Window
		Window miVentana = new Window(miFrame);
		miVentana.setSize(100,100);
		miVentana.setName("Window");
		miVentana.setVisible(true);
		
		//Instanciar y registrar un objeto receptor para procesar los eventos del raton
		// tanto del Frame como del componente Window
		ProcesoRaton pr = new ProcesoRaton();
		miFrame.addMouseListener(pr);
		miVentana.addMouseListener(pr);

		//Instanciar y registrar para finalizar el programa
		ProcesoCierre pc = new ProcesoCierre();
		miFrame.addWindowListener(pc);
		
		
		
		
	}
}
//Clase recceptor que monitoriza los eventos del click del raton tanto del Frame como del Window. Mostraremos coords del raton.
//Se va a distinguir entre ambos por su nombre
class ProcesoRaton extends MouseAdapter{

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getComponent().getName().equals("Frame")) {
			System.out.println("Capturado mousePressed sombre el Frame");
		}
		
		if(e.getComponent().getName().equals("Window")) {
			System.out.println("Capturado mousePressed sombre el Window");
		}
	
	}
	
}
class ProcesoCierre extends WindowAdapter{

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Capturado el evento de cerrar la Ventana desde el Frame");
		System.exit(0);
		
	}

	
	
}

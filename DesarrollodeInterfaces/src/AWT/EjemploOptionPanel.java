package AWT;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class EjemploOptionPanel {

	public static void main(String[] args) {
		String usuario = JOptionPane.showInputDialog(null,"Usuario", "LOGIN", 1);
		String pass = JOptionPane.showInputDialog(null,"Contraseña", "PASSWORD", 0);
		
		if("bea".equals(usuario) && "1234".equals(pass)) {
			JOptionPane.showConfirmDialog(null, "Login correcto", "Correcto", JOptionPane.NO_OPTION);
			
		}else {
			JOptionPane.showConfirmDialog(null, "Login incorrecto", "Inorrecto", JOptionPane.ERROR_MESSAGE);
		}
		
		int confirmado =JOptionPane.showConfirmDialog(null, "¿Seguro?");
		if(confirmado == JOptionPane.OK_OPTION) {
			System.out.println("Confirmado");
		}else {
			System.out.println("No me sirve");
			}
		
		String[] botones = {"Boton A","Boton B","Boton C","Boton D"};
		int ventana = JOptionPane.showOptionDialog(null, "Pulsa un boton", "Prueba", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
		
		
		if (ventana == 0) {
			System.out.println("Pulsada opcion A");
			
		}else if(ventana ==1) {
			System.out.println("Pulsada opcion B");
		
		}else if(ventana ==2) {
			System.out.println("Pulsada opcion C");
		}else {
			System.out.println("Pulsada opcion D");
	}

}
}



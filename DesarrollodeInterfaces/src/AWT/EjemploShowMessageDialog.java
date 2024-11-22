package AWT;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class EjemploShowMessageDialog {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Dos parametros");
		
		JOptionPane.showMessageDialog(null, "mensaje de informacion", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);

		JOptionPane.showMessageDialog(null, "mensaje de aviso", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		
		JOptionPane.showMessageDialog(null, "mensaje de error", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
		
		JOptionPane.showMessageDialog(null, "mensaje de pregunta", "Question_MESSAGE", JOptionPane.QUESTION_MESSAGE);
		
				
		
		ImageIcon icono = new ImageIcon("C:\\Users\\Alum_DAM\\Desktop\\BEA COSAS\\Bea\\Lenguaje de Marcas\\HTML\\imagenes\\a.png"
				+ ""); 
		JOptionPane.showInternalMessageDialog(null, "Personalizado", "CesFuencarral", 0 ,icono);
	}

}

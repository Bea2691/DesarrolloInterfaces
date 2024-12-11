package SWING;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.formdev.flatlaf.FlatDarculaLaf;

public class EjJFileChooser {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(new FlatDarculaLaf());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFrame ventana = new JFrame("Ejemplo File Chooser");
		JFileChooser selector = new JFileChooser();
		
		//Ventana diálogo para abrir un fichero
		selector.showOpenDialog(ventana);
		
		//Ventana para guardar un fichero
		selector.showSaveDialog(ventana);
		
		//Cambiar texto de la barra de titulo y del boton aceptar
		selector.showDialog(ventana, "Elige un fichero");
		
		//Filtrar para mostrar solo ciertos archivos, ej solo de texto .txt y .rtf
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Ficheros de texto", "txt","rtf");
		selector.setFileFilter(filtro);
		
		selector.showDialog(ventana, "Elige un fichero");
		
		System.out.println(selector.getSelectedFile());
		ventana.setSize(200,200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}

}

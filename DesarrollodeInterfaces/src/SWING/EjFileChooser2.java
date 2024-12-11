package SWING;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.formdev.flatlaf.FlatDarculaLaf;

public class EjFileChooser2 extends JFrame implements ActionListener{
 
	private JTextField txt;
	private JButton boton;
	
	
	public EjFileChooser2(){
		
		super("JFileChooser 2");
		setLayout(new FlowLayout());
		
		txt = new JTextField(30);
		boton = new JButton("Buscar archivo");
		
		boton.addActionListener(this);
		
		
		add(txt);
		add(boton);
		
		
	}
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(new FlatDarculaLaf());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EjFileChooser2 test = new EjFileChooser2();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setSize(400,100);
		test.setVisible(true);
		
}
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Imagenes solo", "jpg", "png", "gif");
		filechooser.setFileFilter(imgFilter);
		
		int resultado = filechooser.showOpenDialog(this);
		if(resultado != JFileChooser.CANCEL_OPTION) {
			File fileName = filechooser.getSelectedFile();
			
			if(fileName == null || fileName.getName().equalsIgnoreCase("")) {
				txt.setText("...");
			}else { txt.setText(fileName.getAbsolutePath());}
		}		
		
	}
}

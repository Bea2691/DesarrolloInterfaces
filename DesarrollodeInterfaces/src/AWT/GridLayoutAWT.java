package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class GridLayoutAWT extends Frame {

	public static void main(String[] args) {
	

		GridLayoutAWT gly = new GridLayoutAWT();
		
		gly.setLayout(new GridLayout(2,3,5,5)); 
		//rows, cols, hgap y vgap
		
		Button b1 = new Button("Uno"); //Es mejor esta forma de declararlo porque tiene un objeto "b1" asociado
		gly.add(b1);
		
				
		gly.add(new Button("Dos"));
		gly.add(new Button("Tres"));
		gly.add(new Button("Cuatro"));
		gly.add(new Button("Cinco"));
				
			
		gly.setSize(200,200); //Ancho x alto del Frame
		//bly.pack();
		gly.setVisible(true);
	}

}

package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class BorderLayoutAWT extends Frame{

	public static void main(String[] args) {

		BorderLayoutAWT bly = new BorderLayoutAWT();
		
		bly.setLayout(new BorderLayout(10,10)); 
		//Separacion entre componentes hgap(separacion horizontal) y vgap (separacion vertical)
		
		Button b1 = new Button("Norte"); //Es mejor esta forma de declararlo porque tiene un objeto "b1" asociado
		bly.add(b1, BorderLayout.NORTH);
		
				
		bly.add(new Button("Sur"), BorderLayout.SOUTH);
		bly.add(new Button("Este"), BorderLayout.EAST);
		bly.add(new Button("Oeste"), BorderLayout.WEST);
		bly.add(new Button("Centro"), BorderLayout.CENTER);
		bly.add(new Button("Centro2"), BorderLayout.CENTER);//Solo saldría este en el centro, se superponen
		
		bly.setSize(200,200); //Ancho x alto del Frame
		//bly.pack();
		bly.setVisible(true);
	}

}

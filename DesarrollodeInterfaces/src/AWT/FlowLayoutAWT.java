package AWT;

import java.awt.*;

public class FlowLayoutAWT extends Frame {

	public static void main(String[] args) {
		
		FlowLayoutAWT fld = new FlowLayoutAWT();
		
		fld.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10)); 
		//Separacion entre componentes y con align right, hgap(separacion horizontal) y vgap (separacion vertical)
		
		fld.add(new Button("Uno"));
		fld.add(new Button("Dos"));
		fld.add(new Button("Tres"));
		
		fld.setSize(300,100); //Ancho x alto
		fld.pack();
		fld.setVisible(true);
		
		

	}
	
	

}

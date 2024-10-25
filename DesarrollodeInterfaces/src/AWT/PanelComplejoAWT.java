package AWT;

import java.awt.*;

public class PanelComplejoAWT extends Frame{

	public static void main(String[] args) {
		PanelComplejoAWT cl = new PanelComplejoAWT();
		
		//Panel para cada una de las tres zonas a usar, norte, centro y sur
		
		Panel pnorth = new Panel();
		Panel pcenter = new Panel();
		Panel psouth = new Panel();
		
		//El LayOut por defecto de los Paneles es FlowLayOut
		//EL LayOut por defecto de los Frames es el BorderLayOut
		
		//Panel north
		pnorth.add(new Button("Uno"));
		pnorth.add(new Button("Dos"));
		pnorth.add(new Button("Tres"));
	
		//Panel center
		pcenter.setLayout(new GridLayout(4,1,3,3));
		pcenter.add(new TextField("Primero"));
		pcenter.add(new TextField("Segundo"));
		pcenter.add(new TextField("Tercero"));
		pcenter.add(new TextField("Cuarto"));
		
		//Panel south
		psouth.setLayout(new BorderLayout());
		psouth.add(new Checkbox("Selecciona uno de los lados"), BorderLayout.CENTER);
		psouth.add(new Checkbox("El este"), BorderLayout.EAST);
		psouth.add(new Checkbox("O el oeste"), BorderLayout.WEST);
		
		
		
		//Añadir paneles al Frame
		
		
		cl.add(pnorth,BorderLayout.NORTH);
		cl.add(pcenter, BorderLayout.CENTER);
		cl.add(psouth, BorderLayout.SOUTH);
		
		
		cl.setSize(350,350);
		cl.setVisible(true);
		
		
		
		

	}

}

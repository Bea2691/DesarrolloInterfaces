package AWT;

import java.awt.*;

public class misComponentes extends Panel{
	
	public misComponentes() {
		
		setBackground(Color.LIGHT_GRAY);
		
		Label label = new Label("Componentes");
		add(label);
		
		
		
		Button b1 = new Button("Púlsame");
		add(b1);
		
		Checkbox ch1 = new Checkbox("Rojo");
		add(ch1);
		Checkbox ch2 = new Checkbox("Verde");
		add(ch2);
		Checkbox ch3 = new Checkbox("Azul", true); //El true es para que aparezca marcado por defecto
		add(ch3);
		
		
		CheckboxGroup chg = new CheckboxGroup(); //Grupo de cheboxes estilo radiobutton
		Checkbox rb1 = new Checkbox("Alto", chg, false);
		Checkbox rb2 = new Checkbox("Medio", chg, true);
		Checkbox rb3 = new Checkbox("Bajo", chg, false);
		add(rb1);
		add(rb2);
		add(rb3);
		
		Choice c1 = new Choice(); //Desplegable con opciones
		add(c1);
		c1.addItem("Pedro");
		c1.addItem("Beatriz");
		c1.addItem("Lorena");
		c1.addItem("MiMadre");
		c1.addItem("MiPadre");
		
		List l1 = new List(3, false); //3 Opciones y el false indica que no hay seleccion multiple
		add(l1);
		l1.add("Pedro");
		l1.add("Beatriz");
		l1.add("Lorena");
		l1.add("MiMadre");
		l1.add("MiPadre");
		
		TextField tf1 = new TextField(10); //Solo una linea
		add(tf1);
		
		TextArea ta1= new TextArea(10,10); //Area de texto
		add(ta1);
		
		Scrollbar sb = new Scrollbar();
		add(sb);
		
		
		Canvas cv = new Canvas(); //A esto le falta un lienzo para pintar en el
		cv.setBackground(Color.PINK);
		cv.setSize(100,50);
		add(cv);
		
		
	}
	public static void main(String[] args) {
		
		misComponentes mc = new misComponentes();
		Frame f = new Frame("Ejemplo");
		f.add(mc);
		f.pack(); //Se adapta la ventana a los componentes que contenga
		f.setVisible(true);
		
		
		
	}
	

}

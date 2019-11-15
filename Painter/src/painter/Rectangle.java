package painter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Rectangle extends CompositeShape {

	ArrayList<IShape> shapes=new ArrayList<>();
	int[][] point;
	public Rectangle(int[][] point) {
		this.point=point;
	}
	
	@Override
	public void buildShape() {
		
		shapes.add(new Line(point[0][0],point[0][1],point[1][0],point[1][1]));
		shapes.add(new Line(point[1][0],point[1][1],point[2][0],point[2][1]));
		shapes.add(new Line(point[2][0],point[2][1],point[3][0],point[3][1]));
		shapes.add(new Line(point[3][0],point[3][1],point[0][0],point[0][1]));
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		if(Painter.colorFill) {
			g2d.setColor(Color.green);
			g2d.fillRect(point[0][0], point[0][1], point[1][0]-point[0][0], point[2][1]-point[1][1]);
		}
		
		buildShape();
		for(IShape shape:shapes) {
			
			shape.draw(g2d);
		}
		
	}
	
	
}

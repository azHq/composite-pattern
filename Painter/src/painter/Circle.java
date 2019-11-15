package painter;

import java.awt.Color;
import java.awt.Graphics2D;

public class Circle extends BasicShape {

	int cx=100,cy=100;
	int radius=100;
	
	public Circle(int cx,int cy,int radius) {
		
		this.cx=cx;
		this.cy=cy;
		this.radius=radius;
	}
	@Override
	public void draw(Graphics2D g2d) {
		
		
		g2d.setColor(Painter.color);
		if(Painter.colorFill) g2d.fillOval(cx,cy,radius*2,radius*2);
		else g2d.drawOval(cx,cy,radius*2,radius*2);
		
	}
	public void setCenter(int cx,int cy) {
		
		this.cx=cx;
		this.cy=cy;
	}
}

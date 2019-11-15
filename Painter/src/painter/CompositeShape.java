package painter;

import java.awt.Graphics2D;
import java.util.ArrayList;

public abstract class CompositeShape implements IShape{

	ArrayList<IShape> shapes=new ArrayList<>();
	@Override
	public void draw(Graphics2D g2d) {
			
		for(IShape shape:shapes) {
			
			buildShape();
			shape.draw(g2d);
		}
	}
	
	public abstract void buildShape();

}

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class GraphicalDie extends Die {

	private double width, height;	// The width and height of the die.
	private double x,y ;			// The x and y coordinates of the die.
	private GraphicsContext g;		// The GraphicsContext used to draw the die.

	
	/**
	 * Constructor. If not parameters are specified, the die rolls itself and has an
	 * initial width of 50 and height of 50.
	 */
	public GraphicalDie() {
		super();
		this.width = 50;
		this.height = 50;
	}
	
	/**
	 * Constructor that sets the die to the specified value.
	 * @param value The value of the die.
	 */
	public GraphicalDie(int value) {
		super(value);
		this.width = 50;
		this.height = 50;
	}
	
	/**
	 * Constructor that allows you to set the x/y coordinates and width/height of the die.
	 * @param x The x-coordinate.
	 * @param y The y-coordinate.
	 * @param width The width of the die.
	 * @param height The height of the die.
	 */
	public GraphicalDie(double x, double y, double width, double height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Constructor that allows you to set the value and width/height of the die.
	 * @param value The value of the die.
	 * @param width The width of the die.
	 * @param height The height of the die.
	 */
	public GraphicalDie(int value, double width, double height) {
		super(value);
		this.width = width;;
		this.height = width;
	}

	
	
	public void drawDie(GraphicsContext g) {
		int dieValue = this.getValue();
		
		double circleWidth = width / 4;
		double circleHeight = height / 4;
		
		g.setFill(Color.BLACK);
		g.fillRect(x, y, width , height);
		
		g.setFill(Color.WHITE);
		g.fillRect(x + 2, y + 2, width - 4, height - 4);
		
		g.setFill(Color.BLACK);		
		if(dieValue == 1) {
			g.fillOval(x + (circleWidth * 1.5) , y + (circleHeight * 1.5) , circleWidth, circleHeight);
		}		
		else if(dieValue == 2) {			
			g.fillOval(x + (circleWidth * .5) , y + (circleHeight * 2.5) , circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * 2.5), y + (circleHeight * .5), circleWidth, circleHeight);
		}			
		else if(dieValue == 3) {
			g.fillOval(x + (circleWidth * .5) , y + (circleHeight * 2.5) , circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * 1.5) , y + (circleHeight * 1.5) , circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * 2.5), y + (circleHeight * .5), circleWidth, circleHeight);
		}			
		else if(dieValue == 4) {
			g.fillOval(x + (circleWidth * .5) , y + (circleHeight * .5) , circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * .5) , y + (circleHeight * 2.5) , circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * 2.5), y + (circleHeight * .5), circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * 2.5), y + (circleHeight * 2.5), circleWidth, circleHeight);
		}			
		else if(dieValue == 5) {
			g.fillOval(x + (circleWidth * .5) , y + (circleHeight * .5) , circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * .5) , y + (circleHeight * 2.5) , circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * 1.5) , y + (circleHeight * 1.5) , circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * 2.5), y + (circleHeight * .5), circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * 2.5), y + (circleHeight * 2.5), circleWidth, circleHeight);
		}			
		else if(dieValue == 6){
			g.fillOval(x + (circleWidth * .5) , y + (circleHeight * .3) , circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * .5) , y + (circleHeight * 1.5) , circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * .5) , y + (circleHeight * 2.75) , circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * 2.5), y + (circleHeight * .25), circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * 2.5), y + (circleHeight * 1.5), circleWidth, circleHeight);
			g.fillOval(x + (circleWidth * 2.5), y + (circleHeight * 2.7), circleWidth, circleHeight);
		}		
	}
	
	/**
	 * 
	 * @param x
	 */
	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 */
	public void roll() {
		super.roll();
	}		
}

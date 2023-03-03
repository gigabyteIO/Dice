import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DieGUITest extends Application {
	
	public static void main(String[] args) {
        launch(args);
    }
	
	//--------------------------------------------------------------------------------------

	private GraphicsContext g;
	private GraphicalDie die1;
	private GraphicalDie die2;
	private GraphicalDie die3;
	private GraphicalDie die4;
	private GraphicalDie die5;
	private GraphicalDie die6;
	
	private long elapsedTime;  // When an animation is running, the number of
	//    nanoseconds for which it has been running.  This
	//    is used to end the animation after 1 second.
	//    (One second is 1,000,000,000 nanoseconds.

	private long startTime;   // Time, in nanoseconds, when the animaion started.

	private AnimationTimer timer = new AnimationTimer() {
		// The timer is used to animate "rolling" of the dice.
		// In each frame, the dice values are randomized.  When
		// the elapsed time reaches 1 second, the timer stops itself.
		// The rollButton is disabled while an animation is in
		// progress, so it has to be enabled when the animation stops.
		public void handle( long time ) {		
			die1.roll();
			die2.roll();
			draw();
			if ( time - startTime >= 1_000_000_000 ) {
				timer.stop();
				rollButton.setDisable(false);
			}
		}
	};
	private Button rollButton;
	
	@Override
	public void start(Stage stage) {
		Canvas canvas = new Canvas(600, 600);
		g = canvas.getGraphicsContext2D();
		
		die1 = new GraphicalDie(1, 50, 50);
		die1.setXY(100, 100);
		die2 = new GraphicalDie(2, 50, 50);
		die2.setXY(175, 100);
		rollButton = new Button("roll");
		
		rollButton.setOnAction( evt -> roll() );
			
		
		HBox bottomBar = new HBox(rollButton);
    	bottomBar.setAlignment(Pos.CENTER);
    	bottomBar.setStyle( // CSS styling for the HBox
                "-fx-padding: 5px; -fx-border-color: black; -fx-background-color: brown" );
		
		BorderPane root = new BorderPane();
		root.setCenter(canvas);
		root.setBottom(bottomBar);
		root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Die GUI");
		stage.setResizable(false);
		stage.show();		
		
		draw();
	}
		
	private void roll() {
		rollButton.setDisable(true);
		startTime = System.nanoTime();
		timer.start(); // start an animation
	}
	
	private void draw() {		

		die1.drawDie(g);
		System.out.println(die1.getValue());

		die2.drawDie(g);
		System.out.println(die2.getValue());
//		
//		die3 = new GraphicalDie(3, 50, 50);
//		die3.draw(g, 200, 100);
//		
//		die4 = new GraphicalDie(4, 50, 50);
//		die4.draw(g, 275, 100);
//		
//		die5 = new GraphicalDie(5, 50, 50);
//		die5.draw(g, 350, 100);
//		
//		die6 = new GraphicalDie(6, 50, 50);
//		die6.draw(g, 425, 100);	
	}
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockanimation;




import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.util.Duration;
import javafx.geometry.*;

public class ClockAnimation extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    ClockPane clock = new ClockPane(); // Create a clock
	
	HBox hBox = new HBox(20);
	Button sto = new Button("Stop");
	Button sta = new Button("Start");
	hBox.getChildren().addAll(sto, sta);
	hBox.setAlignment(Pos.CENTER);
    // Create a handler for animation
    EventHandler<ActionEvent> eventHandler = e -> {
      clock.setCurrentTime(); // Set a new clock time
    };
	
    // Create an animation for a running clock
    Timeline animation = new Timeline(
      new KeyFrame(Duration.millis(1000), eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
    sto.setOnAction(e -> animation.pause());
	sta.setOnAction(e -> animation.play());
    
    // Create a scene and place it in the stage
	BorderPane pane = new BorderPane();
	pane.setCenter(clock);
	pane.setBottom(hBox);
    Scene scene = new Scene(pane, 250, 250);
    primaryStage.setTitle("ClockAnimation"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

	
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}


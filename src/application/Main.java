package application;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application { 
@Override 
public void start(Stage primaryStage) { 
Box box = new Box(); 
// размеры 
box.setWidth(150); 
box.setHeight(150); 
box.setDepth(150); 

// позиция 
box.setTranslateX(350); 
box.setTranslateY(150); 
box.setTranslateZ(50); 

PhongMaterial mt = new PhongMaterial(); 
mt.setDiffuseColor(Color.RED); 
box.setMaterial(mt); 

// вращение 
RotateTransition rt = new RotateTransition(); 
rt.setDuration(Duration.millis(1)); 
rt.setNode(box); 
rt.setAxis(Rotate.Y_AXIS); 
rt.setByAngle(360); 
rt.setCycleCount(50); 

Button btn = new Button(); 
btn.setText("Start"); 
btn.setLayoutX(50); 
btn.setLayoutY(100); 

EventHandler<javafx.scene.input.MouseEvent> ehb = 
new EventHandler<javafx.scene.input.MouseEvent>() { 
public void handle1(MouseEvent event) { 
rt.play(); 
}

@Override
public void handle(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
} 
}; 
btn.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, ehb); 
Group root = new Group(box,btn); 
Scene scene = new Scene(root,600,300); 
PerspectiveCamera camera = new PerspectiveCamera(); 
camera.setTranslateX(0); 
camera.setTranslateY(0); 
camera.setTranslateZ(0); 
scene.setCamera(camera); 

primaryStage.setScene(scene); 
primaryStage.show(); 



} 

public static void main(String[] args) { 
launch(args); 
} 
}
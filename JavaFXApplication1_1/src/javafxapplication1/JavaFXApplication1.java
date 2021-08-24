/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jhicks
 */
public class JavaFXApplication1 extends Application {
    
    
    Random randomNumber = new Random();
    int number = randomNumber.nextInt(100);
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        Button close = new Button();
        TextField txt = new TextField();
        Label lbl1 = new Label("");
        Label lbl2 = new Label("");
        btn.setText("Guess");
        close.setText("Close");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                String guess = txt.getText();
                try {
                    if (Integer.parseInt(guess) == number)
                    {
                        lbl1.setText("Correct");
                    }
                    else if (Integer.parseInt(guess) > number)
                    {
                        
                        lbl2.setLayoutX(79);
                        lbl2.setLayoutY(177);
                        lbl1.setText("| \n"
                                + "| \n"
                                + "| \n"
                                + "| \n");
                        lbl2.setText("v");
                        
                    }
                    else if (Integer.parseInt(guess) < number)
                    {
                        
                        lbl2.setLayoutX(78);
                        lbl2.setLayoutY(110);
                        lbl2.setText("^");
                        lbl1.setText("| \n"
                                + "| \n"
                                + "| \n"
                                + "| \n");
                        
                    }
                }
                
                catch (Exception e)
                {
                    System.out.println("Try an integer between 1-100");
                }
                
            }
        });
        
        close.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        
        Group root = new Group();
        root.getChildren().addAll(txt, lbl1, lbl2, close, btn);
        btn.setLayoutX(125);
        btn.setLayoutY(140);
        txt.setLayoutX(75);
        txt.setLayoutY(85);
        lbl1.setLayoutX(80);
        lbl1.setLayoutY(117);
        close.setLayoutX(225);
        close.setLayoutY(200);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Guess the Number");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

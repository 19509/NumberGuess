/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    public void start(Stage primaryStage) throws FileNotFoundException {
        //Initializing Objects
        Button btn = new Button();
        Button close = new Button();
        Button rnd = new Button();
        TextField txt = new TextField();
        Image img1 = new Image(new FileInputStream("Images\\up-arrow.jpg"));
        Image img2 = new Image(new FileInputStream("Images\\down-arrow.png"));
        ImageView imgview = new ImageView(img1);
        ImageView imgview2 = new ImageView(img2);
        
        //Setting text for objects
        Label lbl1 = new Label("");
        Label lbl2 = new Label("");
        btn.setText("Guess");
        close.setText("Close");
        rnd.setText("Randomize");
        
        
        //Setting imageView fields
        imgview.setX(10);
        imgview.setY(150);
        imgview.setFitHeight(100);
        imgview.setFitWidth(100);
        
        imgview2.setX(10);
        imgview2.setY(150);
        imgview2.setFitHeight(100);
        imgview2.setFitWidth(100);
        
        imgview.setPreserveRatio(true);
        imgview2.setPreserveRatio(true);
        
        imgview.setVisible(false);
        imgview2.setVisible(false);
        
        //Event handler for the guess button
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                String guess = txt.getText();
                
                
                /*
                    If the integer in the text box matches random integer, the 
                    label changes to reflect that. Otherwise, the application 
                    responds accordingly.
                */
                try {
                    if (Integer.parseInt(guess) == number)
                    {
                        lbl1.setText("Correct");
                        setImgVis(imgview, imgview2, false, false);
                    }
                    else if (Integer.parseInt(guess) > number)
                    {
                        lbl1.setText("Lower");
                        setImgVis(imgview, imgview2, false, true);
                    }
                    else if (Integer.parseInt(guess) < number)
                    {
                        lbl1.setText("Higher");
                        setImgVis(imgview, imgview2, true, false);
                    }
                }
                
                catch (Exception e)
                {
                    lbl1.setText("Try an integer between 1-100");
                }
                
            }
        });
        
        
        //Close button handler; Closes the application
        close.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        
        //Calls the method that randomizes the integer that the user is meant to
        //guess when the "Randomize" button is pressed.
        rnd.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Randomize();
                lbl1.setText("");
            }
        });
        
        //Creates a group and assigns all the previously created objects as 
        //children to the group.
        Group root = new Group();
        root.getChildren().addAll(txt, lbl1, lbl2, close, btn, rnd, 
                imgview, imgview2);
        
        //Sets the location of each object added to the group.
        btn.setLayoutX(125);
        btn.setLayoutY(140);
        txt.setLayoutX(75);
        txt.setLayoutY(85);
        lbl1.setLayoutX(100);
        lbl1.setLayoutY(117);
        close.setLayoutX(225);
        close.setLayoutY(200);
        rnd.setLayoutX(225);
        rnd.setLayoutY(10);
        
        
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
    
    
    //Handles image visibility to handle redundant code.
    public void setImgVis(ImageView img1, ImageView img2, boolean pick1,
            boolean pick2)
    {
        img1.setVisible(pick1);
        img2.setVisible(pick2);
    }
    
    //Creates a new random number for the user to guess.
    public void Randomize()
    {
        number = randomNumber.nextInt(100);
        
    }
    
}

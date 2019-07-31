/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Tablero;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Jorge Morales
 */
public class Main extends Application{
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, InterruptedException{
        Tablero t = new Tablero();
        //t.leerDatos(); //random or not
        Pane layout  = new Pane();  
        Canvas canvas = new Canvas(600,600);
        layout.getChildren().add(canvas);
        Scene escena = new Scene(layout,600,600, Color.BLACK);
        primaryStage.setScene(escena);
        primaryStage.setTitle("Juego de la vida");
        primaryStage.show();
        GraphicsContext lapiz = canvas.getGraphicsContext2D();
        View v = new View(escena, lapiz, t);
        v.start();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Application.launch(args);
    }
    
}

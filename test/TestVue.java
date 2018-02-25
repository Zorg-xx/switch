/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author y
 */
public class TestVue extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setMaxWidth(500);
        primaryStage.setMaxHeight(700);

        
        Vue1 v=new Vue1(primaryStage);
        
        primaryStage.setTitle("test changement de vue");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

package main;


import javafx.application.Application;
import javafx.stage.Stage;
import vue.Vue1;


public class Main extends Application {
    
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
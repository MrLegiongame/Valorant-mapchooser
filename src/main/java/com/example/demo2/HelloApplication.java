package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load((getClass().getResource("hello-view.fxml")));

        //scen and icon settings
        Scene scene = new Scene(root,800,800, Color.DARKGRAY); //set size and bk color
        stage.setTitle("Valorant Pracc Random Map"); //window name
        Image icon = new Image("C:\\Users\\BIG-PC\\IdeaProjects\\demo2\\src\\main\\java\\com\\example\\demo2\\logo.jpg"); // import logo
        stage.getIcons().add(icon); //set as program icon

//        //title in the scene
//        Text scene_title = new Text();
//        scene_title.setText("Maps Picker");
//        scene_title.setX(220);
//        scene_title.setY(50);
//        scene_title.setFont(Font.font("Verdana", 50));
//        root.getChildren().add(scene_title);

        stage.setScene(scene);
        stage.show();
    }
}
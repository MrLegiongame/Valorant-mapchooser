package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private String[] Maps = {"Bind","Haven","Split","Ascent","Icebox","Breeze","Fracture","Pearl"};
    private String[] Block_maps = {"","","",""};
    //Pick Team 1
    @FXML
    private Label T_1_Pick;
    @FXML
    private ChoiceBox<String> Team_1_Pick;

    //Pick Team 2
    @FXML
    private Label T_2_Pick;
    @FXML
    private ChoiceBox<String> Team_2_Pick;

    //Ban Team 1
    @FXML
    private ChoiceBox<String> Team_1_Ban;

    //Ban Team 2
    @FXML
    private ChoiceBox<String> Team_2_Ban;

    //Random map
    @FXML
    private Label Random_Map;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //insert maps to all choice boxes
        Team_1_Pick.getItems().addAll(Maps);
        Team_2_Pick.getItems().addAll(Maps);
        Team_1_Ban.getItems().addAll(Maps);
        Team_2_Ban.getItems().addAll(Maps);


        //connect Event
        Team_1_Pick.setOnAction(this::set_maps_1);
        Team_2_Pick.setOnAction(this::set_maps_2);
        Team_1_Ban.setOnAction(this:: ban_map_1);
        Team_2_Ban.setOnAction(this::ban_map_2);
    }

    public void set_maps_1(ActionEvent event){
        String maps_1 = Team_1_Pick.getValue();
        Block_maps[0] =Team_1_Pick.getValue();
        T_1_Pick.setText(maps_1);
    }
    public void set_maps_2(ActionEvent event){
        String maps_2 = Team_2_Pick.getValue();
        Block_maps[1] = Team_2_Pick.getValue();
        T_2_Pick.setText(maps_2);
    }
    public void ban_map_1(ActionEvent e){
        Block_maps[2] = Team_1_Ban.getValue();
    }
    public void ban_map_2(ActionEvent e){
        Block_maps[3] = Team_2_Ban.getValue();
    }

    public void Random_Button (ActionEvent e){
        String[] new_maps = new String[Maps.length - 4];
        String[] Maps_copy = Maps;
        //create new array without ban and chosen maps
        for(int j = 0; j < Block_maps.length; j++){
            for(int i = 0; i <Maps.length ; i++){
                if(Block_maps[j].equals(Maps[i])){ // deleted all same strings
                    Maps_copy[i] = "";
                }
            }
        }
        int k =0;
        for(int i = 0;i<Maps_copy.length; i++){
            if(Maps_copy[i] != ""){
                new_maps[k] = Maps_copy[i]; // create new array without deleted strings
                k++;
            }
        }
        Random random = new Random();
        int index = random.nextInt(new_maps.length);
        Random_Map.setText(new_maps[index]);
    }

}

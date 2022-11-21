/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gameoflife.gui;

import com.mycompany.gameoflife.GameOfLife;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 *
 * @author jokin
 */
public class MenuView {
    
    private GameOfLife game;
    private GameStateAnimationTimer timer;
    private VBox menu;

    public MenuView(GameOfLife game, GameStateAnimationTimer timer) {
        this.game = game;
        this.timer = timer;
        this.menu = new VBox();
        
        int menuWidth = 80;
        this.menu.setPrefWidth(menuWidth);
        
        Button clearButton = new Button("Clear");
        clearButton.setPrefWidth(menuWidth);
        clearButton.setOnAction((event) -> {
            this.game.clear();
            this.timer.update();
        });
        
        Button initRandomButton = new Button("Init random");
        initRandomButton.setPrefWidth(menuWidth);
        initRandomButton.setOnAction((event) -> {
            this.game.initRandomState();
            this.timer.update();
        });
        
        Button nextStateButton = new Button("Next state");
        nextStateButton.setPrefWidth(menuWidth);
        nextStateButton.setDisable(true);
        nextStateButton.setOnAction((event) -> {
            this.timer.update();
        });
        
        Button stopStartButton = new Button("Stop/Start");
        stopStartButton.setPrefWidth(menuWidth);
        stopStartButton.setOnAction((event) -> {
            nextStateButton.setDisable(!this.timer.toggleStop());
        });
        
        this.menu.getChildren().addAll(clearButton, initRandomButton, stopStartButton, nextStateButton);
    }
    
    public VBox getMenu() {
        return this.menu;
    }
}

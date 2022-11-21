/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gameoflife.gui;

import com.mycompany.gameoflife.GameOfLife;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author jokin
 */
public class MainView extends Application {
    
    private GameOfLife game;
    private GameStateView gameStateView;
    private MenuView menuView;
    private GameStateAnimationTimer timer;

    @Override
    public void start(Stage stage) throws Exception {
        this.game = new GameOfLife(200, 200);
        this.gameStateView = new GameStateView(this.game, 4);
        this.timer = new GameStateAnimationTimer(this.game, this.gameStateView, 50);
        this.menuView = new MenuView(this.game, this.timer);
        
        BorderPane root = new BorderPane();
        root.setCenter(this.gameStateView.getCanvas());
        root.setLeft(this.menuView.getMenu());

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("GameOfLife");
        stage.setResizable(false);
        stage.show();
        
        this.timer.start();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gameoflife.gui;

import com.mycompany.gameoflife.GameOfLife;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author jokin
 */
public class GameStateView {

    private Canvas canvas;
    private GraphicsContext plotter;
    private int cellSize;
    private GameOfLife game;

    public GameStateView(GameOfLife game, int cellSize) {
        this.canvas = new Canvas(game.getGridSizeX() * cellSize, game.getGridSizeY() * cellSize);
        this.plotter = canvas.getGraphicsContext2D();
        this.cellSize = cellSize;
        this.game = game;

        this.canvas.setOnMouseClicked((event) -> {
            int x = (int) event.getX() / cellSize;
            int y = (int) event.getY() / cellSize;
            setAlive(x, y);
        });

        this.canvas.setOnMouseDragged((event) -> {
            int x = (int) event.getX() / cellSize;
            int y = (int) event.getY() / cellSize;
            setAlive(x, y);
        });
    }

    public void update() {
        this.plotter.setFill(Color.DARKGRAY);
        this.plotter.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int[][] state = game.getState();
        for (int x = 0; x < game.getGridSizeX(); x++) {
            for (int y = 0; y < game.getGridSizeY(); y++) {
                fillCellIfAlive(x, y);
            }
        }
    }

    private void fillCellIfAlive(int x, int y) {
        if (!this.game.isInBounds(x, y)) return;
        if (this.game.getState()[x][y] > 0) {
            this.plotter.setFill(Color.BLACK);
            this.plotter.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
        }
    }

    private void setAlive(int x, int y) {
        this.game.setAlive(x, y);
        fillCellIfAlive(x, y);
    }

    public Canvas getCanvas() {
        return canvas;
    }

}

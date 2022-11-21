/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gameoflife.gui;

import com.mycompany.gameoflife.GameOfLife;
import com.mycompany.gameoflife.gui.GameStateView;
import javafx.animation.AnimationTimer;

/**
 *
 * @author jokin
 */
public class GameStateAnimationTimer extends AnimationTimer {
    
    private GameOfLife game;
    private GameStateView gameStateView;
    private long updateInterval;
    private long prevUpdate;
    private boolean stopped;
    
    public GameStateAnimationTimer(GameOfLife game, GameStateView gameStateView, long updateInterval) {
        this.game = game;
        this.gameStateView = gameStateView;
        this.updateInterval = updateInterval;
        this.stopped = false;
    }
    
    public boolean toggleStop() {
        this.stopped = !this.stopped;
        return this.stopped;
    }

    @Override
    public void handle(long l) {
        if (!this.stopped) this.update();
    }
    
    public void update() {
        long currTime = System.currentTimeMillis();
        if (currTime - prevUpdate < updateInterval) {
            return;
        }
        System.out.println("Updating after " + (currTime - prevUpdate) + "ms");
        this.game.update();
        this.gameStateView.update();
        this.prevUpdate = currTime;
    }
    
}

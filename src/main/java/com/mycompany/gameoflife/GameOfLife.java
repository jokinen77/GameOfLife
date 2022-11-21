/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.gameoflife;

import java.util.Random;

/**
 *
 * @author jokin
 */
public class GameOfLife {

    private int[][] state;

    public GameOfLife(int gridSizeX, int gridSizeY) {
        this.state = new int[gridSizeX][gridSizeY];
    }
    
    public GameOfLife(int[][] state) {
        this.state = state;
    }

    public void initRandomState() {
        Random random = new Random();
        for (int i = 0; i < getGridSizeX() * getGridSizeY(); i++) {
            int x = random.nextInt(getGridSizeX() - 1);
            int y = random.nextInt(getGridSizeY() - 1);
            this.state[x][y] = 1;
        }
    }
    
    public void clear() {
        this.state = new int[getGridSizeX()][getGridSizeY()];
    }

    public int[][] getState() {
        return state;
    }

    public int getGridSizeX() {
        return this.state.length;
    }

    public int getGridSizeY() {
        return this.state[0].length;
    }

    public void setAlive(int x, int y) {
        if (isInBounds(x, y)) {
            this.state[x][y] = 1;
        }
    }

    public void update() {
        int[][] nextState = new int[getGridSizeX()][getGridSizeY()];
        for (int x = 0; x < getGridSizeX(); x++) {
            for (int y = 0; y < getGridSizeY(); y++) {
                handleCellUpdate(nextState, x, y);
            }
        }
        this.state = nextState;
        System.out.println("Cells alive: " + countCellsAlive());
    }

    public int countCellsAlive() {
        int aliveCells = 0;
        for (int x = 0; x < getGridSizeX(); x++) {
            for (int y = 0; y < getGridSizeY(); y++) {
                if (this.state[x][y] > 0) {
                    aliveCells++;
                }
            }
        }
        return aliveCells;
    }

    public void handleCellUpdate(int[][] nextState, int x, int y) {
        int value = state[x][y];
        int neighbourCount = getNeighbourCount(x, y);
        if (value > 0) {
            if (neighbourCount < 2 || neighbourCount > 3) {
                nextState[x][y] = 0;
            } else {
                nextState[x][y] = 1;
            }
        } else if (neighbourCount == 3) {
            nextState[x][y] = 1;
        }
    }

    public int getNeighbourCount(int x, int y) {
        int count = 0;
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                if (xOffset == 0 && yOffset == 0) {
                    continue;
                }
                if (!isInBounds(x + xOffset, y + yOffset)) {
                    continue;
                }
                if (state[x + xOffset][y + yOffset] > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isInBounds(int x, int y) {
        if (x < 0 || x >= getGridSizeX()) {
            return false;
        }
        if (y < 0 || y >= getGridSizeY()) {
            return false;
        }
        return true;
    }
}

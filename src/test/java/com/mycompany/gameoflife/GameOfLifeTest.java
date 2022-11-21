/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.gameoflife;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jokin
 */
public class GameOfLifeTest {

    @Test
    public void testInitRandomState() {
        GameOfLife game = new GameOfLife(20, 20);
        assertEquals(0, game.countCellsAlive());
        game.initRandomState();
        assertTrue(game.countCellsAlive() > 0);
    }
    
    @Test
    public void testClear() {
        GameOfLife game = new GameOfLife(new int[][]{
            {0, 0, 1},
            {0, 1, 0},
            {1, 0, 0}}
        );
        assertEquals(3, game.countCellsAlive());
        
        game.clear();
        assertEquals(0, game.countCellsAlive());
    }

    @Test
    public void testGetGridSizeX() {
        GameOfLife game = new GameOfLife(30, 20);
        assertEquals(30, game.getGridSizeX());
    }

    @Test
    public void testGetGridSizeY() {
        GameOfLife game = new GameOfLife(30, 20);
        assertEquals(20, game.getGridSizeY());
    }

    @Test
    public void testSetAlive() {
        GameOfLife game = new GameOfLife(20, 20);
        assertEquals(0, game.countCellsAlive());
        game.setAlive(0, 0);
        game.setAlive(19, 19);
        assertEquals(2, game.countCellsAlive());
    }

    @Test
    public void testSetAliveOutOfBounds() {
        GameOfLife game = new GameOfLife(20, 20);
        assertEquals(0, game.countCellsAlive());
        game.setAlive(-1, 0);
        game.setAlive(0, -1);
        game.setAlive(20, 19);
        game.setAlive(19, 20);
        assertEquals(0, game.countCellsAlive());
    }

    @Test
    public void testCountCellsAlive() {
        GameOfLife game = new GameOfLife(new int[][]{
            {0, 0, 1},
            {0, 1, 0},
            {1, 0, 0}}
        );
        assertEquals(3, game.countCellsAlive());
    }

    @Test
    public void testHandleCellUpdateWithZeroNeighbours() {
        int[][] nextState = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}};

        GameOfLife game = new GameOfLife(new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}}
        );

        game.handleCellUpdate(nextState, 1, 1);
        assertEquals(0, nextState[1][1]);
    }

    @Test
    public void testHandleCellUpdateWithOneNeighbours() {
        int[][] nextState = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}};

        GameOfLife game = new GameOfLife(new int[][]{
            {0, 1, 0},
            {0, 1, 0},
            {0, 0, 0}}
        );

        game.handleCellUpdate(nextState, 1, 1);
        assertEquals(0, nextState[1][1]);
    }

    @Test
    public void testHandleCellUpdateWithTwoNeighbours() {
        int[][] nextState = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}};

        GameOfLife game = new GameOfLife(new int[][]{
            {0, 1, 0},
            {0, 1, 1},
            {0, 0, 0}}
        );

        game.handleCellUpdate(nextState, 1, 1);
        assertEquals(1, nextState[1][1]);
    }

    @Test
    public void testHandleCellUpdateWithThreeNeighbours() {
        int[][] nextState = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}};

        GameOfLife game = new GameOfLife(new int[][]{
            {0, 1, 0},
            {1, 1, 1},
            {0, 0, 0}}
        );

        game.handleCellUpdate(nextState, 1, 1);
        assertEquals(1, nextState[1][1]);
    }

    @Test
    public void testHandleCellUpdateWithFourNeighbours() {
        int[][] nextState = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}};

        GameOfLife game = new GameOfLife(new int[][]{
            {1, 1, 0},
            {1, 1, 1},
            {0, 0, 0}}
        );

        game.handleCellUpdate(nextState, 1, 1);
        assertEquals(0, nextState[1][1]);
    }
    
    @Test
    public void testGetNeighbourCountNone() {
        GameOfLife game = new GameOfLife(new int[][]{
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}}
        );
        assertEquals(0, game.getNeighbourCount(2, 2));
    }
    
    @Test
    public void testGetNeighbourCountAll() {
        GameOfLife game = new GameOfLife(new int[][]{
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 11},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1}}
        );
        assertEquals(8, game.getNeighbourCount(2, 2));
    }
    
    @Test
    public void testGetNeighbourCountEdge1() {
        GameOfLife game = new GameOfLife(new int[][]{
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1}}
        );
        assertEquals(3, game.getNeighbourCount(0, 0));
    }
    
    @Test
    public void testGetNeighbourCountEdge2() {
        GameOfLife game = new GameOfLife(new int[][]{
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1}}
        );
        assertEquals(3, game.getNeighbourCount(4, 4));
    }

    @Test
    public void testIsInBounds() {
        GameOfLife game = new GameOfLife(20, 30);

        // In bounds corners
        assertTrue(game.isInBounds(0, 0));
        assertTrue(game.isInBounds(0, 29));
        assertTrue(game.isInBounds(19, 0));
        assertTrue(game.isInBounds(19, 29));

        // Out of bounds corners both directions
        assertFalse(game.isInBounds(-1, 0));
        assertFalse(game.isInBounds(0, -1));
        assertFalse(game.isInBounds(-1, 29));
        assertFalse(game.isInBounds(0, 30));
        assertFalse(game.isInBounds(20, 0));
        assertFalse(game.isInBounds(19, -1));
        assertFalse(game.isInBounds(20, 29));
        assertFalse(game.isInBounds(19, 30));
    }

    @Test
    public void testUpdate() {
        GameOfLife game = new GameOfLife(new int[][]{
            {1, 0, 0},
            {0, 1, 1},
            {1, 0, 1}}
        );

        game.update();
        AssertionUtils.assertTableEquals(game.getState(), new int[][]{
            {0, 1, 0},
            {1, 0, 1},
            {0, 0, 1}}
        );
        
        game.update();
        AssertionUtils.assertTableEquals(game.getState(), new int[][]{
            {0, 1, 0},
            {0, 0, 1},
            {0, 1, 0}}
        );
        
        game.update();
        AssertionUtils.assertTableEquals(game.getState(), new int[][]{
            {0, 0, 0},
            {0, 1, 1},
            {0, 0, 0}}
        );
        
        game.update();
        AssertionUtils.assertTableEquals(game.getState(), new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}}
        );
    }

}

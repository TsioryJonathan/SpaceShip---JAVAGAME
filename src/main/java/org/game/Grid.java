package org.game;

import lombok.Getter;
import java.util.Random;

public class Grid {
    @Getter
    private final int size;
    private char[][] grid;
    @Getter
    private int junkRemaining = 5;

    public Grid(Ship ship, int size) {
        this.size = size;
        this.grid = new char[size][size];
        initializeGrid(ship);
    }

    private void initializeGrid(Ship ship) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = '.';

        grid[ship.getX()][ship.getY()] = 'S';
        Random rand = new Random();
        for (int i = 0; i < junkRemaining;) {
            int x = rand.nextInt(size);
            int y = rand.nextInt(size);
            if (grid[x][y] == '.') {
                grid[x][y] = 'J';
                i++;
            }
        }
    }

    public int updatePosition(Ship ship, int prevX, int prevY) {
        int gainedScore = 0;
        if (grid[ship.getX()][ship.getY()] == 'J') {
            junkRemaining--;
            gainedScore = 1;
        }
        grid[prevX][prevY] = '.';
        grid[ship.getX()][ship.getY()] = 'S';
        return gainedScore;
    }

    public void printGrid() {
        System.out.println("\nGrille :");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
        System.out.println("Junk left : " + junkRemaining);
    }
}
package org.game;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Grid {
    private final int size;
    private final Ship ship;
    ArrayList<List<Character>> grid = new ArrayList<>();
    public Grid(int size, Ship ship) {
        this.size = size;
        this.ship = ship;
    }
    public void initializeGrid(Ship ship) {
        for(int i = 0; i < size; i++){
            List<Character> gridLine = new ArrayList<>();
            for(int j = 0; j < size; j++){
                gridLine.add('.');
            }
            grid.add(gridLine);
        }
    }
    public void printGrid() {
        for(List<Character> line : grid) {
            System.out.println(line.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

    public static void main(String[] args) {
        Grid grid1 = new Grid(5, new Ship(2, 2));
        grid1.initializeGrid(new Ship(2, 2));
        grid1.printGrid();
    }
}
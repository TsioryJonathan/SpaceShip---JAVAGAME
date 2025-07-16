package org.game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Ship {
    private int x;
    private int y;

    public boolean move(String direction, int size) {
        int newX = x;
        int newY = y;

        switch (direction) {
            case "U": newX--; break;
            case "D": newX++; break;
            case "L": newY--; break;
            case "R": newY++; break;
        }

        if (newX >= 0 && newX < size && newY >= 0 && newY < size) {
            x = newX;
            y = newY;
            return true;
        } else {
            System.out.println("Invalid move!");
            return false;
        }
    }
}

package org.game;

import java.util.Scanner;

public class SpaceJunkGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter grid size : ");
        int size = scanner.nextInt();
        scanner.nextLine();

        final int MAX_MOVES = 20;
        int moves = 0;
        int score = 0;

        Ship ship = new Ship(0,0);
        Grid grid = new Grid(ship, size);

        while (grid.getJunkRemaining() > 0 && moves < MAX_MOVES) {
            grid.printGrid();
            System.out.println("Score : " + score + " | Move left : " + (MAX_MOVES - moves));
            System.out.print("Enter a direction (U, D, L, R) : ");
            String direction = scanner.nextLine().trim().toUpperCase();

            int prevX = ship.getX();
            int prevY = ship.getY();

            if (ship.move(direction, grid.getSize())) {
                int gained = grid.updatePosition(ship, prevX, prevY);
                score += gained;
                moves++;
            } else {
                System.out.println("Invalid move!");
            }
        }
        System.out.println("\nGame ended");
        grid.printGrid();
        System.out.println("Score final : " + score + "/" + Math.max(3, size));
        if (grid.getJunkRemaining() == 0)
            System.out.println("You won !");
        else
            System.out.println("You lost!");
        scanner.close();
    }
}

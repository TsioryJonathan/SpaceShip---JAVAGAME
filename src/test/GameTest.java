package org.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShipGridTest {
    private Ship ship;
    private Grid grid;

    @BeforeEach
    void setup() {
        ship = new Ship(0, 0);
        grid = new Grid(ship, 4); // 4x4 grid
    }

    @Test
    void testValidMovement() {
        assertTrue(ship.move("D", 4)); // Move down
        assertEquals(1, ship.getX());
        assertEquals(0, ship.getY());

        assertTrue(ship.move("R", 4)); // Move right
        assertEquals(1, ship.getX());
        assertEquals(1, ship.getY());
    }

    @Test
    void testInvalidMovement_OutOfBounds() {
        assertFalse(ship.move("U", 4)); // Already at top edge
        assertEquals(0, ship.getX());

        assertFalse(ship.move("L", 4)); // Already at left edge
        assertEquals(0, ship.getY());
    }

    @Test
    void testGridInitialJunkCount() {
        int junk = grid.getInitialJunkCount();
        assertTrue(junk >= 3); // At least 3 junk
        assertEquals(junk, grid.getJunkRemaining());
    }

    @Test
    void testCollectJunk() {
        // simulate collecting a junk manually
        int prevX = ship.getX();
        int prevY = ship.getY();

        // Place a junk right next to ship
        int targetX = prevX + 1;
        int targetY = prevY;
        grid.updatePosition(new Ship(targetX, targetY), prevX, prevY); // simulate update

        ship = new Ship(targetX, targetY); // move ship to junk manually
        int gained = grid.updatePosition(ship, prevX, prevY);
        assertEquals(1, gained);
        assertEquals(grid.getInitialJunkCount() - 1, grid.getJunkRemaining());
    }
}
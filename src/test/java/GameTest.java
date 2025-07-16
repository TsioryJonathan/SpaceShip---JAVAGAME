import org.game.Grid;
import org.game.Ship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShipGridTest {
    private Ship ship;
    private Grid grid;

    @BeforeEach
    void setup() {
        ship = new Ship(0, 0);
        grid = new Grid(ship, 4);
    }

    @Test
    void testValidMovement() {
        assertTrue(ship.move("D", 4));
        assertEquals(1, ship.getX());
        assertEquals(0, ship.getY());

        assertTrue(ship.move("R", 4));
        assertEquals(1, ship.getX());
        assertEquals(1, ship.getY());
    }

    @Test
    void testInvalidMovement_OutOfBounds() {
        assertFalse(ship.move("U", 4));
        assertEquals(0, ship.getX());

        assertFalse(ship.move("L", 4));
        assertEquals(0, ship.getY());
    }


}
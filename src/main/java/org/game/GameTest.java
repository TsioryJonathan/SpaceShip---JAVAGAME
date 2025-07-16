package SpaceShip---JAVAGAME.src.main.java.org.game;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testSimpleMoveAndCollect() {
        char[][] grid = {
            {'S', 'J'}
        };

        SpaceJunkGame game = new SpaceJunkGame(grid);

        boolean moved = game.move("right"); // Vers la case "J"

        assertTrue(moved, "Le déplacement doit réussir.");
        assertEquals(1, game.getItemsCollected(), "Un objet doit être collecté.");
        assertEquals(19, game.getMovesLeft(), "Il doit rester 19 déplacements.");
        assertEquals('S', game.getGrid()[0][1], "Le joueur doit être sur la case (0,1).");
    }
}

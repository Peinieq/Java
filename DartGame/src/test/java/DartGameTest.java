import game.DartGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DartGameTest {
    DartGame dartGame;

    @Before
    public void setUp() {
        dartGame = new DartGame("Jackson", "Json");
        Assert.assertNotNull(dartGame);
    }

    @Test
    public void shouldReturnStartValues() {
        Assert.assertEquals(501, dartGame.getFirstPlayerPoints());
        Assert.assertEquals(501, dartGame.getSecondPlayerPoints());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgExByBadMultiplicity() {
        dartGame.shoot(1,5, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgExByBadValue() {
        dartGame.shoot(30, 1, 1);
    }

    @Test
    public void shouldFirstPlayerWonAndRestartGame() {
        dartGame.shoot(20, 1, 1);
        dartGame.shoot(20, 1, 2);
        dartGame.shoot(20, 3, 2);
        dartGame.shoot(20, 3, 2);
        dartGame.shoot(20, 3, 2);
        dartGame.shoot(20, 3, 2);
        dartGame.shoot(20, 3, 2);
        dartGame.shoot(20, 3, 2);
        dartGame.shoot(20, 3, 2);
        dartGame.shoot(20, 3, 2);
        dartGame.shoot(2,1,2);
        dartGame.shoot(1,1,2);

        dartGame.shoot(20, 3, 1);
        dartGame.shoot(20, 3, 1);
        dartGame.shoot(20, 3, 1);
        dartGame.shoot(20, 3, 1);
        dartGame.shoot(20, 3, 1);
        dartGame.shoot(20, 3, 1);
        dartGame.shoot(20, 3, 1);
        dartGame.shoot(20, 3, 1);
        Assert.assertEquals(dartGame.getFirstPlayerName() + " is won!",
                dartGame.shoot(2,1,1));
        Assert.assertEquals(DartGame.getStartPoints(), dartGame.getSecondPlayerPoints());

    }



}

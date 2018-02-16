package DartGameFirst;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class DartGameTest {

    private DartGame game = new DartGame();

    @Test
    public void shootTest() {
        assertNotNull(game);
        game.shoot(2, 3,1);
        assertEquals(495, game.getFirstPlayerPoints());
    }
    @Test
    public void checkWinTest(){
        game.shoot(50,3,1);
        game.shoot(50,3,1);
        game.shoot(50,3,1);
        game.shoot(50,1,1);
        game.shoot(1,1,1);

        assertEquals(game.getFirstPlayerPoints(),501);
        assertEquals(game.getSecondPlayerPoints(),501);

    }
    @Test
    public void shootMultiplicityIllegalArgumentExceptionTest(){
        try{
            game.shoot(50,4,1);
        }catch(IllegalArgumentException e){
            assertTrue(e.getMessage().contains("Multiplicity"));
        }
    }
    @Test
    public void shootIllegalArgumentExceptionTest(){
        try {
            game.shoot(200, 3, 1);
        }catch(IllegalArgumentException e){
            assertTrue(e.getMessage().contains("Value"));
        }
    }
}

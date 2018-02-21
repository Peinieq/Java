package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PositionTest {

    Position position;

    @Before
    public void setup() {
        position = new Position();

        Assert.assertNotNull(position);
    }

    @Test
    public void shouldReturnSetValues() {
        position.setPosX(1);
        position.setPosY(2);
        position.setPosZ(3);

        Assert.assertEquals(1, position.getPosX());
        Assert.assertEquals(2, position.getPosY());
        Assert.assertEquals(3, position.getPosZ());
    }
}

package domain;

import enums.TypeOfPackage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class PackageTest {

    private Package pack;


    @Before
    public void initializePackage() {
        pack = new Package("1",2, TypeOfPackage.CARPARTS);

        Assert.assertNotNull(pack);
        Assert.assertEquals("1", pack.getId());
        Assert.assertEquals(2, pack.getPriority());
        Assert.assertEquals(TypeOfPackage.CARPARTS, pack.getType());
    }

   @Test
    public void shouldReturnSetValues() {
        // Given
       Position position = new Position(1,2,3);
       Date currentDate = new Date();
       String description = "test description";
       int countOfMoves = 3;

       // When
       pack.setPosition(position);
       pack.setAddedDate(currentDate);
       pack.setDescription(description);
       pack.setCountOfMoves(countOfMoves);

       // Then
       Assert.assertEquals(position, pack.getPosition());
       Assert.assertEquals(currentDate, pack.getAddedDate());
       Assert.assertEquals("test description", pack.getDescription());
       Assert.assertEquals(3, pack.getCountOfMoves());
   }





}

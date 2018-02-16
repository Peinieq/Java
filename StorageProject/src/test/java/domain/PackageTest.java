package domain;

import enums.TypeOfPackage;
import org.junit.Assert;
import org.junit.Test;

public class PackageTest {

    @Test
    public void initializePackage() {
        Package pack = new Package("1",2, TypeOfPackage.CARPARTS);
        Assert.assertNotNull(pack);
    }
}

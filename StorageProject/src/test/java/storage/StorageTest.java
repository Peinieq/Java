package storage;

import domain.Package;
import enums.TypeOfPackage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StorageTest {
    private Storage storage = Storage.StorageProvider.INSTANCE.getStorageInstance(3,3,3);

    @Before
    public void shouldSetOnlyOneInstance() {
        Storage storageTwo = Storage.StorageProvider.INSTANCE.getStorageInstance(2,2,2);

        Assert.assertNotNull(storage);
        Assert.assertNotNull(storageTwo);
        Assert.assertTrue(storage == storageTwo);
    }

    @Before
    public void shouldAddNewPackages() {
        Assert.assertTrue(storage.addPackage(new Package("1", 3, TypeOfPackage.TOYS), 0, 0));
        Assert.assertTrue(storage.addPackage(new Package( "2",2, TypeOfPackage.TOYS), 0, 0));
        Assert.assertTrue(storage.addPackage(new Package( "5",1, TypeOfPackage.CARPARTS), 0, 1));
        Assert.assertTrue(storage.addPackage(new Package( "3",1, TypeOfPackage.TOYS), 1, 0));
        Assert.assertTrue(storage.addPackage(new Package( "6",1, TypeOfPackage.TOYS), 1, 1));
    }

    @Test
    public void shouldNotAllowToAddNewPackage() {
        storage.addPackage(new Package("7", 1, TypeOfPackage.TOYS), 0, 0);
        Assert.assertFalse(storage.addPackage(new Package("7", 4, TypeOfPackage.TOYS), 0, 0));
        Assert.assertFalse(storage.addPackage(new Package("8", 3, TypeOfPackage.TOYS), 0, 0));
        Assert.assertFalse(storage.addPackage(new Package("9", 1, TypeOfPackage.TOYS), 0, 0));

    }

    @Test
    public void shouldReturnProperStateOfStorage() {
        String stateOfStorage = storage.getStateOfStorage();
        System.out.println(stateOfStorage);
        Assert.assertTrue(stateOfStorage.contains("Package: id='1', priority=3, position= posX=0, posY=0, posZ=0"));
        Assert.assertTrue(stateOfStorage.contains("Package: id='2', priority=2, position= posX=0, posY=1, posZ=0"));
        Assert.assertTrue(stateOfStorage.contains("Package: id='5', priority=1, position= posX=0, posY=0, posZ=1"));
        Assert.assertTrue(stateOfStorage.contains("Package: id='5', priority=1, position= posX=0, posY=0, posZ=1"));
        Assert.assertTrue(stateOfStorage.contains("Package: id='6', priority=1, position= posX=1, posY=0, posZ=1"));
    }

    @Test
    public void shouldReturnPackageById() {
        String id = "2";

        Package searchedPackage = storage.getPackageByNumber(id);

        Assert.assertEquals(id, searchedPackage.getId());
    }

    @Test
    public void shouldReturnAllPackagesByType() {
        TypeOfPackage type = TypeOfPackage.TOYS;

        List<Package> results = storage.getAllPackagesByType(type);
        boolean areProperType = results.stream().allMatch(e -> e.getType().equals(type));

        Assert.assertTrue(areProperType);

    }

}

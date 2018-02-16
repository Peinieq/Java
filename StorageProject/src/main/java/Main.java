import domain.Package;
import enums.TypeOfPackage;
import storage.Storage;

public class Main {
    public static void main(String... args) {
        Storage storage = Storage.StorageProvider.INSTANCE.getStorageInstance(4,4,4);
        storage.addPackage(new Package("1", 2, TypeOfPackage.TOYS), 0, 0);
        storage.addPackage(new Package( "2",1, TypeOfPackage.TOYS), 0, 0);
        storage.addPackage(new Package( "5",2, TypeOfPackage.TOYS), 0, 1);
        storage.addPackage(new Package( "3",3, TypeOfPackage.TOYS), 0, 0);
        storage.getAllPackagesByType(TypeOfPackage.TOYS);
        System.out.println(storage.getStateOfStorage());

        System.out.println("Wynik " + storage.getPackageByNumber("2"));
        System.out.println(storage.getStateOfStorage());

    }
}

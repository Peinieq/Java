import domain.Package;
import enums.TypeOfPackage;
import storage.Storage;

public class Main {
    public static void main(String... args) {

        Storage storage = Storage.StorageProvider.INSTANCE.getStorageInstance(2,3,2);
        Storage storage2 = Storage.StorageProvider.INSTANCE.getStorageInstance(2,3,2);
        storage.addPackage(new Package("1", 3, TypeOfPackage.TOYS), 0, 0);
        storage.addPackage(new Package( "2",2, TypeOfPackage.TOYS), 0, 0);
        storage.addPackage(new Package( "5",1, TypeOfPackage.CARPARTS), 0, 1);
        storage.addPackage(new Package( "3",1, TypeOfPackage.TOYS), 1, 0);
        storage.addPackage(new Package( "6",1, TypeOfPackage.TOYS), 1, 1);

        //System.out.println(storage.getAllPackagesByType(TypeOfPackage.CARPARTS));
//        System.out.println(storage.getStateOfStorage());
//
        System.out.println("Wynik " + storage.getPackageByNumber("2"));
        System.out.println(storage.getStateOfStorage());

    }
}

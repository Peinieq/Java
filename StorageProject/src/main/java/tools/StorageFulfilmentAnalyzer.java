package tools;

public class  StorageFulfilmentAnalyzer {
    private static final double MAX_FULFILMENT = 60;

    private static long STORAGE_CAPACITY = 0;
    private static long numberOfPackages = 0;
    private static double actualFulfilment = 0;

    public static void setStorageCapacity(int value) {
        STORAGE_CAPACITY = value;
    }

    public static double getActualFulfilment() {
        return actualFulfilment;
    }

    public static void incrementNumberOfPackages() {
        ++numberOfPackages;
        changeActualFulfilment();
    }

    public static void decrementNumberOfPackages() {
        --numberOfPackages;
        changeActualFulfilment();
    }

    private static void changeActualFulfilment() {
        actualFulfilment = (numberOfPackages / STORAGE_CAPACITY) * 100.0;
    }

    public static boolean canAddNewPackage() {
        double newFulfilment = (numberOfPackages + 1) / STORAGE_CAPACITY * 100;
        if(newFulfilment < MAX_FULFILMENT) {
            return true;
        }
        return false;
    }

    private StorageFulfilmentAnalyzer() {

    }
}

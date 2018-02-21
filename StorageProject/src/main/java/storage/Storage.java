package storage;

import domain.Package;
import domain.Position;
import enums.TypeOfPackage;
import tools.StorageFulfilmentAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Storage {
    private static final Logger logger = Logger.getLogger(Storage.class.getName());
    private final int X;
    private final int Y;
    private final int Z;

    private ArrayList<Package>[][] packages;
    private HashMap<String, Position> idPositionMap;

    private Storage(int x, int y, int z) {
        this.X = x;
        this.Y = y;
        this.Z = z;
        initializePackages();
        idPositionMap = new HashMap<String, Position>();
        StorageFulfilmentAnalyzer.setStorageCapacity(X * Y * Z);
    }

    private void initializePackages() {
        packages = new ArrayList[X][Z];
        for (int posX = 0; posX < X; ++posX) {
            initializeColumnZ(posX);
        }
    }

    private void initializeColumnZ(int posX) {
        for (int posZ = 0; posZ < Z; posZ++) {
            packages[posX][posZ] = new ArrayList<Package>(Y);
        }
    }

    public boolean addPackage(Package pack, int posX, int posZ) {
        if (StorageFulfilmentAnalyzer.canAddNewPackage()) {
            return packageAdded(pack, posX, posZ);
        }
        return false;
    }

    private boolean packageAdded(Package pack, int posX, int posZ) {
        ArrayList<Package> currentColumn = packages[posX][posZ];
        if (currentColumn.isEmpty() ||
                (currentColumn.size() < Y && currentColumn.get(currentColumn.size() - 1).compareTo(pack) <= 0)) {
            currentColumn.add(pack);
            pack.setPosition(new Position(posX, currentColumn.size() - 1, posZ));
            idPositionMap.put(pack.getId(), pack.getPosition());
            StorageFulfilmentAnalyzer.incrementNumberOfPackages();
            return true;
        }
        return false;
    }

    public Package getPackageByNumber(String packageNumber) {
        int aimPosX = idPositionMap.get(packageNumber).getPosX();
        int aimPosZ = idPositionMap.get(packageNumber).getPosZ();
        Package resultPackage = packages[aimPosX][aimPosZ].get(packages[aimPosX][aimPosZ].size() - 1);
        prepareStorageToGetProperPackage(resultPackage, packageNumber, aimPosX, aimPosZ);
        packages[aimPosX][aimPosZ].remove(packages[aimPosX][aimPosZ].size() - 1);
        StorageFulfilmentAnalyzer.decrementNumberOfPackages();
        return resultPackage;
    }

    private void prepareStorageToGetProperPackage(Package resultPackage, String packageNumber, int aimPosX, int aimPosZ) {
        int currentIndex = packages[aimPosX][aimPosZ].size() - 1;
        while (!resultPackage.getId().equals(packageNumber)) {
            if (canChangeLocationOfActualPackage(resultPackage, aimPosX, aimPosZ)) {
                packages[aimPosX][aimPosZ].remove(resultPackage);
                currentIndex--;
                resultPackage = packages[aimPosX][aimPosZ].get(currentIndex);
            } else {
                popAndAddPackagesToOtherColumns(aimPosX, aimPosZ);
            }
        }
    }

    private void popAndAddPackagesToOtherColumns(int aimPosX, int aimPosZ) {
        for (int posX = 0; posX < X; posX++) {
            isPackedInsertedToColumnZ(posX, aimPosX, aimPosZ);
        }
    }

    private void isPackedInsertedToColumnZ(int posX, int aimPosX, int aimPosZ) {
        ArrayList<Package> currentColumn;
        for (int posZ = 0; posZ < Z; posZ++) {
            currentColumn = packages[posX][posZ];
            if (posX != aimPosX && posZ != aimPosZ
                    && canChangeLocationOfActualPackage(currentColumn.get(currentColumn.size() - 1), aimPosX, aimPosZ)) {
                currentColumn.remove(currentColumn.size() - 1);
                return;
            }
        }
    }

    private boolean canChangeLocationOfActualPackage(Package currentPackage, int notPosX, int notPoZ) {
        for (int posX = 0; posX < X; posX++) {
            isLocationOfPackageChangedInColumnZ(posX, currentPackage, notPosX, notPoZ);
        }
        return false;
    }

    private boolean isLocationOfPackageChangedInColumnZ(int posX, Package currentPackage, int notPosX, int notPoZ) {
        for (int posZ = 0; posZ < Z; posZ++) {
            if((currentPackage.getPosition().getPosX() != posX || currentPackage.getPosition().getPosZ() != posZ)
                    && (posX != notPosX || posZ != notPoZ) ) {
                Position newPosition = new Position(posX, packages[posX][posZ].size() - 1, posZ);
                return isPackageInserted(packages[posX][posZ], currentPackage, newPosition);
            }
        }
        return false;
    }

    private boolean isPackageInserted(ArrayList<Package> currentColumn, Package currentPackage, Position newPosition) {
        if (currentColumn.isEmpty()) {
            addPackageToNewColumn(currentColumn, currentPackage, newPosition);
            return true;
        } else if (currentColumn.size() < Y) {
            if(currentColumn.get(currentColumn.size() - 1).compareTo(currentPackage) < 1) {
                addPackageToNewColumn(currentColumn, currentPackage, newPosition);
                return true;
            }
        }
        return false;
    }

    private void addPackageToNewColumn(ArrayList<Package> currentColumn, Package currentPackage, Position newPosition) {
        currentColumn.add(currentPackage);
        currentPackage.setPosition(newPosition);
        currentPackage.incrementCountOfMoves();
    }

    public List<Package> getAllPackagesByType(TypeOfPackage type) {
        ArrayList<Package> resultList = new ArrayList<Package>();
        Position position;
        Package pack;
        for (HashMap.Entry<String, Position> entry : idPositionMap.entrySet()) {
            position = entry.getValue();
            pack = packages[position.getPosX()][position.getPosZ()].get(position.getPosY());
            if (pack != null && type == pack.getType()) {
                resultList.add(pack);
            }
        }
        return resultList;
    }

    public String getStateOfStorage() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int posX = 0; posX < X; ++posX) {
            stringBuilder.append(getStateOfSingleRow(posX));
        }
        return stringBuilder.toString();
    }

    private String getStateOfSingleRow(int posX) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int posZ = 0; posZ < Z; ++posZ) {
            stringBuilder.append((packages[posX][posZ] + "\n").replaceAll("\\[", "").replaceAll("\\]",""));
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public enum StorageProvider {
        INSTANCE;

        private Storage storageInstance = null;

        public Storage getStorageInstance(int x, int y, int z) {
            if(storageInstance == null) {
                storageInstance = new Storage(x, y, z);
            }
            return storageInstance;
        }
    }
}

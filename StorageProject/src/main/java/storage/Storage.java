package storage;

import domain.Package;
import domain.Position;
import enums.TypeOfPackage;
import tools.StorageFulfilmentAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class Storage {
    private static final Logger logger = Logger.getLogger(Storage.class.getName());
    private final int X;
    private final int Y;
    private final int Z;

    private ArrayList<Package>[][] packages;
    private HashMap<String, Position> idPositionMap;
    private ArrayList<String> idPositionSpecTypePacksMap;

    private Storage(int x, int y, int z) {
        this.X = x;
        this.Y = y;
        this.Z = z;
        initializePackages();
        idPositionMap = new HashMap<String, Position>();
        idPositionSpecTypePacksMap = new ArrayList<String>();
        StorageFulfilmentAnalyzer.setStorageCapacity(X * Y * Z);
    }

    private void initializePackages() {
        packages = new ArrayList[X][Z];
        for (int posX = 0; posX < X; ++posX) {
            initializeColumnZ(posX);
        }
    }

    private void initializeColumnZ(int posX) {
        for (int posZ = 0; posZ < Z; ++posZ) {
            packages[posX][posZ] = new ArrayList<Package>(Y);
        }
    }

    public boolean addPackage(Package pack, int posX, int posZ) {
        if (StorageFulfilmentAnalyzer.canAddNewPackage()) {
            ArrayList<Package> currentColumn = packages[posX][posZ];
            if (currentColumn.isEmpty() ||
                    (currentColumn.size() < Z && currentColumn.get(currentColumn.size() - 1).compareTo(pack) <= 0)) {
                currentColumn.add(pack);
                pack.setPosition(new Position(posX, currentColumn.size() - 1, posZ));
                idPositionMap.put(pack.getId(), pack.getPosition());
                return true;
            }
        }
        return false;
    }

    public Package getPackageByNumber(String packageNumber) {
        int aimPosX = idPositionMap.get(packageNumber).getPosX();
        int aimPosZ = idPositionMap.get(packageNumber).getPosZ();
        ArrayList<Package> aimColumn = packages[aimPosX][aimPosZ];
        int currentIndex = aimColumn.size() - 1;
        Package resultPackage = aimColumn.get(currentIndex);
        while (!resultPackage.getId().equals(packageNumber)) {
            if(changeLocationOfActualPackage(resultPackage)) {
                aimColumn.remove(resultPackage);
                currentIndex--;
                resultPackage = aimColumn.get(currentIndex);
            }
        }
        return resultPackage;
    }

    private boolean changeLocationOfActualPackage(Package currentPackage) {
        ArrayList<Package> currentColumn = null;
        for (int posX = 0; posX < X; posX++) {
            for (int posZ = 0; posZ < Z; posZ++) {
                if(currentPackage.getPosition().getPosX() != posX || currentPackage.getPosition().getPosZ() != posZ) {
                    currentColumn = packages[posX][posZ];
                    if(!currentColumn.isEmpty() && currentColumn.size() < Z) {
                        if(currentColumn.get(currentColumn.size() - 1).compareTo(currentPackage) <= 0) {
                            packages[posX][posZ].add(currentPackage);
                            currentPackage.setPosition(new Position(posX, currentColumn.size() - 1, posZ));
                            currentPackage.incrementCountOfMoves();
                            return true;
                        }
                    } else if(currentColumn.isEmpty()) {
                        packages[posX][posZ].add(currentPackage);
                        currentPackage.setPosition(new Position(posX, currentColumn.size() - 1, posZ));
                        currentPackage.incrementCountOfMoves();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<Package> getAllPackagesByType(TypeOfPackage type) {
        ArrayList resultList = new ArrayList();
        if(idPositionSpecTypePacksMap.isEmpty()){
            findAllPackagesByType(type);
        }
        return resultList;
    }

    private void findAllPackagesByType(TypeOfPackage type) {
        Position position;
        Package pack;
        for(HashMap.Entry<String, Position> entry : idPositionMap.entrySet()) {
            position = entry.getValue();
            pack = packages[position.getPosX()][position.getPosZ()].get(position.getPosY());
            if(pack != null && type == pack.getType()) {
                idPositionSpecTypePacksMap.add(pack.getId());
            }
        }
    }

    public String getStateOfStorage() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int posX = 0; posX < X; ++posX) {
            for (int posZ = 0; posZ < Z; ++posZ) {
                    stringBuilder.append((packages[posX][posZ] + "\n").
                            replaceAll("\\[", "").replaceAll("\\]",""));
            }
        }
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

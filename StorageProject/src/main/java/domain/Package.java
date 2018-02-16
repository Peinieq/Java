package domain;

import enums.TypeOfPackage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Package implements Comparable<Package>{
    private String id;
    private int priority;
    private TypeOfPackage type;
    private String description;
    private Date addedDate;
    private int countOfMoves;
    private Position position;
    private ArrayList<Position> historyOfMoves;

//    private Package(PackageBuilder builder) {
//        this.id = builder.id;
//        this.priority = builder.priority;
//        this.type = builder.type;
//        this.description = builder.description;
//        this.addedDate = builder.addedDate;
//        this.countOfMoves = builder.countOfMoves;
//    }

    public Package(int priority, TypeOfPackage type) {
        this.id = UUID.randomUUID().toString();
        this.priority = priority;
        this.type = type;
        addedDate = new Date();
        historyOfMoves = new ArrayList<Position>();
    }

    public Package(String id, int priority, TypeOfPackage type) {
        this.id = id;
        this.priority = priority;
        this.type = type;
        addedDate = new Date();
        historyOfMoves = new ArrayList<Position>();
    }

    public String getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public TypeOfPackage getType() {
        return type;
    }

    public void setType(TypeOfPackage type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAddedDate() {
        return (Date) addedDate.clone();
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public int getCountOfMoves() {
        return countOfMoves;
    }

    public void setCountOfMoves(int countOfMoves) {
        this.countOfMoves = countOfMoves;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ArrayList<Position> getHistoryOfMoves() {
        return historyOfMoves;
    }

    public void setHistoryOfMoves(ArrayList<Position> historyOfMoves) {
        this.historyOfMoves = historyOfMoves;
    }

    public void incrementCountOfMoves() {
        ++countOfMoves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        if (priority != aPackage.priority) return false;
        if (countOfMoves != aPackage.countOfMoves) return false;
        if (id != null ? !id.equals(aPackage.id) : aPackage.id != null) return false;
        if (type != aPackage.type) return false;
        if (description != null ? !description.equals(aPackage.description) : aPackage.description != null)
            return false;
        if (addedDate != null ? !addedDate.equals(aPackage.addedDate) : aPackage.addedDate != null) return false;
        if (position != null ? !position.equals(aPackage.position) : aPackage.position != null) return false;
        return historyOfMoves != null ? historyOfMoves.equals(aPackage.historyOfMoves) : aPackage.historyOfMoves == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + priority;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (addedDate != null ? addedDate.hashCode() : 0);
        result = 31 * result + countOfMoves;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (historyOfMoves != null ? historyOfMoves.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id='" + id + '\'' +
                ", priority=" + priority +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", addedDate=" + addedDate +
                ", countOfMoves=" + countOfMoves +
                ", position=" + position +
                '}';
    }

    public int compareTo(Package aPackage) {
        if(priority < aPackage.priority) {
            return 1;
        } else if(priority > aPackage.priority) {
            return -1;
        }
        return 0;
    }

//    public static class PackageBuilder {
//        private final String id;
//        private final int priority;
//        private final TypeOfPackage type;
//        private String description;
//        private Date addedDate;
//        private int countOfMoves;
//        private ArrayList<Package> setHistoryOfMoves;
//
//        public PackageBuilder(String id, int priority, TypeOfPackage type) {
//            this.id = id;
//            this.priority = priority;
//            this.type = type;
//            addedDate = new Date();
//        }
//
//        public PackageBuilder withDescription(String description) {
//            this.description = description;
//            return this;
//        }
//
//        public PackageBuilder withAddedDate(Date addedDate) {
//            this.addedDate = addedDate;
//            return this;
//        }
//
//        public PackageBuilder wihCountOfMoves(int countOfMoves) {
//            this.countOfMoves = countOfMoves;
//            return this;
//        }
//
//        public PackageBuilder withHistoryOfMoves(ArrayList<Package> historyOfMoves) {
//            this.setHistoryOfMoves = historyOfMoves;
//            return this;
//        }
//
//        public Package build() {
//            if(priority < 1 || priority > 3) {
//                throw new IllegalStateException("Priority out of range");
//            }
//            return new Package(this);
//        }
//    }

}

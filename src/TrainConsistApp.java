import java.util.*;
import java.util.stream.*;

abstract class Bogie {
    private String bogieId;
    private String bogieType;

    public Bogie(String bogieId, String bogieType) {
        this.bogieId = bogieId;
        this.bogieType = bogieType;
    }

    public String getBogieId() {
        return bogieId;
    }

    public String getBogieType() {
        return bogieType;
    }

    public abstract void displayDetails();
}

class PassengerBogie extends Bogie {
    private int seatCapacity;

    public PassengerBogie(String bogieId, String bogieType, int seatCapacity) {
        super(bogieId, bogieType);
        this.seatCapacity = seatCapacity;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void displayDetails() {
        System.out.println("Passenger Bogie ID: " + getBogieId() + ", Type: " + getBogieType() + ", Seats: " + seatCapacity);
    }
}

class GoodsBogie extends Bogie {
    private String shapeType;
    private String cargoType;

    public GoodsBogie(String bogieId, String bogieType, String shapeType, String cargoType) {
        super(bogieId, bogieType);
        this.shapeType = shapeType;
        this.cargoType = cargoType;
    }

    public void displayDetails() {
        System.out.println("Goods Bogie ID: " + getBogieId() + ", Type: " + getBogieType() + ", Shape: " + shapeType + ", Cargo: " + cargoType);
    }
}

class TrainConsist {
    private List<Bogie> bogies = new ArrayList<>();

    public void addBogie(Bogie bogie) {
        bogies.add(bogie);
    }

    public int countTotalSeats() {
        return bogies.stream()
                .filter(b -> b instanceof PassengerBogie)
                .map(b -> (PassengerBogie) b)
                .map(PassengerBogie::getSeatCapacity)
                .reduce(0, Integer::sum);
    }

    public void displayAllBogies() {
        for (Bogie bogie : bogies) {
            bogie.displayDetails();
        }
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        TrainConsist train = new TrainConsist();

        train.addBogie(new PassengerBogie("P101", "Sleeper", 72));
        train.addBogie(new PassengerBogie("P102", "AC Chair", 60));
        train.addBogie(new PassengerBogie("P103", "First Class", 30));
        train.addBogie(new PassengerBogie("P104", "Sleeper", 72));
        train.addBogie(new GoodsBogie("G201", "Goods", "Rectangular", "Coal"));
        train.addBogie(new GoodsBogie("G202", "Goods", "Cylindrical", "Oil"));

        train.displayAllBogies();
        System.out.println("Total Seats in Train: " + train.countTotalSeats());
    }
}
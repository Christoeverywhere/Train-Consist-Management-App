class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    private String bogieType;
    private int seatCapacity;

    public PassengerBogie(String bogieType, int seatCapacity) throws InvalidCapacityException {
        if (seatCapacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.bogieType = bogieType;
        this.seatCapacity = seatCapacity;
    }

    public String getBogieType() {
        return bogieType;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        try {
            PassengerBogie bogie1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Passenger Bogie Created Successfully");
            System.out.println("Bogie Type: " + bogie1.getBogieType());
            System.out.println("Seat Capacity: " + bogie1.getSeatCapacity());

            PassengerBogie bogie2 = new PassengerBogie("AC Chair", 0);
            System.out.println("Passenger Bogie Created Successfully");
            System.out.println("Bogie Type: " + bogie2.getBogieType());
            System.out.println("Seat Capacity: " + bogie2.getSeatCapacity());
        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
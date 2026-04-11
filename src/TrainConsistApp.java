class UnsafeCargoException extends Exception {
    public UnsafeCargoException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String bogieType;
    private String cargoType;

    public GoodsBogie(String bogieType) {
        this.bogieType = bogieType;
    }

    public void assignCargo(String cargoType) throws UnsafeCargoException {
        if (bogieType.equalsIgnoreCase("Rectangular") && cargoType.equalsIgnoreCase("Petroleum")) {
            throw new UnsafeCargoException("Unsafe cargo assignment: Petroleum cannot be assigned to Rectangular bogie");
        }
        this.cargoType = cargoType;
        System.out.println("Cargo assigned successfully");
    }

    public String getBogieType() {
        return bogieType;
    }

    public String getCargoType() {
        return cargoType;
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        try {
            bogie.assignCargo("Petroleum");
        } catch (UnsafeCargoException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("Cargo assignment process completed");
        }
    }
}
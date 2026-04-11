import java.util.ArrayList;
import java.util.List;

class GoodsBogie {
    private String bogieType;
    private String cargoType;

    public GoodsBogie(String bogieType, String cargoType) {
        this.bogieType = bogieType;
        this.cargoType = cargoType;
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
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        for (int i = 1; i <= 100000; i++) {
            if (i % 5 == 0) {
                goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
            } else {
                goodsBogies.add(new GoodsBogie("Open", "Coal"));
            }
        }

        long startLoop = System.nanoTime();

        boolean loopResult = true;
        for (GoodsBogie bogie : goodsBogies) {
            if (bogie.getBogieType().equalsIgnoreCase("Cylindrical") &&
                    !bogie.getCargoType().equalsIgnoreCase("Petroleum")) {
                loopResult = false;
                break;
            }
        }

        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();

        boolean streamResult = goodsBogies.stream()
                .allMatch(bogie -> !bogie.getBogieType().equalsIgnoreCase("Cylindrical")
                        || bogie.getCargoType().equalsIgnoreCase("Petroleum"));

        long endStream = System.nanoTime();

        System.out.println("Loop Validation Result: " + loopResult);
        System.out.println("Loop Execution Time (ns): " + (endLoop - startLoop));
        System.out.println("Stream Validation Result: " + streamResult);
        System.out.println("Stream Execution Time (ns): " + (endStream - startStream));
    }
}
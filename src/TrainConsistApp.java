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

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        boolean isSafetyCompliant = goodsBogies.stream()
                .allMatch(bogie -> !bogie.getBogieType().equalsIgnoreCase("Cylindrical")
                        || bogie.getCargoType().equalsIgnoreCase("Petroleum"));

        if (isSafetyCompliant) {
            System.out.println("Train is safety compliant");
        } else {
            System.out.println("Train is NOT safety compliant");
        }
    }
}
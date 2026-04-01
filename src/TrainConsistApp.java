import java.util.LinkedList;

public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        LinkedList<String> trainConsist = new LinkedList<>();

        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial train consist: " + trainConsist);

        trainConsist.add(2, "Pantry Car");

        System.out.println("After inserting Pantry Car: " + trainConsist);

        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("Final ordered train consist: " + trainConsist);
    }
}
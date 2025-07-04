package bems.utility;

public class IDGenerator {
    private static int counter = 100;

    public static String generateEmployeeID() {
        return "E" + counter++;
    }
}

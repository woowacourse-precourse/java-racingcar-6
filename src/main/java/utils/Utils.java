package utils;

public class Utils {

    public static String[] splitByDelimiter(String carNames) {
        return carNames.split(",");
    }

    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}

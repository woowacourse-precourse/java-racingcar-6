package utils;

public class Utils {

    public static String[] splitByDelimiter(String carNames, String delimiter) {
        return carNames.split(delimiter);
    }

    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}

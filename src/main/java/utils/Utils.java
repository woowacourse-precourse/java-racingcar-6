package utils;

public class Utils {

    public String[] splitByDelimiter(String carNames) {
        return carNames.split(",");
    }

    public int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}

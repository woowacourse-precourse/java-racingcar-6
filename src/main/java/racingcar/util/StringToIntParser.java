package racingcar.util;

public class StringToIntParser {
    public static int parseToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("String " + string + " is not a number.");
        }
    }
}

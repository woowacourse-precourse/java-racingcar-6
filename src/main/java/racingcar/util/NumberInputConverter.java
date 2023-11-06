package racingcar.util;

public class NumberInputConverter {

    private NumberInputConverter() {
    }

    public static int convert(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }
}

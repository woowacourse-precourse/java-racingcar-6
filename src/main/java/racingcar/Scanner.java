package racingcar;

import java.util.Arrays;
import java.util.List;

public class Scanner {
    public static List<String> extractNames(String line) {
        validateEmpty(line);

        List<String> cars = Arrays.stream(line.split(","))
                        .toList();
        validateRange(cars);
        return cars;
    }

    public static int extractRound(String line) {
        try {
            return Integer.parseInt(line);
        } catch (Exception e) {
            throw new IllegalArgumentException(Printer.NOT_AN_INTEGER_ERROR);
        }
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(Printer.EMPTY_STRING_ERROR);
        }
    }
    private static void validateRange(List<String> names) {
        if (names.stream()
                .map(String::length)
                .max(Integer::compareTo)
                .get() > 5) {
            throw new IllegalArgumentException(Printer.RANGE_ERROR);
        }
    }
}

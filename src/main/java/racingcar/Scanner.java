package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Scanner {
    public static List<String> getNames() {
        String input = Console.readLine();
        validateEmpty(input);

        List<String> cars = Arrays.stream(input.split(","))
                        .toList();
        validateRange(cars);
        return cars;
    }

    public static int getRound() {
        int round;
        try {
            round = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException(Printer.NOT_AN_INTEGER_ERROR);
        }
        return round;
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
                .get() >= 5) {
            throw new IllegalArgumentException(Printer.RANGE_ERROR);
        }
    }
}

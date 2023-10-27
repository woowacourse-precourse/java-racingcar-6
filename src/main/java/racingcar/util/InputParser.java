package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public static int tryCountParser(String input) {
        return Integer.parseInt(input);
    }

    public static List<String> carsParser(String input) {
        String[] cars = input.split(",");
        return Arrays.stream(cars).toList();
    }
}

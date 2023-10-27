package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public int tryCountParser(String input) {
        return Integer.parseInt(input);
    }

    public List<String> carsParser(String input) {
        String[] cars = input.split(",");
        return Arrays.stream(cars).toList();
    }
}

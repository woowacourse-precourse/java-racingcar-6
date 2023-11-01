package racingcar.utils;

import java.util.List;

public class Validator {

    public static void InputRaceCount(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    public static void InputCarName(List<String> cars) {
        if (!InputNameLength(cars)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean InputNameLength(List<String> cars) {
        return cars.stream()
                .noneMatch(name -> name.length() > 5);
    }

}

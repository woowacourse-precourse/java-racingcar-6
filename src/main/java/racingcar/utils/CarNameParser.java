package racingcar.utils;


import java.util.Arrays;
import java.util.List;

public class CarNameParser {
    private static final String CAR_NAME_DELIMITER = ",";

    private CarNameParser() {
    }

    public static List<String> parse(String carNames) {
        return Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
    }
}

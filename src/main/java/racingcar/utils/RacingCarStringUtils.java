package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class RacingCarStringUtils {
    public static List<String> parseCarNamesToList(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }
}

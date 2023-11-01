package racingcar;

import java.util.Arrays;
import java.util.List;

public class Formatter {

    public static List<String> formatCarNames(String carNames) {
        return Arrays.asList(carNames.split(","));
    }

    public static int formatRound(String roundStr) {
        return Integer.parseInt(roundStr);
    }
}

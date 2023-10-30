package racingcar;

import java.util.Arrays;
import java.util.List;

public class Formatter {

    public List<String> formatCarNames(String carNames) {
        return Arrays.asList(carNames.split(","));
    }

    public int formatRound(String roundStr) {
        return Integer.parseInt(roundStr);
    }
}

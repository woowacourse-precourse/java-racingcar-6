package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Converter {
    private static final String DELIMITER = ",";

    public List<String> getCarNames(String inputNames) {
        return Arrays.asList(inputNames.split(DELIMITER));
    }

    public int getAttemptNumber(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }
}

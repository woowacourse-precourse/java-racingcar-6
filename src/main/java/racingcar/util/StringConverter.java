package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.exception.InputValidator;

public class StringConverter {

    private static final String DELIMITER = ",";

    private StringConverter() {
    }

    public static List<String> stringToListByDelimiter(String carNames) {
        InputValidator.validateInputCarNames(carNames);
        return Arrays.stream(carNames.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    public static Integer stringToInteger(String trialCount) {
        InputValidator.validateInputTrialCount(trialCount);
        return Integer.parseInt(trialCount);
    }
}

package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.exception.InputValidator;
import racingcar.vo.CarName;

public class StringConverter {

    private static final String DELIMITER = ",";

    private StringConverter() {
    }

    public static List<CarName> stringToCarNameListByDelimiter(String carNames) {
        InputValidator.validateInputCarNames(carNames);
        return Arrays.stream(carNames.split(DELIMITER))
                .map(name -> new CarName(name.trim()))
                .toList();
    }

    public static Integer stringToInteger(String tryNumber) {
        InputValidator.validateInputTryNumber(tryNumber);
        return Integer.parseInt(tryNumber);
    }
}

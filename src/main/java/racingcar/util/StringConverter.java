package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
                .collect(Collectors.toList());
    }

    public static Integer stringToInteger(String TryNumber) {
        InputValidator.validateInputTryNumber(TryNumber);
        return Integer.parseInt(TryNumber);
    }
}
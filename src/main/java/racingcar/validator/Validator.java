package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import racingcar.exception.BlankCarNameException;
import racingcar.exception.CarNameRangeException;
import racingcar.exception.DuplicateCarNameException;
import racingcar.exception.OnlyCommaInputException;

public class Validator {
    private static final int CAR_NAME_RANGE = 5;

    private Validator() {
    }

    public static void carNameValidator(String carNames) {
        checkOnlyCommaInput(carNames);
        String[] splitCarNames = splitCarNames(carNames);
        checkCarNameLength(splitCarNames);
        checkDuplicateCarName(splitCarNames);
    }

    public static void checkEmptyCarName(String splitCarName) {
        if (trimCarName(splitCarName).isEmpty()) {
            throw new BlankCarNameException();
        }
    }

    public static void checkCarNameRange(String splitCarName) {
        if (trimCarName(splitCarName).length() > CAR_NAME_RANGE) {
            throw new CarNameRangeException();
        }
    }

    private static void checkCarNameLength(String[] splitCarNames) {
        for (String splitCarName : splitCarNames) {
            checkCarNameRange(splitCarName);
            checkEmptyCarName(splitCarName);
        }
    }

    private static String trimCarName(String splitCarName) {
        return splitCarName.trim();
    }

    private static void checkDuplicateCarName(String[] splitCarNames) {
        Set<String> carNameSet = new HashSet<>();
        Arrays.stream(splitCarNames)
                .forEach(carName -> {
                    if (!carNameSet.add(trimCarName(carName))) {
                        throw new DuplicateCarNameException();
                    }
                });
    }

    private static String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }

    private static void checkOnlyCommaInput(String carNames) {
        if (carNames.equals(",")) {
            throw new OnlyCommaInputException();
        }
    }
}

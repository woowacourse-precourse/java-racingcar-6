package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import racingcar.exception.car.BlankCarNameException;
import racingcar.exception.car.CarNameRangeException;
import racingcar.exception.car.DuplicateCarNameException;
import racingcar.exception.car.OnlyCommaInputException;

public class Validator {
    private static final int CAR_NAME_RANGE = 5;
    private static final int EMPTY = 0;
    private static final String DELIMITER = ",";

    private Validator() {
    }

    public static String[] carNameValidator(String carNames) {
        String[] splitCarNames = splitCarNames(carNames);
        checkCarNameLength(splitCarNames);
        checkDuplicateCarName(splitCarNames);
        return splitCarNames;
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
        checkEmptyCarNameArray(splitCarNames);
        for (String splitCarName : splitCarNames) {
            checkCarNameRange(splitCarName);
            checkEmptyCarName(splitCarName);
        }
    }

    private static void checkEmptyCarNameArray(String[] splitCarNames) {
        if (splitCarNames.length == EMPTY) {
            throw new OnlyCommaInputException();
        }
    }

    private static String trimCarName(String carName) {
        return carName.trim();
    }

    private static void checkDuplicateCarName(String[] splitCarNames) {
        Set<String> carNameSet = new HashSet<>();
        Arrays.stream(splitCarNames)
                .forEach(carName -> duplicateCarSet(carName, carNameSet));
    }

    private static void duplicateCarSet(String carName, Set<String> carNameSet) {
        if (!carNameSet.add(trimCarName(carName))) {
            throw new DuplicateCarNameException();
        }
    }

    private static String[] splitCarNames(String carNames) {
        return trimCarName(carNames).split(DELIMITER);
    }
}

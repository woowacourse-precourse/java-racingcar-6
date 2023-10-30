package racingcar.util.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.util.Strings;
import racingcar.exception.CarNameContainsWhiteSpaceException;
import racingcar.exception.CarNameDuplicatedException;
import racingcar.exception.CarNameLengthInvalidException;
import racingcar.exception.NoCarNameException;
import racingcar.exception.UserInputIsNullException;
import racingcar.util.converter.CarNameSplitter;

public class CarNamesValidator {

    private static final int INVALID_CAR_COUNT = 0;
    private static final int INVALID_NAME_LENGTH = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String WHITESPACE = " ";

    public static void validate(String carNames) {
        validateUserInputNotNull(carNames);
        List<String> splitCarNames = CarNameSplitter.splitCarNames(carNames);
        validateCarCount(splitCarNames);
        splitCarNames.forEach(CarNamesValidator::validateNameFormat);
        validateCarNamesUnique(splitCarNames);
    }

    private static void validateCarNamesUnique(List<String> carNames) {
        Set<String> existCarNames = new HashSet<>();
        for (String carName : carNames) {
            if (existCarNames.contains(carName)) {
                throw new CarNameDuplicatedException(carName);
            }
            existCarNames.add(carName);
        }
    }

    private static void validateNameFormat(String carName) {
        if (carName.length() == INVALID_NAME_LENGTH || carName.length() > MAX_NAME_LENGTH) {
            throw new CarNameLengthInvalidException(carName);
        }
        if (carName.contains(WHITESPACE)) {
            throw new CarNameContainsWhiteSpaceException(carName);
        }
    }

    private static void validateCarCount(List<String> splitCarNames) {
        if (splitCarNames.size() == INVALID_CAR_COUNT) {
            throw new NoCarNameException();
        }
    }

    private static void validateUserInputNotNull(String carNames) {
        if (Strings.isNullOrEmpty(carNames)) {
            throw new UserInputIsNullException();
        }
    }
}

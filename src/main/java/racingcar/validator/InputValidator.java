package racingcar.validator;

import java.util.List;
import racingcar.constant.RacingGameConstants;
import racingcar.exception.car.name.BlankException;
import racingcar.exception.cars.DuplicateException;
import racingcar.exception.car.name.LengthException;
import racingcar.exception.round.NonPositiveIntegerException;
import racingcar.utils.Parser;

public class InputValidator {
    // 자동차 이름 입력 검증
    public static void validateCarNames(String carNames) {
        List<String> carNameList = Parser.parseWithComma(carNames);
        carNameList.forEach(InputValidator::validateCarName);
        validateDuplicateName(carNameList);
    }

    public static void validateCarName(String carName) {
        validateCarNameLength(carName);
        validateCarNameNoBlanks(carName);
    }

    public static void validateCarNameLength(String carName) {
        if (carName.length() < RacingGameConstants.CAR_NAME_LENGTH_MIN
                || carName.length() > RacingGameConstants.CAR_NAME_LENGTH_MAX) {
            throw new LengthException();
        }
    }

    public static void validateCarNameNoBlanks(String carName) {
        if(carName.contains(" ") || carName.contains("\t") || carName.contains("\n")) {
            throw new BlankException();
        }
    }

    private static void validateDuplicateName(List<String> carNameList) {
        if (carNameList.stream()
                .distinct()
                .count() != carNameList.size()) {
            throw new DuplicateException();
        }
    }

    // 시도할 회수 입력 검증
    public static void validateNumberOfRounds(String userInput) {
        validatePositiveInteger(userInput);
    }

    private static void validatePositiveInteger(String userInput) {
        if (!RacingGameConstants.POSITIVE_INTEGER_PATTERN
                .matcher(userInput)
                .matches()) {
            throw new NonPositiveIntegerException();
        }
    }
}

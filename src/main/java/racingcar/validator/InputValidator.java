package racingcar.validator;

import java.util.List;
import racingcar.constant.RacingGameConstants;
import racingcar.exception.cars.DuplicateException;
import racingcar.exception.car.name.LengthException;
import racingcar.exception.round.NonPositiveIntegerException;
import racingcar.utils.Parser;

public class InputValidator {
    // 자동차 이름 입력 검증
    public static void validateCarList(String userInput) {
        validateCarNames(userInput);
    }

    private static void validateCarNames(String carNames) {
        validateCarNameLength(carNames);
        validateDuplicateName(carNames);
    }

    private static void validateCarNameLength(String carNames) {
        Parser.parseWithComma(carNames)
                .forEach(InputValidator::validateEachCarNameLength);
    }

    private static void validateEachCarNameLength(String carName) {
        if (carName.length() < RacingGameConstants.CAR_NAME_LENGTH_MIN
                || carName.length() > RacingGameConstants.CAR_NAME_LENGTH_MAX) {
            throw new LengthException();
        }
    }

    private static void validateDuplicateName(String carNames) {
        List<String> carNameList = Parser.parseWithComma(carNames);
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
        if (!userInput.matches("[1-9][0-9]*")) {
            throw new NonPositiveIntegerException();
        }
    }
}

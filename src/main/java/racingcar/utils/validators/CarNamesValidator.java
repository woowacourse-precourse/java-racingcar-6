package racingcar.utils.validators;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.utils.Parser;
import racingcar.utils.enums.Constraints;
import racingcar.utils.enums.ErrorMessage;

public class CarNamesValidator {
    public static void validateCarNames(String input) {
        List<String> carNames = Parser.parseCarNames(input);
        checkNameLength(carNames);
        checkDuplicate(carNames);
    }

    // 자동차 이름 길이 검증
    private static void checkNameLength(List<String> carNames) {
        checkNameEmpty(carNames);
        checkNameOverThreshold(carNames);
    }

    // 길이가 0인 경우
    private static void checkNameEmpty(List<String> carNames) {
        carNames.stream()
                .filter(carName -> carName.length() < Constraints.MIN_SIZE.getValue())
                .forEach(carName -> {
                    throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME_ERROR.getMessage());
                });
    }

    // 길이가 조건보다 긴 경우
    private static void checkNameOverThreshold(List<String> carNames) {
        carNames.stream()
                .filter(carName -> carName.length() > Constraints.MAX_SIZE.getValue())
                .forEach(carName -> {
                    throw new IllegalArgumentException(ErrorMessage.OVER_THRESHOLD_ERROR.getMessage());
                });
    }

    // 중복된 자동차 이름 검증
    private static void checkDuplicate(List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);
        if (carNames.size() != carNamesSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_DUPLICATE_ERROR.getMessage());
        }
    }
}
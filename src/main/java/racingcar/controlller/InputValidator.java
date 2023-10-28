package racingcar.controlller;

import static racingcar.constant.RacingGameConstants.MAX_CAR_NAME_LENGTH;
import static racingcar.constant.RacingGameConstants.MIN_CAR_NAME_LENGTH;

import java.util.List;
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
        Parser.parseWithComma(carNames).forEach(carName ->
        {
            if (carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(
                        "이름은 " + MIN_CAR_NAME_LENGTH + "자 이상 " + MAX_CAR_NAME_LENGTH + "자 이하여야 합니다.");
            }
        });
    }

    private static void validateDuplicateName(String carNames) {
        List<String> carNameList = Parser.parseWithComma(carNames);
        if (carNameList.stream()
                .distinct()
                .count() != carNameList.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    // 시도할 회수 입력 검증
    public static void validateNumberOfRounds(String userInput) {
        validatePositiveInteger(userInput);
    }

    private static void validatePositiveInteger(String userInput) {
        if (!userInput.matches("[1-9][0-9]*")) {
            throw new IllegalArgumentException("양수를 입력하지 않았습니다.");
        }
    }
}

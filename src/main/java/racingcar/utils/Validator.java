package racingcar.utils;

import static racingcar.model.constants.Error.DUPLICATE;
import static racingcar.model.constants.Error.LENGTH_INVALID;
import static racingcar.model.constants.Error.NON_DELIMITER;
import static racingcar.model.constants.Error.NUMBER_NOT_INTEGER;
import static racingcar.model.constants.Error.NUMBER_RANGE_INVALID;
import static racingcar.model.constants.Rule.CAR_MAX_LENGTH;
import static racingcar.model.constants.Rule.CAR_MIN_LENGTH;
import static racingcar.model.constants.Rule.DELIMITER;
import static racingcar.model.constants.Rule.TRIAL_MIN_LENGTH;

import java.util.List;

public class Validator {
    public static void validateCarNames(String inputCarNames) {
        validateCarNamesComma(inputCarNames);
        List<String> carNames = Parser.parseCarNames(inputCarNames);
        validateCarNamesLength(carNames);
        validateCarNamesDuplicates(carNames);
    }

    public static void validateTrial(String inputTrial) {
        validateTrialIfInteger(inputTrial);
        int trial = Parser.parseTrial(inputTrial);
        validateTrialRange(trial);
    }

    private static void validateCarNamesComma(String inputCarNames) {
        if (!inputCarNames.contains(DELIMITER.getMessage())) {
            throw new IllegalArgumentException(NON_DELIMITER.getMessage());
        }
    }

    private static void validateCarNamesLength(List<String> carNames) {
        if (carNames.stream().anyMatch(carName -> !isCarNameWithinValidLength(carName))) {
            throw new IllegalArgumentException(LENGTH_INVALID.getMessage());
        }
    }

    private static void validateCarNamesDuplicates(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException(DUPLICATE.getMessage());
        }
    }

    private static void validateTrialIfInteger(String inputTrial) {
        if (inputTrial.chars().anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException(NUMBER_NOT_INTEGER.getMessage());
        }
    }

    private static void validateTrialRange(int trial) {
        if (trial < TRIAL_MIN_LENGTH.getValue()) {
            throw new IllegalArgumentException(NUMBER_RANGE_INVALID.getMessage());
        }
    }

    private static boolean isCarNameWithinValidLength(String carName) {
        return carName.length() >= CAR_MIN_LENGTH.getValue() && carName.length() <= CAR_MAX_LENGTH.getValue();
    }
}
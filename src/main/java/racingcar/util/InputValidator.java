package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static void validateCarNames(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(Constants.INVALID_CAR_NAMES_EMPTY);
        }

        if (Arrays.stream(carNames.split(Constants.CAR_NAME_DELIMITER))
                .anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException(Constants.INVALID_CAR_NAMES_EMPTY);
        }

        List<String> carNameList = Arrays.asList(carNames.split(Constants.CAR_NAME_DELIMITER));
        Set<String> uniqueCarNames = new HashSet<>(carNameList);

        if (carNameList.size() != uniqueCarNames.size()) {
            throw new IllegalArgumentException(Constants.INVALID_CAR_NAMES_DUPLICATE);
        }

        if (carNameList.stream().anyMatch(carName -> carName.length() > 5)) {
            throw new IllegalArgumentException(Constants.INVALID_CAR_NAMES_LENGTH);
        }
    }

    public static void validateRound(String round) {
        if (round == null || round.isEmpty()) {
            throw new IllegalArgumentException(Constants.INVALID_ROUND_EMPTY);
        }

        if (!round.matches(Constants.REGEX_NUMBER) || Integer.parseInt(round) < 1) {
            throw new IllegalArgumentException(Constants.INVALID_ROUND_ONE_OR_MORE);
        }
    }
}

package racingcar.util;

import static racingcar.constants.ErrorCode.DUPLICATED_NAME;
import static racingcar.constants.ErrorCode.INVALID_INPUT;
import static racingcar.constants.ErrorCode.INVALID_NAME_LENGTH;
import static racingcar.constants.Message.SEPARATOR_REGEX;

import java.util.List;

public class Validator {

    public void validateCarName(String input) {
        List<String> names = List.of(input.split(SEPARATOR_REGEX.toString()));
        validateDuplicateName(names);
        validateLengthOfName(names);
    }

    private void validateLengthOfName(List<String> carNames) {
        carNames.forEach((names) -> {
            if (names.length() > 5) {
                throw new IllegalArgumentException(INVALID_NAME_LENGTH.toString());
            }
        });
    }

    private void validateDuplicateName(List<String> carNames) {
        Integer count = Math.toIntExact(carNames.stream()
                .distinct()
                .count());
        if (count == carNames.size()) {
            return;
        }

        throw new IllegalArgumentException(DUPLICATED_NAME.toString());
    }

    public void checkIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT.toString());
        }
    }
}

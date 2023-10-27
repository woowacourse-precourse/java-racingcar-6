package racingcar.util;

import java.util.Arrays;
import java.util.regex.Pattern;

import static racingcar.constant.Message.*;

public class Validation {

    public void validateCarNames(String input) {
        String[] carNames = input.split(DELIMITER, -1);

        validateDelimiterType(carNames);
        validateNameLength(carNames);
        int carNameCount = carNames.length;
        validateDuplicateName(carNameCount, carNames);
    }

    public void validateDelimiterType(String[] carNames) {
        String regex = "[a-zA-Z]+";
        boolean result = Arrays.stream(carNames).allMatch((carName) -> Pattern.matches(regex, carName));

        if (!result) {
            throw new IllegalArgumentException(EXCEPTION_DELIMITER_TYPE);
        }
    }

    public void validateNameLength(String[] carNames) {
        boolean result = Arrays.stream(carNames).anyMatch(this::inValidCarNameLength);

        if (!result) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_CAR_NAME_LENGTH);
        }
    }

    private boolean inValidCarNameLength(String input) {
        return input.length() < NAME_MIN_LENGTH || input.length() > NAME_MAX_LENGTH;
    }

    public void validateDuplicateName(int carNameCount, String[] carNames) {
        if (Arrays.stream(carNames).distinct().count() != carNameCount) {
            throw new IllegalArgumentException(EXCEPTION_DUPLICATE_CAR_NAME);
        }
    }

    public void validateGameRound(String input) {
        boolean result = input.chars().allMatch(Character::isDigit);

        if (!result) {
            throw new IllegalArgumentException(EXCEPTION_ROUND_TYPE);
        }
    }
}

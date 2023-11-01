package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static racingcar.constant.Constant.*;

public class Validation {

    public static List<String> validateCarNames(String input) {
        String[] carNames = input.split(DELIMITER, -1);

        validateWhiteSpace(carNames);
        validateDelimiterType(carNames);
        validateNameLength(carNames);
        int carNameCount = carNames.length;
        validateDuplicateName(carNameCount, carNames);

        return new ArrayList<>(Arrays.asList(carNames));
    }

    public static void validateWhiteSpace(String[] carNames) {
        // stream 쓰기엔 가독성이 더 별로.. 정규식이 맞는거같다
        String regex = ".*\\s+.*";
        boolean result = Arrays.stream(carNames)
                .anyMatch((carName) -> Pattern.matches(regex, carName));

        if (result) {
            throw new IllegalArgumentException(EXCEPTION_CONTAIN_WHITESPACE);
        }
    }

    public static void validateDelimiterType(String[] carNames) {
        String regex = "^[a-zA-Z]*$";
        boolean result = Arrays.stream(carNames).allMatch((carName) -> Pattern.matches(regex, carName));

        if (!result) {
            throw new IllegalArgumentException(EXCEPTION_DELIMITER_TYPE);
        }
    }

    public static void validateNameLength(String[] carNames) {
        boolean result = Arrays.stream(carNames).anyMatch(Validation::inValidCarNameLength);

        if (result) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_CAR_NAME_LENGTH);
        }
    }

    public static boolean inValidCarNameLength(String input) {
        return input.length() < NAME_MIN_LENGTH || input.length() > NAME_MAX_LENGTH;
    }

    public static void validateDuplicateName(int carNameCount, String[] carNames) {
        if (Arrays.stream(carNames).distinct().count() != carNameCount) {
            throw new IllegalArgumentException(EXCEPTION_DUPLICATE_CAR_NAME);
        }
    }

    public static int validateGameRound(String input) {
        validateBlankRound(input);
        validateRoundType(input);
        return Integer.parseInt(input);
    }

    public static void validateRoundType(String input) {
        boolean result = input.chars().allMatch(Character::isDigit);

        if (!result) {
            throw new IllegalArgumentException(EXCEPTION_ROUND_TYPE);
        }
    }

    public static void validateBlankRound(String input) {
        if (input.length() == 0 || input.equals("0")) {
            throw new IllegalArgumentException(EXCEPTION_ROUND_LENGTH);
        }
    }
}

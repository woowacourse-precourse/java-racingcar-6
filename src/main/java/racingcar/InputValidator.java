package racingcar;

import java.util.Arrays;
import java.util.HashSet;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_MOVING_NUMBER = 1;

    public static void validateCarNames(String[] input) {
        validateNamesIsEmpty(input);
        validateNameContainSpace(input);
        validateNameLength(input);
        validateDuplicateName(input);
    }

    public static void validateMovingNumber(String input) {
        validateNotNumber(input);
        validateNumberRange(input);
    }

    public static void validateNamesIsEmpty(String[] input) {
        for (String name : input) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("입력 값이 없습니다. 프로그램 종료");
            }
        }
    }

    public static void validateNameContainSpace(String[] input) {
        for (String name : input) {
            if (name.contains(" ")) {
                throw new IllegalArgumentException("이름 사이에 공백이 있습니다. 프로그램 종료");
            }
        }
    }

    public static void validateNameLength(String[] input) {
        for (String name : input) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("이름의 길이가 5초과 됩니다. 프로그램 종료");
            }
        }
    }

    public static void validateDuplicateName(String[] input) {
        HashSet<String> uniqueNames = new HashSet<>(Arrays.asList(input));

        if (uniqueNames.size() != input.length) {
            throw new IllegalArgumentException("중복된 이름이 있습니다. 프로그램 종료");
        }
    }

    public static void validateNotNumber(String number) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자로만 입력해야 합니다. 프로그램 종료");
        }
    }

    public static void validateNumberRange(String number) {
        if (Integer.parseInt(number) < MIN_MOVING_NUMBER) {
            throw new IllegalArgumentException("시도 횟수가 1보다 작습니다. 프로그램 종료");
        }
    }
}
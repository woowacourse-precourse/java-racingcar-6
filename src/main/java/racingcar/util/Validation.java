package racingcar.util;

import java.util.List;
import java.util.Objects;

public class Validation {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_NUMBER_OF_NAMES = 2;
    private static final int MIN_NUMBER_OF_RACES = 1;

    private static final String OVER_RANGE_LENGTH_NAME_MESSAGE = "5자리 이하 이름를 입력해주세요.";
    private static final String NOT_UNIQUE_NAME_MESSAGE = "중복되지 않는 이름을 입력해주세요.";
    private static final String EMPTY_NAME_MESSAGE = "이름을 입력해주세요.";
    private static final String BELOW_NUMBER_OF_NAMES_MESSAGE = "2개 이상의 이름을 입력해주세요.";

    private static final String NOT_NUMBER_MESSAGE = "숫자를 입력해주세요.";
    private static final String BELOW_RANGE_NUMBER_MESSAGE = "1이상 숫자를 입력해주세요.";
    private static final String EMPTY_NAME = "";

    public static void validateCarNames(List<String> names) {
        if (isOverRangeLengthName(names)) {
            throw new IllegalArgumentException(OVER_RANGE_LENGTH_NAME_MESSAGE);
        }
        if (isNotUniqueName(names)) {
            throw new IllegalArgumentException(NOT_UNIQUE_NAME_MESSAGE);
        }
        if (isEmptyName(names)) {
            throw new IllegalArgumentException(EMPTY_NAME_MESSAGE);
        }
        if (isBelowNumberOfNames(names)) {
            throw new IllegalArgumentException(BELOW_NUMBER_OF_NAMES_MESSAGE);
        }
    }

    private static boolean isOverRangeLengthName(List<String> names) {
        return names.stream()
                .anyMatch(name -> name.length() > MAX_CAR_NAME_LENGTH);
    }

    private static boolean isNotUniqueName(List<String> names) {
        return names.stream()
                .distinct()
                .count() != names.size();
    }

    private static boolean isEmptyName(List<String> names) {
        return names.stream()
                .anyMatch(name -> Objects.equals(name, EMPTY_NAME));
    }

    private static boolean isBelowNumberOfNames(List<String> names) {
        return names.size() < MIN_NUMBER_OF_NAMES;
    }

    public static void validateNumberOfRaces(String inputString) {
        if (isNotNumber(inputString)) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
        if (isBelowRange(inputString)) {
            throw new IllegalArgumentException(BELOW_RANGE_NUMBER_MESSAGE);
        }
    }

    private static boolean isNotNumber(String inputString) {
        return !inputString.matches("\\d+");
    }

    private static boolean isBelowRange(String inputString) {
        return Integer.parseInt(inputString) < MIN_NUMBER_OF_RACES;
    }
}
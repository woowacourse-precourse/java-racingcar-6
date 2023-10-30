package racingcar;

import java.util.Arrays;
import java.util.HashSet;

public class InputValidator {
    public static void validateCarNames(String[] input) {
        validateNamesIsEmpty(input);
        validateNameContainSpace(input);
        validateNameLength(input);
        validateDuplicateName(input);
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
            if (name.length() > 5) {
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

    public static void notNumber(int number) {

    }
}
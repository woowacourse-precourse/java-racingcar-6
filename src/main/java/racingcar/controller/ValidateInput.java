package racingcar.controller;

import java.util.List;

public class ValidateInput {
    private final static int MAX_NAME_LENGTH = 5;
    public static void validateNamesInput(String namesInput) {
        String[] inputSplit = namesInput.split(",");
        List<String> nameList = List.of(inputSplit);
        for (String name : nameList) {
            checkNameEmpty(name);
            checkNameLength(name);
        }
    }

    private static void checkNameEmpty(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("빈 이름이 존재함니다.");
        }
    }

    private static void checkNameLength(String name) throws IllegalArgumentException {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5글자를 초과한 이름이 입력되었습니다.");
        }
    }

    public static void validateRoundInput(String roundInput) {
        int number = checkIsNumber(roundInput);
        checkRoundRange(number);
    }

    private static int checkIsNumber(String roundInput) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(roundInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력되었습니다.");
        }
        return number;
    }

    private static void checkRoundRange(int number) throws IllegalArgumentException {
        if (number < 1 ) {
            throw new IllegalArgumentException("시도할 회수가 1보다 작습니다.");
        }
    }
}

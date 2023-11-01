package racingcar.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateName(String input) {
        validateString(input);
        String[] names = input.split(",");
        validateLength(names);
        validateDuplicate(names);
    }

    public static void validateNumber(String input) {
        validateString(input);
        validateNumeric(input);
        validateInteger(input);
        validatePositive(input);
    }

    private static void validateLength(String[] names) {
        for(String name : names) {
            if(name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다: " + name);
            }
        }
    }

    private static void validateDuplicate(String[] names) {
        Set<String> nameSet = new HashSet<>();
        for(String name : names) {
            if(!nameSet.add(name)) {
                throw new IllegalArgumentException("중복된 이름이 있습니다: " + name);
            }
        }
    }

    private static void validateString(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 비어있습니다.");
        }
    }

    private static void validateNumeric(String input) {
        try {
            Double.parseDouble(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        }
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 정수가 아닙니다");
        }
    }

    private static void validatePositive(String input) {
        if(Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("입력 값이 양수가 아닙니다");
        }
    }

}

package racingcar.validation;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidation {

    public static final int MAX_NAME_LENGTH = 5;
    public static final int MIN_NAME_LENGTH = 1;

    public static void validateTriesInput(String input) {
        validateIsNumber(input);
        isExist(input);
    }

    public static void validateCarNamesInput(List<String> inputs) {
        Set<String> set = new HashSet<>();
        for (String item : inputs) {
            isExist(item);
            validateNameLength(item);
            validateDuplicates(set, item);
        }
        validateCarCounts(inputs);
    }

    private static void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("값이 정수 범위를 초과했습니다.");
        }
    }

    private static void isExist(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요");
        }
    }

    private static void validateDuplicates(Set<String> set, String input) {
        if (!set.add(input)) {
            throw new IllegalArgumentException("중복되지 않은 이름을 입력해주세요.");
        }
    }

    private static void validateNameLength(String input) {
        int inputLength = input.length();
        if ((inputLength > MAX_NAME_LENGTH) || (inputLength < MIN_NAME_LENGTH)) {
            throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요.");
        }
    }

    private static void validateCarCounts(List<String> inputs) {
        int inputSize = inputs.size();
        if (inputSize < 2) {
            throw new IllegalArgumentException("2개 이상의 자동차 이름을 입력해주세요.");
        }
    }

}

package racingcar.validation;

import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidation {
    public static List<String> validateInputName(String input) {
        validateInputFormat(input);
        validateEachNameLength(input);
        List<String> inputList = changeStringToList(input);
        validateNameUniqueness(inputList);
        return inputList;
    }

    private static void validateInputFormat(String input) {
        if (!isSeparateByComma(input)) {
            throw new IllegalArgumentException("올바르게 구분되지 않았습니다.");
        }
    }

    private static boolean isSeparateByComma(String input) {
        try {
            input.split(",");
        } catch (PatternSyntaxException e) {
            return false;
        }
        return true;
    }

    private static void validateNameUniqueness(List<String> inputList) {
        if (inputList.size() != inputList.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private static void validateEachNameLength(String input) {
        for (String s : input.split(",")) {
            validateNameLength(s);
        }
    }

    private static void validateNameLength(String input) {
        if (isNameLengthMoreThanFive(input)) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }

        if (isNameLengthLessThanZero(input)) {
            throw new IllegalArgumentException("이름을 입력하지 않았습니다");
        }
    }

    private static boolean isNameLengthMoreThanFive(String input) {
        return input.length() > 5;
    }

    private static boolean isNameLengthLessThanZero(String input) {
        return input.isEmpty();
    }

    private static List<String> changeStringToList(String input) {
        return Stream.of(input.split(",")).collect(Collectors.toList());
    }

    public static int validateInputNumber(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException("숫자를 입력하지 않았습니다.");
        }
        return Integer.parseInt(input);
    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

package racingcar.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidation {
    public static List<String> validateInputName(String input) {
        validateInputFormat(input);
        validateEachName(input);
        return changeStringToList(input);
    }

    private static void validateInputFormat(String input) {
        if(isSeparateByComma(input)) {
            throw new IllegalArgumentException("올바르게 구분되지 않았습니다.");
        }
    }

    private static boolean isSeparateByComma(String input) {
        try {
            input.split(",");
        } catch(PatternSyntaxException e) {
            return false;
        }
        return true;
    }

    private static void validateEachName(String input) {
        for(String s : input.split(",")) {
            validateNameLength(s);
        }
    }

    private static void validateNameLength(String input) {
        if(isNameLengthMoreThanFive(input)) {
            throw new IllegalArgumentException();
        }

        if(isNameLengthLessThanZero(input)) {
            throw new IllegalArgumentException();
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
}

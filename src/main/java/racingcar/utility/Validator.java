package racingcar.utility;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_NUMBER_DIGITS = 9;

    public static void validateInput(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    public static void validateNameList(List<String> names) {
        if (hasSameName(names)) {
            throw new IllegalArgumentException("중복된 이름을 사용할 수 없습니다.");
        }

        for (String name : names) {
            if (!isInNameRange(name)) {
                throw new IllegalArgumentException("이름은 5자 이하로 입력해주세요.");
            }
        }
    }

    public static void validateGameCount(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }

        if (isZero(input)) {
            throw new IllegalArgumentException("0 이상의 값을 입력해주세요.");
        }

        if (!isNumberWithinNineDigits(input)) {
            throw new IllegalArgumentException("9자릿수까지 입력 가능합니다.");
        }
    }

    public static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    public static boolean isInNameRange(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    public static boolean hasSameName(List<String> names) {
        return names.size() != Set.copyOf(names).size();
    }

    public static boolean isNumber(String input) {
        return input.chars().allMatch(ch -> (ch >= '0' && ch <= '9'));
    }

    public static boolean isZero(String input) {
        return input.chars().allMatch(ch -> ch == '0');
    }

    public static boolean isNumberWithinNineDigits(String input) {
        return isNumber(input) && input.length() <= MAX_NUMBER_DIGITS;
    }

}

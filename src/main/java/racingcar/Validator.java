package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Validator {
    public static void nameLengthCheck(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public static void nameDuplicatenCheck(List<String> names) {
        int initLength = names.size();
        HashSet<String> deduplicationSet = new HashSet<>(names);
        if (initLength != deduplicationSet.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public static void blankCheck(String input) {
        if (Objects.equals(input, "")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static void countZeroCheck(String input) {
        if (input.length() == 1 && input.charAt(0) == '0') {
            throw new IllegalArgumentException("0이 아닌 양의 정수 입력해주세요.");
        }
    }

    public static void countNumericCheck(String input) {
        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            if (!('0' <= inputChar && inputChar <= '9')) {
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
            }
        }
    }

}

package racingcar.utility;

import java.util.List;
import java.util.Set;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;

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

    public static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    public static boolean isInNameRange(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    public static boolean hasSameName(List<String> names) {
        return names.size() != Set.copyOf(names).size();
    }

}

package racingcar.validator;

import java.util.List;

public final class NameValidator {
    private static void validateLength(List<String> names) {
        for (String name : names) {
            if (name.length() > 5 || name.length() < 1) {
                throw new IllegalArgumentException("1자 이상, 5자 이하의 이름을 입력해주세요.");
            }
        }
    }

    private static void validateCharacters(List<String> names) {
        for (String name : names) {
            if (!containsWithLowerCase(name)) {
                throw new IllegalArgumentException("알파벳으로 이루어진 이름을 입력해주세요.");
            }
        }
    }

    private static boolean containsWithLowerCase(String name) {
        return name.matches("^[a-z]+$");
    }
}

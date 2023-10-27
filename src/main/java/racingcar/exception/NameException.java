package racingcar.exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

abstract public class NameException {

    public static final String NAME_MIN_LENGTH_AND_NOT_EMPTY = "이름은 최소 1글자 이상(공백 제외) 입력해 주세요.";

    public static void validation(String[] names) {
        nameNotExistValidation(names);
        nameLengthValidation(names);
        nameNotEmptyValidation(names);
        nameDuplicateValidation(names);
    }

    private static void nameNotExistValidation(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException(NAME_MIN_LENGTH_AND_NOT_EMPTY);
        }
    }

    private static void nameLengthValidation(String[] names) {
        long count = Arrays.stream(names)
                .filter(name -> name.length() <= 5)
                .count();

        if (names.length != count) {
            throw new IllegalArgumentException("이름은 5자 이하만 입력 가능합니다.");
        }
    }

    private static void nameNotEmptyValidation(String[] names) {
        long count = Arrays.stream(names)
                .map(name -> name.replace(" ", ""))
                .filter(name -> name.length() > 0)
                .count();

        if (names.length != count) {
            throw new IllegalArgumentException(NAME_MIN_LENGTH_AND_NOT_EMPTY);
        }
    }

    private static void nameDuplicateValidation(String[] names) {
        Set<String> set = new HashSet<>();

        Collections.addAll(set, names);

        if (names.length != set.size()) {
            throw new IllegalArgumentException("이름은 중복 없이 입력해 주세요.");
        }
    }
}

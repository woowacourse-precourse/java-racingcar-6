package racingcar.exception;

import java.util.Arrays;

abstract public class NameException {

    public static void validation(String[] names) {
        nameNotExistValidation(names);
        nameLengthValidation(names);
    }

    private static void nameNotExistValidation(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException("이름은 1개 이상 입력해주세요.");
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
            throw new IllegalArgumentException("이름은 공백 제외 최소 1글자 이상 입력하셔야 합니다.");
        }
    }
}

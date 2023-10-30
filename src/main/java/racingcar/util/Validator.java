package racingcar.util;

import java.util.List;

public class Validator {

    public static void validateCarName(List<String> nameList) {
        for(String name : nameList) {
            validateNameLength(name);
        }
    }

    private static void validateNameLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 넘을 수 없습니다.");
        }
    }

    public static void validateNumber(String input) {
        validateChangeNumber(input);
    }

    private static void validateChangeNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
    }
}

package racingcar.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputException {
    public static void validateInputName(List<String> names) {
        Set<String> nameSet = new HashSet<>();
        for (String name : names) {
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }

            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void validateInputCount(int moveCount) {
        if (moveCount <= 0) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력하세요");
        }
    }

}

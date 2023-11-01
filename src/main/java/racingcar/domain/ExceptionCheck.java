package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExceptionCheck {
    public void isOverSizeCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public void isDuplicate(List<String> input) {
        Set<String> inputSet = new HashSet<>(input);
        if (inputSet.size() != input.size()) {
            throw new IllegalArgumentException("차량 이름이 중복되었습니다.");
        }
    }

    public void isNull(String input, String type) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(type + " 입력되지 않았습니다.");
        }
    }

    public void isStr(String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}

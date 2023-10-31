package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidation {

    private static final int CONDITION_DIGITS = 5;

    public InputValidation() {
    }

    public boolean checkName(String name) {
        if (name.length() > CONDITION_DIGITS) {
            throw new IllegalArgumentException("5자리 이하의 이름을 입력해주세요.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다. 값을 입력해주세요.");
        }
        return true;
    }

    public void checkDuplicate(List<String> carNames) {
        Set<String> nameSet = new HashSet<>(carNames);
        if (nameSet.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차가 있습니다.");
        }
    }
}

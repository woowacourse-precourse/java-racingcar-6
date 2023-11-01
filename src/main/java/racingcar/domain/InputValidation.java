package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidation {

    private static final int CONDITION_DIGITS = 5;

    public InputValidation() {
    }

    public boolean checkTrial(String trial) {
        if (trial.isEmpty()) {
            throw new IllegalArgumentException("입력된 숫자가 없습니다. 시도할 횟수를 입력해주세요.");
        }
        if (trial.contains(" ")) {
            throw new IllegalArgumentException("공백이 포함되어 있습니다. 공백 없이 입력해주세요.");
        }
        if (Integer.parseInt(trial) == 0) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요.");
        }
        for (int i = 0; i < trial.length(); i++) {
            char numberCheck = trial.charAt(i);
            if (numberCheck < 48 || numberCheck > 57) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
        }

        return true;
    }

    public boolean checkName(String name) {
        if (name.length() > CONDITION_DIGITS) {
            throw new IllegalArgumentException("5자리 이하의 자동차 이름을 입력해주세요.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("입력된 자동차 이름이 없습니다. 자동차 이름을 입력해주세요.");
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException("공백 문자가 포함되어 있습니다.");
        }
        return true;
    }

    public void checkDuplicate(List<String> carNames) {
        Set<String> nameSet = new HashSet<>(carNames);
        if (nameSet.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 입력되었습니다.");
        }
    }
}

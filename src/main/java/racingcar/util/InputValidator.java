package racingcar.util;

import java.util.List;

public class InputValidator {
    public void validateCarNamesSize(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("경주에 참여할 자동차의 이름 수가 모자릅니다. 적어도 2개 이상의 이름을 입력해주세요.");
        }
    }

    public void validateCarNameLength() {

    }

    public void validateMoveCountRange() {

    }
}

package racingcar.util;

import java.util.List;

public class InputValidator {
    private static final int MIN_CAR_NAMES_SIZE = 2;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public void validateCarNamesSize(List<String> carNames) {
        if (carNames.size() < MIN_CAR_NAMES_SIZE) {
            throw new IllegalArgumentException("경주에 참여할 자동차의 이름 수가 모자릅니다. 적어도 2개 이상의 이름을 입력해주세요.");
        }
    }

    public void validateCarNameLength(List<String> carNames) {
        boolean isOverMaxCarNameLength = carNames.stream().map(carName -> carName.length())
                .filter(nameLength -> nameLength > MAX_CAR_NAME_LENGTH)
                .count() > 0;

        if (isOverMaxCarNameLength) {
            throw new IllegalArgumentException("자동차의 이름이 5글자를 초과 했습니다. 5글자 이하의 이름으로 입력해주세요.");
        }
    }

    public void validateMoveCountRange() {

    }
}

package racingcar.model;

import racingcar.constant.GameConstant;

public class TryCount {

    private final int count;

    public TryCount(String count) {
        validateNumber(count);
        validateZero(count);
        this.count = Integer.parseInt(count);
    }

    private void validateNumber(String count) {
        if (!count.matches(GameConstant.NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void validateZero(String count) {
        if (count.matches(GameConstant.ZERO_REGEX)) {
            throw new IllegalArgumentException("1이상의 숫자를 입력해주세요.");
        }
    }

    public int value() {
        return count;
    }
}
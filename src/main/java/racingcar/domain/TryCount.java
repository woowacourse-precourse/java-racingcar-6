package racingcar.domain;

import static racingcar.message.MessageConstants.ZERO;

public class TryCount {

    private final int value;

    public TryCount(String inputTryCount) {
        int intTryCount = validateNumberFormat(inputTryCount);
        validateNegativeNumber(intTryCount);
        this.value = intTryCount;
    }

    private int validateNumberFormat(String inputTryCount) {
        try {
            return Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void validateNegativeNumber(int parseTryCount) {
        if (parseTryCount < ZERO) {
            throw new IllegalArgumentException("유효하지 않은 시도 회수입니다.");
        }
    }

    public int getValue() {
        return value;
    }
}

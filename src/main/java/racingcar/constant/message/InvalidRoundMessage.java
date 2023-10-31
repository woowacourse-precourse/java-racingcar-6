package racingcar.constant.message;

import racingcar.constant.range.RoundRange;

public enum InvalidRoundMessage {
    NOT_NUMERIC("라운드 입력은 숫자이어야 합니다."),
    OUT_OF_RANGE(RoundRange.MIN.getValue() + " 이상 " + RoundRange.MAX.getValue() + "이하인 값을 입력하세요.");

    private final String message;

    InvalidRoundMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

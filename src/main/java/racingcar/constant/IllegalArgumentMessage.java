package racingcar.constant;

import static racingcar.constant.Constant.RULE_CAR_NAME_MAX_SIZE;

public enum IllegalArgumentMessage {

    EMPTY_INPUT("값을 입력해야 합니다."),
    NAME_OUT_OF_RANGE("빈 이름이 들어오거나 길이가 " + RULE_CAR_NAME_MAX_SIZE + " 초과인 이름이 있습니다."),
    NAME_DUPLICATE("중복된 이름이 포함되어 있습니다."),
    COUNT_NOT_POSITIVE("입력은 양의 정수여야 합니다."),
    COUNT_NOT_INTEGER("입력은 정수여야 합니다.");

    private final String message;

    IllegalArgumentMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

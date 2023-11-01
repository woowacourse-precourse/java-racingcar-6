package racingcar.constant;

import static racingcar.constant.InputNumConstant.MAX_NAME_LENGTH;
import static racingcar.constant.InputNumConstant.MIN_NAME_LENGTH;

public enum ExceptionMessage {

    NAME_LENGTH_NOT_IN_RANGE(
            "이름은 %d자 이상, %d자 이하여야 합니다.".formatted(MIN_NAME_LENGTH.getValue(), MAX_NAME_LENGTH.getValue())),
    ROUND_CONTAIN_NOT_ONLY_NUM("자동차 이동은 숫자로 입력해야 합니다."),
    ROUND_MUST_BE_POSITIVE("자동차 이동은 양수로 입력해야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}

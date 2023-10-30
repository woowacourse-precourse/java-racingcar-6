package racingcar.constant;

import static racingcar.constant.InputNumConstant.MAX_NAME_LENGTH;
import static racingcar.constant.InputNumConstant.MIN_NAME_LENGTH;

public enum ExceptionConstant {

    NAME_LENGTH_NOT_IN_RANGE(
            "이름은 %d자 이상, %d자 이하여야 합니다.".formatted(MIN_NAME_LENGTH.getValue(), MAX_NAME_LENGTH.getValue()));

    private final String value;

    ExceptionConstant(String vlaue) {
        this.value = vlaue;
    }

    public String getValue() {
        return this.value;
    }
}

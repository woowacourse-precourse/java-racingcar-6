package racingcar.constant;

import static racingcar.constant.GameConstant.MAX_CAR_NAME_LENGTH;

public enum ErrorMessage {
    EMPTY_STRING_ERROR("비어있는 값을 입력할 수 없습니다."),
    CAR_NAME_LENGTH_ERROR("자동차 이름은 쉼표를 기준으로 " + MAX_CAR_NAME_LENGTH.getValue() + "글자 이하만 가능합니다."),
    NON_NUMERIC_ERROR("숫자만 입력해주세요.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

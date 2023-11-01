package racingcar.global.enums;

/**
 * 예외 상황을 구분하기 위한 에러 메시지 ENUM
 */
public enum ErrorMessage {

    EMPTY_INPUT_VALUE("입력 값이 비어 있습니다."),
    INVALID_NUMBER_FORMAT("숫자 형식이 올바르지 않습니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다.")

    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public final String getType() {
        return message;
    }
}

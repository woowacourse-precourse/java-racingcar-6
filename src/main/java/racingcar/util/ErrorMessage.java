package racingcar.util;

public enum ErrorMessage {
    CAR_INPUT_EMPTY_STRING("입력한 자동차 이름의 값이 비어있습니다."),
    CAR_INPUT_EXCEED_NAME_LIMIT_LENGTH("자동차 이름의 제한 글자는 5글자 이하입니다."),
    CAR_INPUT_DUPLICATE_CAR_NAME("중복되는 자동차 이름이 존재합니다."),
    CAR_INPUT_ONLY_SPACE_CAR_NAME("자동차 이름에 공백만 존재합니다."),
    TRY_COUNT_NOT_A_NUMBER("시도 회수 입력 값이 숫자가 아닙니다."),
    TRY_COUNT_NOT_A_POSITIVE_INTEGER("시도 회수는 1 이상이어야 합니다.");
    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}

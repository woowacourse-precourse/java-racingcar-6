package racingcar.constants;

public enum ErrorMessage {

    INVALID_NAME_LENGTH_ERROR("자동차 이름은 5자 이하만 가능합니다."),
    INVALID_ROUND_TYPE_ERROR("라운드는 숫자만 입력 가능합니다."),
    INVALID_ROUND_RANGE_ERROR("라운드 수가 유효한 범위에 있지 않습니다."),
    INVALID_CAR_RANGE_ERROR("자동차 개수가 유효한 범위에 있지 않습니다");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
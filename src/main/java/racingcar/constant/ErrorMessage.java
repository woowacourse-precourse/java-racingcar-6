package racingcar.constant;

public enum ErrorMessage {
    EMPTY_STRING_ERROR("비어있는 값을 입력할 수 없습니다."),
    CAR_NAME_LENGTH_ERROR("자동차 이름은 쉼표를 기준으로 5글자 이하만 가능합니다."),
    DUPLICATE_CAR_NAME_ERROR("자동차 이름은 중복될 수 없습니다. "),
    NON_NUMERIC_ERROR("숫자만 입력해주세요."),
    INVALID_RANGE_ERROR("1이상의 숫자를 입력해주세요."),
    EMPTY_PROGRESS_RESPONSES_MSG("게임 결과는 하나 이상 이어야 합니다."),
    EMPTY_WINNERS_MSG("우승자는 한명 이상 이어야 합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

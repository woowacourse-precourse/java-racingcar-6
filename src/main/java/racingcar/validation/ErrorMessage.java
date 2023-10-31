package racingcar.validation;

public enum ErrorMessage {
    NAME_LENGTH_ERROR("자동차 이름은 1이상 5이하만 가능합니다."),
    NAME_DUPLICATE_ERROR("자동차 이름은 중복될 수 없습니다."),
    ROUND_INPUT_ERROR("정수를 입력해 주세요"),
    ROUND_LENGTH_ERROR("라운드는 1이상 20이하만 가능합니다"),
    NAME_WHITESPACE_ERROR("자동차 이름에 공백이 포함될 수 없습니다."),
    NAME_FORMAT_ERROR("자동차 입력 형식이 올바르지 않습니다. 자동차 이름은 쉼표(,) 기준으로 구분됩니다."),
    PARTICIPANT_COUNT_ERROR("자동차 게임에 참여할 수 있는 인원은 최대 10명입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

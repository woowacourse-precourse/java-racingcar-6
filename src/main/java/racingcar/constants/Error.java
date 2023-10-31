package racingcar.constants;


public enum Error {
    CAR_COUNT_ERROR("2대 이상의 자동차 이름을 입력해 주세요."),
    BLANK_ERROR("이름을 공백으로 입력하지 마세요."),
    LENGTH_ERROR("자동차 이름을 5자 이하로 입력해 주세요."),
    DUPLICATION_ERROR("중복되지 않은 이름을 입력해 주세요."),
    ROUND_COUNT_ERROR("1이상의 숫자를 입력하세요."),
    NOT_NUMBER_ERROR("숫자만 입력하세요.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

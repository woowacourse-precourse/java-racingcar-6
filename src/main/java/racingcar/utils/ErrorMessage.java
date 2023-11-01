package racingcar.utils;

public enum ErrorMessage {
    SPACE_ERROR("공백 없이 입력해주시길 바랍니다"),

    NO_NAME_ERROR("레이싱 자동차 이름이 없습니다"),

    ALPHA_NAME_ERROR("레이싱 자동차 이름은 영어만 허용됩니다"),

    NAME_LENGTH_ERROR("자동차 이름 길이는 5이하 입니다"),

    DUPLICATED_NAME_ERROR("중복된 자동차 이름이 있습니다"),

    DIGIT_RACE_COUNT_ERROR("숫자만 입력해주시길 바랍니다"),

    EMPTY_RACE_COUNT_ERROR("레이스 횟수를 입력하시길 바랍니다"),

    ZERO_RACE_COUNT_ERROR("레이스 시도 횟수는 1 이상입니다");

    private String error;

    ErrorMessage(String error) {
        this.error = error;
    }

    public String getMessage() {
        return this.error;
    }
}

package racingcar.enums;

public enum ErrorMessage {
    LENGTH_OF_NAME_RANGE("자동차 이름의 길이는 1 이상 5 이하 입니다."),
    ILLEGAL_PATTERN_OF_NAME("자동차의 이름은 영문자(a-z, A-Z)로 시작하고, 영문자와 숫자(0-9)로 구성되어야합니다."),
    MINIMUM_COUNT_OF_CAR("경주에 필요한 자동차는 두 대 이상입니다."),
    DUPLICATE_CAR_NAME("자동차의 이름은 중복될 수 없습니다."),
    NUMBER_OF_ATTEMPTS_RANGE("시도 횟수는 1 이상의 정수입니다."),
    ATTEMPS_STRING_TO_INTEGER("문자가 포함된 문자열은 정수로 변환할 수 없습니다.");

    private final String message;

    ErrorMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}

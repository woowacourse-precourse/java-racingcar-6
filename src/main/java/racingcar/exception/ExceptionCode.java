package racingcar.exception;

public enum ExceptionCode {
    NO_RESULT("MODEL-001", "게임 결과가 존재하지 않습니다."),
    NO_CAR_LIST("MODEL-002", "자동차 이름 목록이 존재하지 않습니다."),
    NO_ATTEMPT_NUMBER("MODEL-003", "시도 횟수가 존재하지 않습니다."),

    INVALID_RANDOM_NUMBERS_SIZE("SERVICE-001", "랜덤 숫자 길이가 자동차 숫자와 다릅니다.")
    ;

    private final String code;
    private final String description;

    ExceptionCode(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ExceptionCode{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

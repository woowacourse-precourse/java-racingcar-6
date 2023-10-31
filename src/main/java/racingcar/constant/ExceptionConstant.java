package racingcar.constant;

public enum ExceptionConstant {

    ExceptionConstant() {
    };

    public static final String CAR_NAME_LENGTH_EXCEPTION = "자동차 이름은 5자 이하만 가능합니다";
    public static final String CAR_NAME_DUPLICATION_EXCEPTION = "자동차 이름은 중복될 수 없습니다";
    public static final String ATTEMPT_COUNT_EXCEPTION = "시도 횟수는 1보다 작을 수 없습니다";
}

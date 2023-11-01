package racingcar;

public final class ExceptionMessage {
    private ExceptionMessage() {
        throw new UnsupportedOperationException();
    }

    public static final String INVALID_CAR_NAME_LENGTH = "자동차 이름 길이가 유효하지 않습니다";
    public static final String INVALID_ATTEMPT = "시도 횟수가 양수가 아닙니다";
    public static final String INVALID_ATTEMPT_TYPE = "시도 횟수가 정수 형태가 아닙니다";

}

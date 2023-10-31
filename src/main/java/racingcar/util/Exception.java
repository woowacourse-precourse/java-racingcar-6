package racingcar.util;

public class Exception {
    private static final int CAR_NAME_LIMIT_MIN = 1;
    private static final int CAR_NAME_LIMIT_MAX = 5;
    private static final String SPACE = " ";

    private void throwSpaceException() {
        throw new IllegalArgumentException("자동차 이름안에 공백을 제거하세요.");
    }
}

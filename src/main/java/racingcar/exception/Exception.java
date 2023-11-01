package racingcar.exception;

public class Exception {
    public static void invalidValueEntered() {
        throw new IllegalArgumentException("사용자가 잘못된 값을 입력했습니다.");
    }
}

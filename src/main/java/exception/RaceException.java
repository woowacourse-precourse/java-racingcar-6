package exception;

public class RaceException extends IllegalArgumentException {
    public static final String LENGTH_OVER_MAXIMUM = "이름이 다섯글자 넘습니다.";
    public static final String LENGTH_UNDER_MINIMUM = "이름은 최소 1자 이상이어야 합니다.";

    public static final String NOT_NUMBER= "입력하신 것은 숫자가 아닙니다.";
    public static final String INVALID_ATTEMPT_COUNT = "시도 횟수는 1 이상의 숫자여야 합니다.";

    public RaceException(String message) {
        super(message);
    }
}

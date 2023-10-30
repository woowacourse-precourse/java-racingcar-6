package exception;

public class RaceException extends IllegalArgumentException {
    public static final String LENGTH_EXCEEDED = "이름이 다섯글자 넘습니다.";

    public RaceException(String message) {
        super(message);
    }
}

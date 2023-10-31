package racingcar.exception;

public class NotANumberException extends IllegalArgumentException {
    public NotANumberException() {
        super("입력한 문자열에 숫자가 아닌 값이 포함돼 있습니다.");
    }
}

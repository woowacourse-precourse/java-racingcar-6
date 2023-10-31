package racingcar.exception;

public class SizeNotMatchException extends IllegalArgumentException{
    public SizeNotMatchException() {
        super("차 이름의 글자 수는 1이상 5이하여야 합니다.");
    }
}

package racingcar.exception;

public class NotNatureNumberException extends IllegalArgumentException{

    public NotNatureNumberException() {
        super("자연수가 아닌 값이 들어왔습니다.");
    }
}

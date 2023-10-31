package racingcar.exception;

public class OverCarMaxNameLengthException extends CustomException {
    public OverCarMaxNameLengthException(int maxNameLength) {
        super("이름의 길이는 " + maxNameLength + " 이하여야 합니다.");
    }
}

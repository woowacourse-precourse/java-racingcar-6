package racingcar.exception;

public class NotValidNameException extends CustomException {
    public NotValidNameException(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotValidNameException() {
        super(ErrorCode.CAR_NAME_WITHIN_FIVE_LETTERS);
    }

    @Override
    public ErrorCode getErrorCode() {
        return super.getErrorCode();
    }
}

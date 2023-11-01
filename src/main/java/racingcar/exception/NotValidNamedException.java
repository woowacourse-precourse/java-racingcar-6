package racingcar.exception;

public class NotValidNamedException extends CustomException {
    public NotValidNamedException(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotValidNamedException() {
        super(ErrorCode.CAR_NAME_IS_BLANK);
    }

    @Override
    public ErrorCode getErrorCode() {
        return super.getErrorCode();
    }
}

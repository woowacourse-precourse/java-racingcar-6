package racingcar.exception;

public class NotValidTrialNumberException extends CustomException {
    public NotValidTrialNumberException(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotValidTrialNumberException() {
        super(ErrorCode.TRIAL_NUMBER_LESS_THAN_ZERO);
    }

    @Override
    public ErrorCode getErrorCode() {
        return super.getErrorCode();
    }
}

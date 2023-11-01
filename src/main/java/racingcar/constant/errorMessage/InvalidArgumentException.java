package racingcar.constant.errorMessage;

public class InvalidArgumentException extends IllegalArgumentException {

    public InvalidArgumentException(final ErrorMessagesStatus errorMessagesStatus) {
        super(errorMessagesStatus.getMessage());
    }
}

package racingcar.global.error;

public class BusinessException extends IllegalArgumentException {
    private BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static BusinessException of(ErrorMessage errorMessage) {
        return new BusinessException(errorMessage);
    }
}

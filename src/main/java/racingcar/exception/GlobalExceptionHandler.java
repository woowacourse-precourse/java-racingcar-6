package racingcar.exception;

public class GlobalExceptionHandler {
    public static void handleCustomException(CustomException e) {
        ErrorCode errorCode = e.getErrorCode();
        throw new IllegalArgumentException(errorCode.getMessage());
    }
}

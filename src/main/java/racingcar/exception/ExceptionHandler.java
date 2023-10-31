package racingcar.exception;

import racingcar.communication.Communicator;

public class ExceptionHandler {
    private static final String ILLEGAL_ARGUMENT_EXCEPTION = "java.lang.IllegalArgumentException";
    private static final String NO_SUCH_ELEMENT_EXCEPTION = "java.util.NoSuchElementException";
    private static final String NUMBER_FORMAT_EXCEPTION = "java.lang.NumberFormatException";
    private static final String EXCEPTION_UNIDENTIFIED = "정의되지 않은 예외입니다. 확인해주세요.";
    private static final String NO_CAR_STORED = "저장된 자동차가 없습니다";
    private static final String NO_ELEMENT = "요소를 찾을 수 없습니다.";
    private static final String INVALID_FORMAT = "잘못된 형식입니다. 숫자를 입력해주세요.";

    public static void handleException(RuntimeException exception) {
        String exceptionCanonicalName = exception.getClass().getCanonicalName();

        throw switch (exceptionCanonicalName) {
            case ILLEGAL_ARGUMENT_EXCEPTION -> handleIllegalArgumentException(exception);
            case NO_SUCH_ELEMENT_EXCEPTION -> handleNoSuchElementException(exception);
            case NUMBER_FORMAT_EXCEPTION -> handleNumberFormatException();
            default -> new IllegalArgumentException(EXCEPTION_UNIDENTIFIED);
        };
    }

    private static IllegalArgumentException handleIllegalArgumentException(RuntimeException exception) {
        Communicator.printException(exception);
        return (IllegalArgumentException) exception;
    }

    private static IllegalArgumentException handleNoSuchElementException(RuntimeException exception) {
        if (exception.getMessage().equals(NO_CAR_STORED)) {
            Communicator.printException(exception);
            return new IllegalArgumentException(exception.getMessage());
        }

        IllegalArgumentException convertedException = new IllegalArgumentException(NO_ELEMENT);
        Communicator.printException(convertedException);
        return convertedException;
    }

    private static IllegalArgumentException handleNumberFormatException() {
        IllegalArgumentException convertedException = new IllegalArgumentException(INVALID_FORMAT);
        Communicator.printException(convertedException);
        return convertedException;
    }
}

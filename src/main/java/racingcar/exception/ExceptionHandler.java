package racingcar.exception;

import racingcar.communication.Communicator;

public class ExceptionHandler {
    public static void handleException(RuntimeException exception) {
        String exceptionCanonicalName = exception.getClass().getCanonicalName();

        throw switch (exceptionCanonicalName) {
            case "java.lang.IllegalArgumentException" -> handleIllegalArgumentException(exception);
            case "java.util.NoSuchElementException" -> handleNoSuchElementException(exception);
            case "java.lang.NumberFormatException" -> handleNumberFormatException();
            default -> new IllegalArgumentException("정의되지 않은 예외입니다. 확인해주세요.");
        };
    }

    private static IllegalArgumentException handleIllegalArgumentException(RuntimeException exception) {
        Communicator.printException(exception);
        return (IllegalArgumentException) exception;
    }

    private static IllegalArgumentException handleNoSuchElementException(RuntimeException exception) {
        if (exception.getMessage().equals("저장된 자동차가 없습니다")) {
            Communicator.printException(exception);
            return new IllegalArgumentException(exception.getMessage());
        }

        IllegalArgumentException convertedException = new IllegalArgumentException("요소를 찾을 수 없습니다.");
        Communicator.printException(convertedException);
        return convertedException;
    }

    private static IllegalArgumentException handleNumberFormatException() {
        IllegalArgumentException convertedException = new IllegalArgumentException("잘못된 형식입니다. 숫자를 입력해주세요.");
        Communicator.printException(convertedException);
        return convertedException;
    }
}

package racingcar.util;

public class ExceptionHandler {

    public static void triggerException(ErrorMessage message) {
        System.out.println("[오류]: " + message.getMessage());
        throw new IllegalArgumentException(message.getMessage());
    }
}

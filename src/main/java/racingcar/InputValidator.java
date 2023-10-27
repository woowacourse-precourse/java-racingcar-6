package racingcar;

public class InputValidator {

    private static final String DELIMITER = ",";

    public static void validateDelimiter(String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_HAVE_DELIMITER.getMessage());
        }
    }
}

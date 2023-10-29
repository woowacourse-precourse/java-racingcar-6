package validate;

public class Validator {

    private static final String ONLY_NUMBER = "숫자만 입력 가능합니다.";
    private static final String NO_EMPTY = "공백 입력은 불가합니다.";

    private Validator() {
    }

    public static void validateNumericInput(String attempts) {
        try {
            Integer.parseInt(attempts);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }

    public static void validateEmpty(String inputs) {
        if (inputs.isBlank() || inputs.isEmpty()) {
            throw new IllegalArgumentException(NO_EMPTY);
        }
    }
}

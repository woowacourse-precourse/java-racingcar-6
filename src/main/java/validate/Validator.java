package validate;

public class Validator {
    
    private static final String ONLY_NUMBER = "숫자만 입력 가능합니다.";

    private Validator() {
    }


    public static void validateNumericInput(String attempts) {
        try {
            Integer.parseInt(attempts);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }
}

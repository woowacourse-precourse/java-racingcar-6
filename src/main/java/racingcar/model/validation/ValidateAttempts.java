package racingcar.model.validation;

public class ValidateAttempts extends Validator {
    private ValidateAttempts() {
    }

    private static final String errorMessage = "공백 없이 자연수로만 입력해주세요.";

    public static void isValid(String attempts) {
        isEmpty(attempts, errorMessage);
        hasSpace(attempts, errorMessage);
        isNaturalNunmber(attempts);
    }

    private static void isNaturalNunmber(String attempts) {
        try {
            Integer.parseInt(attempts);
        } catch (Exception e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}

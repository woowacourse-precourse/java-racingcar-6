package racingcar.utils.validation;

public class ValidateAttempts extends Validator {
    private static final String errorMessage = "공백 없이 자연수로만 입력해주세요.";

    private ValidateAttempts() {
    }


    public static void isValid(String attempts) {
        isEmpty(attempts, errorMessage);
        hasSpace(attempts, errorMessage);
        isNaturalNunmber(attempts);
    }


    // 자연수 검사
    private static void isNaturalNunmber(String attempts) {
        try {
            int input = Integer.parseInt(attempts);

            if (input < 0) {
                throw new IllegalArgumentException(errorMessage);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}

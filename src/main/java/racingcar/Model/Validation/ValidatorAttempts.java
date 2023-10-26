package racingcar.Model.Validation;

public class ValidatorAttempts extends Validator {
    private final String errorMessage = "공백 없이 자연수로만 입력해주세요.";

    public void isValid(String attempts) {
        isEmpty(attempts, errorMessage);
        hasSpace(attempts, errorMessage);
        isNaturalNunmber(attempts);
    }

    private void isNaturalNunmber(String attempts) {
        try {
            Integer.parseInt(attempts);
        } catch (Exception e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}

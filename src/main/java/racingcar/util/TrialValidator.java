package racingcar.util;

public class TrialValidator extends Validator {
    @Override
    public void validation(String input) {
        validationTrialIsZero(input);
        validationTrialIsNatualNumber(input);
    }

    private void validationTrialIsNatualNumber(String input) {
        String regex = "^[0-9]*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NATURAL_NUMBER.getMessage());
        }
    }

    private void validationTrialIsZero(String input) {
        if (input.equals("0")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NATURAL_NUMBER.getMessage());
        }
    }
}

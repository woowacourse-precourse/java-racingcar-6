package racingcar.verifier;

import racingcar.system.ExceptionMessage;

public class AttemptsNumVerifier implements Verifier<String> {

    @Override
    public void validate(String input) {
        validateNumeric(input);
        validateRange(input);
    }

    private void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Verifier.throwIllegalArgumentError(ExceptionMessage.NOT_NUMERIC);
        }
    }

    private void validateRange(String input) {
        int attempts = Integer.parseInt(input);
        if (attempts <= 0) {
            Verifier.throwIllegalArgumentError(ExceptionMessage.INVALID_NUM_OF_ATTEMPTS);
        }
    }
}

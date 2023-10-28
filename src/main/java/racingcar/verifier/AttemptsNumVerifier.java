package racingcar.verifier;

import racingcar.system.ExceptionMessage;

public class AttemptsNumVerifier implements Verifier{

    @Override
    public void check(String input) throws IllegalArgumentException {
        checkNumeric(input);
    }
    private void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC);
        }
    }
}

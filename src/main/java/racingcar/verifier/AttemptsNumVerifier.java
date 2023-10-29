package racingcar.verifier;

import racingcar.system.ExceptionMessage;

public class AttemptsNumVerifier implements Verifier{

    @Override
    public void check(String input) throws IllegalArgumentException {
        checkNumeric(input);
        checkRange(input);
    }
    private void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC);
        }
    }

    private void checkRange(String input){
        int attempts = Integer.parseInt(input);
        if(attempts <=0)
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUM_OF_ATTEMPTS);
    }
}

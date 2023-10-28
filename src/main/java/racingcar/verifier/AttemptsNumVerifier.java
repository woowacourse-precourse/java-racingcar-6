package racingcar.verifier;

public class AttemptsNumVerifier implements Verifier{

    @Override
    public void check(String input) throws IllegalArgumentException {
        checkNumeric(input);
    }
    private void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값은 숫자가 아닙니다.");
        }
    }
}

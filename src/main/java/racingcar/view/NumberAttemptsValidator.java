package racingcar.view;

public class NumberAttemptsValidator implements InputValidator {
    @Override
    public void validate(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid Format");
        }
        if (number < 0) {
            throw new IllegalArgumentException("Invalid Value");
        }
    }
}

package racingcar.domain;

public class ExceptionCase {
    public void inputLength(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
    public void nullInput(String input) {
        if (input == null || input == "") {
            throw new IllegalArgumentException();
        }
    }
}

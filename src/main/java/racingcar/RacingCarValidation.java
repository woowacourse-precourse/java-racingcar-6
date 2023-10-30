package racingcar;

public class RacingCarValidation {
    public void carNameLength(int length) {
        if (length > 5) throw new IllegalArgumentException();

    }

    public int number(String number) {
        if (number.matches("\\d+")) {
            return Integer.parseInt(number);
        }
        throw new IllegalArgumentException();
    }
}

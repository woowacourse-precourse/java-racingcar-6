package racingcar;

public class Time {
    private int count;

    public void inputTime(String input) {
        this.count = toInt(input);
    }

    private int toInt(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        validNumber(number);
        return number;
    }

    private void validNumber(int number) {
        if (!isNaturalNumber(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNaturalNumber(int number) {
        return number > 0;
    }

    public void moveCarsByTime(Cars cars) {
        for (int time = 1; time <= count; time++) {
            cars.moveCars();
        }
    }
}

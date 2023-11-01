package racingcar;

public class Time {
    private final static String RESULT_MESSAGE = "실행 결과";
    private final static int ZERO = 0;
    private static final int ONE = 1;

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
        return number > ZERO;
    }

    public void moveCarsByTime(Cars cars) {
        System.out.println(RESULT_MESSAGE);
        for (int time = ONE; time <= count; time++) {
            cars.moveCars();
            cars.printResult();
        }
    }
}

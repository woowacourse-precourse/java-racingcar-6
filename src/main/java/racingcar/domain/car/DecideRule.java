package racingcar.domain.car;

public class DecideRule implements Rule {
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int STANDARD = 4;

    @Override
    public int getMin() {
        return MIN;
    }

    @Override
    public int getMax() {
        return MAX;
    }

    @Override
    public boolean isSucceed(int input) {
        return input >= STANDARD;
    }
}

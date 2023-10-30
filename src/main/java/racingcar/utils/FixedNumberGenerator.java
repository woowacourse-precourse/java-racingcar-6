package racingcar.utils;

public class FixedNumberGenerator implements NumberGenerator {

    private static final int FIXED_NUMBER = 6;

    @Override
    public int generate() {
        return FIXED_NUMBER;
    }
}

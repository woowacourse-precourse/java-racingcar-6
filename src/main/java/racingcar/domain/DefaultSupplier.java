package racingcar.domain;

import java.util.function.IntSupplier;
import racingcar.utils.RandomNumberGenerator;

public class DefaultSupplier implements IntSupplier {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    @Override
    public int getAsInt() {
        return RandomNumberGenerator.generateInRange(MIN_NUMBER, MAX_NUMBER);
    }
}

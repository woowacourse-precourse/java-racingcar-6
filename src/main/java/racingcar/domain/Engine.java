package racingcar.domain;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import racingcar.utils.RandomNumberGenerator;

public class Engine implements BooleanSupplier {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    public static final int MOVE_THRESHOLD = 4;

    private final IntSupplier intSupplier;

    public Engine() {
        this(() -> RandomNumberGenerator.generateInRange(MIN_NUMBER, MAX_NUMBER));
    }

    public Engine(IntSupplier intSupplier) {
        this.intSupplier = intSupplier;
    }

    // TODO: test 작성
    @Override
    public boolean getAsBoolean() {
        int number = intSupplier.getAsInt();
        return number >= MOVE_THRESHOLD;
    }
}

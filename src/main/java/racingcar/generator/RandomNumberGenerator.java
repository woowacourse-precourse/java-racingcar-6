package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.Supplier;
import racingcar.domain.ForwardCondition;

public class RandomNumberGenerator {

    private static final int STARTING_RANGE = ForwardCondition.STARTING_RANGE.getValue();
    private static final int END_RANGE = ForwardCondition.END_RANGE.getValue();

    private static final Supplier<Integer> supplier = RandomNumberGenerator::generateNumber;

    private RandomNumberGenerator() {
    }

    public static int generateNumber() {
        return Randoms.pickNumberInRange(STARTING_RANGE, END_RANGE);
    }

    public static Supplier<Integer> getGenerateSupplier() {
        return supplier;
    }
}

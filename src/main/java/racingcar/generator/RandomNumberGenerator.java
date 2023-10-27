package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.Supplier;

public class RandomNumberGenerator {

    private static final Supplier<Integer> supplier = RandomNumberGenerator::generateNumber;

    private RandomNumberGenerator() {
    }

    public static int generateNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static Supplier<Integer> getGenerateSupplier() {
        return supplier;
    }
}

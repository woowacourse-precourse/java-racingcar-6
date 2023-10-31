package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.IntSupplier;

public class RandomNumberSupplier implements IntSupplier {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private static RandomNumberSupplier instance;

    private RandomNumberSupplier() {
    }

    public static RandomNumberSupplier getInstance() {
        if (instance == null) {
            instance = new RandomNumberSupplier();
        }
        return instance;
    }

    @Override
    public int getAsInt() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}

package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.IntSupplier;

public class DefaultSupplier implements IntSupplier {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    @Override
    public int getAsInt() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}

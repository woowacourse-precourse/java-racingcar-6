package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.BooleanSupplier;

public class DefaultEngine implements BooleanSupplier {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    public static final int MOVE_THRESHOLD = 4;

    // TODO: test 작성
    @Override
    public boolean getAsBoolean() {
        int pickedRandomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return pickedRandomNumber >= MOVE_THRESHOLD;
    }
}

package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.BooleanSupplier;

public class DefaultEngine implements BooleanSupplier {
    @Override
    public boolean getAsBoolean() {
        int pickedRandomNumber = Randoms.pickNumberInRange(0, 9);
        return pickedRandomNumber >= 4;
    }
}

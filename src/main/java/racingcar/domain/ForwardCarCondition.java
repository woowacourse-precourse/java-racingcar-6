package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class ForwardCarCondition {

    public Map<String, Integer> racingCarCount() {
        RacingValue racingValue = new RacingValue();
        racingValue.racingStatus.forEach((key, value) -> {
            int count = forwardControl(RandomNumber());
            racingValue.racingStatus.put(key, value + count);
        });
        return racingValue.racingStatus;
    }

    public final int RandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public final int forwardControl(int RandomNumber) {
        if (RandomNumber >= 4) {
            return 1;
        }
        return 0;
    }
}

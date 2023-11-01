package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;

public class ForwardCarCondition {

    private final int MIN_PICK_NUMBER = 0;
    private final int MAX_PICK_NUMBER = 9;
    private final int STANDARD_FORWARD = 4;
    private final int FORWARD_NUMBER = 1;
    private final int STOP_NUMBER = 0;


    public LinkedHashMap<String, Integer> racingCarCount() {
        RacingValue.racingStatus.forEach((key, value) -> {
            int count = forwardControl(RandomNumber());
            RacingValue.racingStatus.put(key, value + count);
        });
        return RacingValue.racingStatus;
    }

    public int RandomNumber() {
        return Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER);
    }

    public int forwardControl(int RandomNumber) {
        if (RandomNumber >= STANDARD_FORWARD) {
            return FORWARD_NUMBER;
        }
        return STOP_NUMBER;
    }
}

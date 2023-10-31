package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.common.Config.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbers {
    private final List<Boolean> randomNumberList;

    private RandomNumbers(Integer carCount) {
        randomNumberList = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            randomNumberList.add(ifOverThree());
        }
    }

    public static RandomNumbers createRandomNumbers(Integer carCount) {
        return new RandomNumbers(carCount);
    }

    private boolean ifOverThree() {
        return pickNumberInRange(SMALL_RANDOM_RANGE_NUMBER, BIG_RANDOM_RANGE_NUMBER) >= CAN_FORWARD_NUMBER;
    }

    public List<Boolean> getRandomNumberList() {
        return Collections.unmodifiableList(this.randomNumberList);
    }
}

package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.common.Config;

public class RandomNumbers {
    private final List<Boolean> randomNumberList;

    public RandomNumbers(Integer carCount) {
        randomNumberList = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            randomNumberList.add(ifOverThree());
        }
    }

    private boolean ifOverThree() {
        return pickNumberInRange(0,9) >= Config.FORWARD_NUMBER;
    }

    public List<Boolean> getRandomNumberList() {
        return Collections.unmodifiableList(this.randomNumberList);
    }
}

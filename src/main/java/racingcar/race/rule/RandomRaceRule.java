package racingcar.race.rule;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.Application;
import racingcar.car.model.Car;

public class RandomRaceRule implements RaceRule {

    private final int movableLimit;
    private final int minRangeNumber;
    private final int maxRangeNumber;

    public RandomRaceRule(int movableLimit, int minRangeNumber, int maxRangeNumber) {
        this.movableLimit = movableLimit;
        this.minRangeNumber = minRangeNumber;
        this.maxRangeNumber = maxRangeNumber;
    }

    public boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(minRangeNumber, maxRangeNumber);
        return movableLimit < randomNumber;
    }

}

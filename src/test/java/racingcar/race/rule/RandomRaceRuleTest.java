package racingcar.race.rule;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.model.Car;
import racingcar.car.model.CarName;
import racingcar.car.model.RacingCar;

class RandomRaceRuleTest {

    RaceRule randomRaceRule;

    @BeforeEach
    void init(){
        int movableLimit = 3;
        int minRangeNumber = 0;
        int maxRangeNumber = 9;

        randomRaceRule = new RandomRaceRule(movableLimit, minRangeNumber, maxRangeNumber);
    }
    @Test
    void test() {
        randomRaceRule.isMovable();
    }

}
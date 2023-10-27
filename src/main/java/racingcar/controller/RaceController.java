package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

public class RaceController {
    private static final int RANGE_START_NUMBER = 0;
    private static final int RANGE_END_NUMBER = 9;

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(RANGE_START_NUMBER, RANGE_END_NUMBER);
    }

}

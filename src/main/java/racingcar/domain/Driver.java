package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Driver {
    private final int RANDOM_NUMBER_MIN_VALUE = 0;
    private final int RANDOM_NUMBER_MAX_VALUE = 9;

    public void drive(Car car) {
        car.move(drivingSkill());
    }

    private int drivingSkill() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_VALUE, RANDOM_NUMBER_MAX_VALUE);
    }
}

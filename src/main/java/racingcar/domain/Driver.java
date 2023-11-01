package racingcar.domain;

import static racingcar.constants.DomainConstant.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Driver {
    public void drive(Car car) {
        car.move(calculateDrivingSkill());
    }

    private int calculateDrivingSkill() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_VALUE,
                RANDOM_NUMBER_MAX_VALUE);
    }
}
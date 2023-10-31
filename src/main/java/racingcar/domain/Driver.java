package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import constants.DomainConstant;

public class Driver {
    public void drive(Car car) {
        car.move(calculateDrivingSkill());
    }

    private int calculateDrivingSkill() {
        return Randoms.pickNumberInRange(DomainConstant.RANDOM_NUMBER_MIN_VALUE,
                DomainConstant.RANDOM_NUMBER_MAX_VALUE);
    }
}

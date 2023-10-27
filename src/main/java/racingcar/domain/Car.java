package racingcar.domain;

import static racingcar.domain.DomainConstant.RANDOM_NUMBER_LAST_RANGE;
import static racingcar.domain.DomainConstant.RANDOM_NUMBER_START_RANGE;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final StringBuilder stopOrMoveDecisionResult;
    private final String carName;

    public Car(String carName) {
        this.carName = carName;
        stopOrMoveDecisionResult = new StringBuilder();
    }

    private int creatRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START_RANGE, RANDOM_NUMBER_LAST_RANGE);
    }

    @Override
    public String toString() {
        return carName;
    }
}

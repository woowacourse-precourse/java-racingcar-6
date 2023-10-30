package racingcar;

import static racingcar.RandomNumberRange.MAXIMUM_RANGE_VALUE;
import static racingcar.RandomNumberRange.MINIMUM_RANGE_VALUE;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_RANGE_VALUE.getValue(), MAXIMUM_RANGE_VALUE.getValue());
    }
}

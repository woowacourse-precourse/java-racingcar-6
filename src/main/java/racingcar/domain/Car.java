package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigInteger;

import static racingcar.util.Consts.START_INCLUSIVE;
import static racingcar.util.Consts.END_INCLUSIVE;
import static racingcar.util.Consts.MOVEMENT_CRITERIA;
import static racingcar.util.Consts.MOVEMENT_DISTANCE;

public class Car {
    private String name;
    private BigInteger distance;

    private Car(String name) {
        this.name = name;
    }

    public static Car createCar(String name) {
        Car car = new Car(name);
        car.distance = BigInteger.ZERO;
        return car;
    }

    public BigInteger raceOneRoundAndGetDistance() {
        int randomResult = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        if (randomResult >= MOVEMENT_CRITERIA) {
            distance = distance.add(BigInteger.valueOf(MOVEMENT_DISTANCE));
        }
        return distance;
    }
}

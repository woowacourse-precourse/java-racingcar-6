package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private Name name;

    private Distance distance;

    public void move() {
        if (getRandomNumber() >= 4) {
            distance.add(1);
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isEqualOrGreaterThan(Car otherCar) {
        return distance.getDistance() >= otherCar.distance.getDistance();
    }
}
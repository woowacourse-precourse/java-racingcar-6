package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CarManager {
    private static final int MAX_RANDOM = 9;
    private static final int MIN_RANDOM = 0;
    private static final int SATISFY_FOR_MOVE = 4;

    private Car car;

    public CarManager(Car car) {
        this.car = car;
    }

    public void moveIfSatisfy() {
        if (createRandomNumber() >= SATISFY_FOR_MOVE) {
            car.move();
        }
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
    }
}

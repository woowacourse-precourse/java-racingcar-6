package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final int INITIAL_FORWARD_COUNT = 0;
    private String carName;
    private int forwardCount;

    public Car(String carName) {
        this.carName = carName;
        this.forwardCount = INITIAL_FORWARD_COUNT;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void forwardCar(int randomNumber) {
        if (randomNumber >= 4) {
            forwardCount += 1;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}

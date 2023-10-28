package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String carName;
    private int carPosition;

    public Car(String carName) {
        this.carName = carName;
        this.carPosition = 0;
    }

    public String carName() {
        return carName;
    }

    public int carPosition() {
        return carPosition;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            carPosition++;
        }
    }
}

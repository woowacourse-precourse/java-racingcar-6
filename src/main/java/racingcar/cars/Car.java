package racingcar.cars;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String carName;
    private int moveDistance;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getName() {
        return carName;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void move(int parameter) {
        moveDistance += calculateDistance(parameter);
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private int calculateDistance(int parameter) {
        if (parameter >= 4) {
            return 1;
        }
        return 0;
    }
}

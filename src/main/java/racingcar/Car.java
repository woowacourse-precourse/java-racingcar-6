package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward() {
        int randomNumber = Randoms.pickNumberInRange(Constant.MINIMUM_RANDOM_NUMBER, Constant.MAXIMUM_RANDOM_NUMBER);
        if (randomNumber >= Constant.RANDOM_NUMBER_THRESHOLD) {
            this.position++;
        }
    }
}

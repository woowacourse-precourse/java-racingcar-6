package racingcar.domain;

import racingcar.utils.RandomUtils;

public class Car {
    private final CarName name;
    private int position = 0;

    public Car(CarName carName) {
        this.name = carName;
    }

    public String getName() {
        return name.getName();
    }

    public void move(int randomNumber) {
        if (RandomUtils.isMove(randomNumber)) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}

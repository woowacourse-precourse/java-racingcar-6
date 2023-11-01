package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        if (makeRandomValue() >= 4) {
            position++;
        }
    }

    private int makeRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

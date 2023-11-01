package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String carName;
    private int position;

    Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }
    Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }
    public String getName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }

    public int move() {
        int judge = Randoms.pickNumberInRange(0, 9);
        if (judge >= 4) {
            position++;
        }
        return position;
    }
}
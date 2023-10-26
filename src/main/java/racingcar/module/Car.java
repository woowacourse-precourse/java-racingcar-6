package racingcar.module;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    static int STOP_THRESHOLD = 3;
    String name;
    int pos;

    public Car(String name) {
        this.name = name;
        this.pos = 0;
    }

    public void turnAction() {
        if (Randoms.pickNumberInRange(0, 9) > STOP_THRESHOLD) {
            move();
        }
    }

    void move() {
        this.pos++;
    }

    int getPos() {
        return pos;
    }

    String getName() {
        return name;
    }

}

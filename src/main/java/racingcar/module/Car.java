package racingcar.module;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    String name;
    int pos;

    Car(String name) {
        this.name = name;
        this.pos = 0;
    }

    public void turnAction() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
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

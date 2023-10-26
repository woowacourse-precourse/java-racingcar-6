package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;

    Car(String name) {
        this.name = name;
    }

    public boolean move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            return true;
        }
        return false;
    }
}

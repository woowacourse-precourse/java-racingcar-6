package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public String name;
    public int distance = 0;
    Car(String name) {
        this.name = name;
    }

    public int pickNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    public boolean move() {
        int pickNum = pickNumber();
        if (pickNum >= 4) return true;
        return false;
    }
}

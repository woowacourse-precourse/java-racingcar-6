package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    String moved;

    public Car(String name) {
        this.name = name;
        this.moved = "";
    }

    void move() {
        int picked = Randoms.pickNumberInRange(0, 9);
        if (picked >= 4) {

            this.moved += "-";
        }
    }

    @Override
    public String toString() {
        return this.name + " : " + moved;
    }
}

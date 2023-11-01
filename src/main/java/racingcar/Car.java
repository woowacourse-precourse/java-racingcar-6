package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int count;
    boolean win;

    public Car(String name) {
        this.name = name;
        this.count = 0;
        this.win = false;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.count++;
        }
    }

}

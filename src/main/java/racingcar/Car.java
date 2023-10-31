package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    final private String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            location++;
        }
    }
}

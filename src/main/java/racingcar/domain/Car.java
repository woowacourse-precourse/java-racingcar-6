package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public String name;
    public int position;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        int value = Randoms.pickNumberInRange(0,9);
        if (value >= 4) {
            this.position++;
        }
    }
}

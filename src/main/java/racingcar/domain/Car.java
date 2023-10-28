package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private Integer moveDistance;

    public Car(String name) {
        this.name = name;
        this.moveDistance = 0;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(1,9);
        if (randomValue >= 4) {
            this.moveDistance += 1;
        }
    }
}

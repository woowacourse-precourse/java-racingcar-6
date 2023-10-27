package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public String name;
    public int mileage;

    public Car(String name) {
        this.name = name;
        this.mileage = 0;
    }

    public void moveForward() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            ++this.mileage;
        }
    }
}

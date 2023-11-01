package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private Name name;
    private int position = 0;

    public Car(String carName) {
        this.name = new Name(carName);
    }

    public void move() {
        int randomResult = Randoms.pickNumberInRange(0, 9);
        if (4 <= randomResult) {
            this.position++;
        }
    }

}

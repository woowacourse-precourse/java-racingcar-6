package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public int randomDrive() {

        if (Randoms.pickNumberInRange(0, 9)>=4) {
            this.location++;
        }
        return this.location;
    }
}

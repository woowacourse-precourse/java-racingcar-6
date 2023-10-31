package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getInfo() {
        return this.name + " : " + ("-".repeat(this.position));
    }

    public Car movePosition() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.position += 1;
            return this;
        }

        return this;
    }
}

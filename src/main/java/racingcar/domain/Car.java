package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String NAME;
    private int position = 0;

    public Car(String name, int position) {
        this.NAME = name;
        this.position = position;
    }

    public String getName() {
        return NAME;
    }

    public int getPosition() {
        return position;
    }

    public int move() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (randomNumber >= 4) {
            position++;
        }
        return position;
    }
}

package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Constants;

public class Car {
    private final String NAME;
    private int position;

    private Car(String name) {
        this.NAME = name;
        this.position = 0;
    }

    public static Car nameOf(String name) {
        return new Car(name);
    }

    public String getName() {
        return NAME;
    }

    public int getPosition() {
        return position;
    }
    public void move() {

        int randomNumber = Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUM, Constants.MAX_RANDOM_NUM);
        if (randomNumber >= Constants.START_NUM) {
            position++;
        }
    }
}

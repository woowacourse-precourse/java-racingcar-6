package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.option.GameOption;

public class Car {
    private final String name;
    private int moveStatus = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (Randoms.pickNumberInRange(GameOption.MINIMUM_NUMBER, GameOption.MAXIMUM_NUMBER)
                >= GameOption.STANDARD_NUMBER) {
            moveStatus++;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveStatus() {
        return moveStatus;
    }
}

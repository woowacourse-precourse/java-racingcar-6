package racingcar.domain;

import static racingcar.constant.GameOptions.CRITERIA;
import static racingcar.constant.GameOptions.MAX_RANDOM_NUMBER;
import static racingcar.constant.GameOptions.MIN_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private Integer position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public boolean checkRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        return randomNumber >= CRITERIA;
    }

    public void moveForward() {
        position++;
    }
}

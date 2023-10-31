package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.constant.Constant;
import racingcar.utils.validation.InputValidation;

public class Car {
    private String name;
    private int moveCount = 0;

    public Car(String name) {
        InputValidation.validateNameLength(name);
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= Constant.MOVE_NUMBER) {
            this.moveCount++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
